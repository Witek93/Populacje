package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSplitPane;
import populacje.Parameters;

public class SimulationSplitPane extends JSplitPane implements Runnable {

    OptionPanel optionPanel;

    public SimulationSplitPane() throws InterruptedException {
        super(JSplitPane.HORIZONTAL_SPLIT);

        this.setResizeWeight(1);

        this.setLeftComponent(SimulationViewPanel.getInstance());

        optionPanel = new OptionPanel();
        this.setRightComponent(optionPanel);

    }

    @Override
    public void run() {
        Thread thread = new Thread(Parameters.getAlgorithm());

        while (true) {
            if (Parameters.getInstance().wasResetPressed()) {
                thread.stop();
                thread = new Thread(Parameters.getAlgorithm());
                thread.start();
                Parameters.getInstance().setReset(false);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulationSplitPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
