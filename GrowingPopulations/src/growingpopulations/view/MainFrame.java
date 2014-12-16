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
    private final JPanel simulationPanel;
    private Plot plot;
    private final MapPanel mapPanel;
    private final JButton startPauseButton;

    public MainFrame(String title) {
        super(title);
        this.simulationPanel = new JPanel();
        this.plot = new Plot("czas", "liczebność");
        this.mapPanel = new MapPanel();
        this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        this.menu = new MenuBarImplementation();
        this.startPauseButton = new JButton();

        this.simulationPanel.setLayout(new BorderLayout());
        this.simulationPanel.setMinimumSize(new Dimension(0, 200));
        this.simulationPanel.add(startPauseButton, BorderLayout.NORTH);
        this.simulationPanel.add(splitPane, BorderLayout.CENTER);

        this.plot.setPreferredSize(new Dimension(0, 200));

        this.splitPane.setTopComponent(mapPanel);
        this.splitPane.setBottomComponent(plot);
        this.splitPane.setResizeWeight(1);

        initFrame();
    }

    public void resetPlot() {
        this.plot = new Plot("czas", "liczebność");
        this.plot.setPreferredSize(new Dimension(0, 200));
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

    public Plot getPlot() {
        return plot;
    }

}
