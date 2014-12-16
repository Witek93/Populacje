package growingpopulations.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {

    private final ParametersFrame parametersFrame;
    private Plot plot;
    private final MapPanel mapPanel;
    private final JButton startPauseButton;

    public MainFrame(String title) {
        super(title);
        this.plot = new Plot("czas", "liczebność");
        this.mapPanel = new MapPanel();
        this.startPauseButton = new JButton();
        this.parametersFrame = new ParametersFrame();

        //init menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Ustawienia");
        MenuItem open = new MenuItem("Parametry");
        open.addActionListener((ActionEvent e) -> {
            parametersFrame.setVisible(true);
        });
        open.setShortcut(new MenuShortcut('O'));

        menu.add(open);
        menuBar.add(menu);
        this.setMenuBar(menuBar);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(mapPanel);
        splitPane.setBottomComponent(plot);
        splitPane.setResizeWeight(1);

        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new BorderLayout());
        simulationPanel.setMinimumSize(new Dimension(0, 200));
        simulationPanel.add(startPauseButton, BorderLayout.NORTH);
        simulationPanel.add(splitPane, BorderLayout.CENTER);
        this.add(simulationPanel);

        this.plot.setPreferredSize(new Dimension(0, 200));

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
    }

    public void addStartPauseButtonListener(ActionListener listenForUpdate) {
        for (ActionListener listener : startPauseButton.getActionListeners()) {
            startPauseButton.removeActionListener(listener);
        }
        startPauseButton.addActionListener(listenForUpdate);
    }

    // ------------------------- getters & setters --------------------------
    public ParametersFrame getParametersFrame() {
        return this.parametersFrame;
    }

    public JButton getStartPauseButton() {
        return startPauseButton;
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }

    public Plot getPlot() {
        return plot;
    }

}
