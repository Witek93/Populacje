package growingpopulations;

import growingpopulations.view.MainFrame;
import growingpopulations.model.Model;
import growingpopulations.controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrowingPopulations implements Runnable {

    MainFrame view;
    Model model;
    Controller controller;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new GrowingPopulations());
        thread.start();
    }

    public GrowingPopulations() {
        this.view = new MainFrame("Symulacje populacji");
        this.model = new Model();
        this.controller = new Controller(this.view, this.model);
        this.view.getMapPanel().generateMapPanel(this.model.getMapWidth(), this.model.getMapHeight());
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (this.model.isStarted()) {
                    this.controller.simulate();
                    this.controller.updatePlot();
                    Thread.sleep(this.model.getSimulationInterval());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(GrowingPopulations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
