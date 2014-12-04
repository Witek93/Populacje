package simulations;

import GUI.MapPanel;
import GUI.SimulationViewPanel;
import GUI.plots.Plot;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import populacje.Parameters;
import species.Animal;
import species.Rabbit;
import species.Wolf;

public class RandomSimulation implements Algorithm, Runnable {

    final static private Random generator = new Random();

    public RandomSimulation() {
    }

    private void initEnvironment() throws InterruptedException {
        Parameters.update();
        Plot.reset();
        MapPanel.reset();
        MapPanel.getInstance().setAnimalFields(initRandomly());
        SimulationViewPanel.getInstance().updateComponents();
    }

    private HashMap<Point, Animal> initRandomly() {
        HashMap<Point, Animal> result = new HashMap<>();
        ArrayList<Point> points = getAvailableSpacePoints();
        int index;

        for (int i = 0; i < Parameters.getRabbitsCount(); i++) {
            index = generator.nextInt(points.size());
            result.put(points.get(index), new Rabbit());
            points.remove(index);
        }

        for (int i = 0; i < Parameters.getWolvesCount(); i++) {
            index = generator.nextInt(points.size());
            result.put(points.get(index), new Wolf());
            points.remove(index);
        }

        return result;
    }

    private ArrayList<Point> getAvailableSpacePoints() {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < Parameters.getMapWidth(); i++) {
            for (int j = 0; j < Parameters.getMapHeight(); j++) {
                points.add(new Point(i, j));
            }
        }
        return points;
    }

    private void updatePlot(int i) {
        synchronized (Plot.class) {
            Plot.getInstance().getSeries("króliki").add(i, Parameters.getRabbitsCount());
            Plot.getInstance().getSeries("wilki").add(i, Parameters.getWolvesCount());
        }
    }

    @Override
    public void simulate() {
        List<Point> animalCords = MapPanel.getInstance().getAnimals();
        for (Point point : animalCords) {
            MapPanel.getInstance().moveAnimal(point.x, point.y, MapPanel.Direction.SOUTH);
        }
    }

    @Override
    public void run() {
        try {
            initEnvironment();

            for (int i = 0;;) {
                if (Parameters.isStarted()) {
                    updatePlot(i);
                    simulate();
                    SimulationViewPanel.getInstance().repaintMapPanel();
                    Thread.sleep(500);
                    i++;
                } else {
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
