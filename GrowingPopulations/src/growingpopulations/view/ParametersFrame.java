package growingpopulations.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;

public class ParametersFrame extends JFrame {

    private final JPanel mainPanel;
    private final JButton updateButton;
    private JSlider simulationInterval, rabbitsCount, wolvesCount, mapWidth, mapHeight;
    private JSlider reproducingSlider, grassGrowingSlider, starvingSlider;

    public ParametersFrame() {
        super("Parametry symulacji");
        this.mainPanel = new JPanel(new BorderLayout());
        this.updateButton = new JButton("Aktualizuj");

        JPanel simulationPanel = new JPanel(new GridLayout(0, 2));
        simulationPanel.add(getParametersPanel());
        simulationPanel.add(getFactorsPanel());

        mainPanel.add(updateButton, BorderLayout.SOUTH);
        mainPanel.add(simulationPanel, BorderLayout.CENTER);
        this.add(mainPanel);

        this.setLocation(800, 0);
        this.setMinimumSize(new Dimension(500, 600));
    }

    private JPanel getParametersPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new TitledBorder("Parametry"));

        simulationInterval = createSlider(0, 3000);
        simulationInterval.setBorder(new TitledBorder("Prędkość symulacji [ms]"));

        mapWidth = createSlider(5, 50);
        mapWidth.setBorder(new TitledBorder("Szerokość mapy"));
        mapWidth.addChangeListener((ChangeEvent e) -> {
            updateOnMapResize();
        });

        mapHeight = createSlider(5, 50);
        mapHeight.setBorder(new TitledBorder("Wysokość mapy"));
        mapHeight.addChangeListener((ChangeEvent e) -> {
            updateOnMapResize();
        });

        rabbitsCount = createSlider(0, calculateMaxRabbitCount());
        rabbitsCount.setBorder(new TitledBorder("Liczba królików"));

        wolvesCount = createSlider(0, calculateMaxWolvesCount());
        wolvesCount.setBorder(new TitledBorder("Liczba wilków"));

        panel.add(simulationInterval);
        panel.add(mapWidth);
        panel.add(mapHeight);
        panel.add(rabbitsCount);
        panel.add(wolvesCount);

        return panel;
    }

    private JPanel getFactorsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new TitledBorder("Wspołczynniki"));

        reproducingSlider = createSlider(0, 100);
        reproducingSlider.setBorder(new TitledBorder("Szansa rozmnożenia"));

        grassGrowingSlider = createSlider(0, 100);
        grassGrowingSlider.setBorder(new TitledBorder("Procent wzrostu trawy"));

        starvingSlider = createSlider(0, 100);
        starvingSlider.setBorder(new TitledBorder("Wpływ głodu"));

        panel.add(reproducingSlider);
        panel.add(grassGrowingSlider);
        panel.add(starvingSlider);

        return panel;
    }

    private JSlider createSlider(int min, int max) {
        JSlider slider = new JSlider(min, max);
        slider.setMajorTickSpacing((max - min) / 5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    public void addUpdateButtonListener(ActionListener listenForUpdate) {
        updateButton.addActionListener(listenForUpdate);
    }

    public void initSliderValues(int simulationInterval, int rabbitsCount, int wolvesCount,
            int mapWidth, int mapHeight) {
        this.simulationInterval.setValue(simulationInterval);
        this.rabbitsCount.setValue(rabbitsCount);
        this.wolvesCount.setValue(wolvesCount);
        this.mapWidth.setValue(mapWidth);
        this.mapHeight.setValue(mapHeight);
    }

    private void updateOnMapResize() {
        int maxWolvesCount = calculateMaxWolvesCount();
        wolvesCount.setMaximum(maxWolvesCount);
        wolvesCount.createStandardLabels(maxWolvesCount / 5);
        wolvesCount.setMajorTickSpacing(maxWolvesCount / 5);

        int maxRabbitsCount = calculateMaxRabbitCount();
        rabbitsCount.setMaximum(maxRabbitsCount);
        rabbitsCount.createStandardLabels(maxRabbitsCount / 5);
        rabbitsCount.setMajorTickSpacing(maxRabbitsCount / 5);
    }

    private int calculateMaxWolvesCount() {
        return (int) Math.ceil(getMapWidth() * getMapHeight() * 0.2);
    }

    private int calculateMaxRabbitCount() {
        return (int) Math.ceil(getMapWidth() * getMapHeight() * 0.5);
    }

    // ----------------------- getters & setters --------------------------
    public int getSimulationInterval() {
        return simulationInterval.getValue();
    }

    public int getRabbitsCount() {
        return rabbitsCount.getValue();
    }

    public int getWolvesCount() {
        return wolvesCount.getValue();
    }

    public int getMapWidth() {
        return mapWidth.getValue();
    }

    public int getMapHeight() {
        return mapHeight.getValue();
    }

}
