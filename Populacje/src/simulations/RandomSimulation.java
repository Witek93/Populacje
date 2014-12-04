package simulations;

import GUI.MapPanel;
import GUI.SimulationViewPanel;
import GUI.plots.Plot;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
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
        MapPanel.getInstance().setAnimalFields(this.random());
        SimulationViewPanel.getInstance().updateComponents();
    }

    private HashMap<Point, Animal> random() {
        HashMap<Point, Animal> result = new HashMap<>();
        ArrayList<Point> points = getAvailableSpacePoints();

        for (int i = 0; i < Parameters.getInstance().getRabbitsCount(); i++) {
            result.put(points.get(generator.nextInt(points.size())), new Rabbit());
        }

        for (int i = 0; i < Parameters.getInstance().getWolvesCount(); i++) {
            result.put(points.get(generator.nextInt(points.size())), new Wolf());
        }

        return result;
    }

    private ArrayList<Point> getAvailableSpacePoints() {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < Parameters.getInstance().getMapWidth(); i++) {
            for (int j = 0; j < Parameters.getInstance().getMapHeight(); j++) {
                points.add(new Point(i, j));
            }
        }
        return points;
    }

    private void updatePlot(int i) {
        Plot.getInstance().getSeries("króliki").appendPoint(i, Parameters.getInstance().getRabbitsCount());
        Plot.getInstance().getSeries("wilki").appendPoint(i, Parameters.getInstance().getWolvesCount());
    }

    @Override
    public void simulate() throws InterruptedException {
        initEnvironment();

        for (int i = 0;;) {
            if (Parameters.getInstance().isStarted()) {
                updatePlot(i);
                Thread.sleep(1000);
                i++;
            } else {
                Thread.sleep(100);
            }
        }
    }

    @Override
    public void run() {
        try {
            simulate();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
