package GUI;

import javax.swing.JFrame;

public class SimulationWindow extends JFrame implements Runnable {

    SimulationSplitPane simulationPane;

    public SimulationWindow() throws InterruptedException {
        super("Symulacja");

        simulationPane = new SimulationSplitPane();
        this.add(simulationPane);

    }

    private void init() {
        this.setName("Symulacje populacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
    }

    @Override
    public void run() {
        init();
        
        Thread thread = new Thread(simulationPane);
        thread.start();

        this.setVisible(true);
    }

}
