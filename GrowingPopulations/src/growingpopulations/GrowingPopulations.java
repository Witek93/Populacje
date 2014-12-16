package growingpopulations;

import growingpopulations.view.MainFrame;
import growingpopulations.model.Model;
import growingpopulations.controller.Controller;

public class GrowingPopulations {

    MainFrame view;
    Model model;
    Controller controller;

    public static void main(String[] args) throws InterruptedException {
        GrowingPopulations instance = new GrowingPopulations();
        Thread thread = new Thread(instance.controller);
        thread.start();
    }

    public GrowingPopulations() {
        this.view = new MainFrame("Symulacje populacji");
        this.model = new Model();
        this.controller = new Controller(this.view, this.model);
    }

}
