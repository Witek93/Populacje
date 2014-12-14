package growingpopulations.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {

    private final MenuBarImplementation menu;
    private final JSplitPane splitPane;
    private final JPanel simulationPanel, plotPanel; //TODO wykres
    private final MapPanel mapPanel;
    private final JButton startPauseButton;

    public MainFrame(String title) {
        super(title);
        this.simulationPanel = new JPanel();
        this.plotPanel = new JPanel();
        this.mapPanel = new MapPanel();
        this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        this.menu = new MenuBarImplementation();
        this.startPauseButton = new JButton();

        initSimulationPanel();
        initPlotPanel();
        initSplitPane();
        initFrame();
    }

    private void initPlotPanel() {
        this.plotPanel.setMinimumSize(new Dimension(0, 200));
    }

    private void initSplitPane() {
        this.splitPane.setTopComponent(mapPanel);
        this.splitPane.setBottomComponent(plotPanel);
        this.splitPane.setResizeWeight(1);
    }

    private void initSimulationPanel() {
        this.simulationPanel.setLayout(new BorderLayout());
        this.simulationPanel.add(startPauseButton, BorderLayout.NORTH);
        this.simulationPanel.add(splitPane, BorderLayout.CENTER);
    }

    private void initFrame() {
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMenuBar(menu);
        this.add(simulationPanel);
    }

    public void addStartPauseButtonListener(ActionListener listenForUpdate) {
        for (ActionListener listener : startPauseButton.getActionListeners()) {
            startPauseButton.removeActionListener(listener);
        }
        startPauseButton.addActionListener(listenForUpdate);
    }

    // ------------------------- getters & setters --------------------------
    public ParametersFrame getParametersFrame() {
        return menu.getParametersFrame();
    }

    public MenuBarImplementation getMenu() {
        return menu;
    }

    public JButton getStartPauseButton() {
        return startPauseButton;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }

}
