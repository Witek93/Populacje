package growingpopulations;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GrowingPopulations implements Runnable {

    MainFrame mainFrame;
    Model model;
    Controller controller;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new GrowingPopulations());
        thread.start();
    }

    public GrowingPopulations() {
        this.mainFrame = new MainFrame("Symulacje populacji");
        this.model = new Model();
        this.controller = new Controller(this.mainFrame, this.model);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Tested properly");
            } catch (InterruptedException ex) {
                Logger.getLogger(GrowingPopulations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
