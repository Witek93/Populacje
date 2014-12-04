package GUI;

import GUI.plots.Plot;
import javax.swing.JSplitPane;

public final class SimulationViewPanel extends JSplitPane {

    static private volatile SimulationViewPanel instance;

    public SimulationViewPanel() {
        super(JSplitPane.VERTICAL_SPLIT);
        this.setResizeWeight(1);
        this.updateComponents();
    }

    public static SimulationViewPanel getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (Plot.class) {
                if (instance == null) {
                    instance = new SimulationViewPanel();
                }
            }
        }
        return instance;
    }

    public void updateComponents() {
        this.removeAll();
        this.setTopComponent(MapPanel.getInstance());
        this.setBottomComponent(Plot.getInstance());
    }

}
