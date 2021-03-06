package growingpopulations.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;

public class ParametersFrame extends JFrame {

    private final JButton updateButton, resetButton;
    private JSlider rabbitsCount, wolvesCount,
            mapWidth, mapHeight,
            simulationInterval, growGrass,
            wolfReproduce, wolfStarve,
            rabbitReproduce, rabbitStarve;
    private JCheckBox reproduceCheckbox, starveCheckbox, growGrassCheckbox;

    public ParametersFrame() {
        super("Parametry symulacji");
        this.updateButton = new JButton("Aktualizuj");
        this.resetButton = new JButton("Resetuj");

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 0));
        buttonsPanel.add(updateButton);
        buttonsPanel.add(resetButton);

        JPanel parametersPanel = new JPanel(new GridLayout(2, 0));
        parametersPanel.add(createResetPanel());
        parametersPanel.add(createUpdatePanel());

        JPanel animalRatiosPanel = new JPanel(new GridLayout(2, 0));
        animalRatiosPanel.add(createWolfRatio());
        animalRatiosPanel.add(createRabbitRatio());

        JPanel ratiosPanel = new JPanel(new BorderLayout());
        ratiosPanel.add(animalRatiosPanel, BorderLayout.CENTER);
        ratiosPanel.add(createCheckboxesPanel(), BorderLayout.NORTH);

        JPanel simulationPanel = new JPanel(new GridLayout(1, 0));
        simulationPanel.add(parametersPanel);
        simulationPanel.add(ratiosPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(simulationPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        this.add(mainPanel);
        this.setLocation(800, 0);
        this.setMinimumSize(new Dimension(500, 700));
    }

    private JPanel createResetPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new TitledBorder("Parametry"));

        mapWidth = createSlider(5, 50);
        mapWidth.setBorder(new TitledBorder("Liczba wierszy"));
        mapWidth.addChangeListener((ChangeEvent e) -> {
            updateOnMapResize();
        });
        mapHeight = createSlider(5, 50);
        mapHeight.setBorder(new TitledBorder("Liczba kolumn"));
        mapHeight.addChangeListener((ChangeEvent e) -> {
            updateOnMapResize();
        });
        rabbitsCount = createSlider(0, calculateMaxRabbitCount());
        rabbitsCount.setBorder(new TitledBorder("Liczba królików"));
        wolvesCount = createSlider(0, calculateMaxWolvesCount());
        wolvesCount.setBorder(new TitledBorder("Liczba wilków"));

        panel.add(mapWidth);
        panel.add(mapHeight);
        panel.add(rabbitsCount);
        panel.add(wolvesCount);

        return panel;
    }

    private JPanel createUpdatePanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        simulationInterval = createSlider(0, 3000);
        simulationInterval.setBorder(new TitledBorder("Prędkość symulacji [ms]"));
        growGrass = createSlider(0, 100);
        growGrass.setBorder(new TitledBorder("Procent wzrostu trawy"));

        panel.add(simulationInterval);
        panel.add(growGrass);

        return panel;
    }

    private JPanel createCheckboxesPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(new TitledBorder("Uwzględnij"));
        reproduceCheckbox = new JCheckBox("rozmnażanie", true);
        starveCheckbox = new JCheckBox("głód", true);
        growGrassCheckbox = new JCheckBox("przyrost trawy", true);

        panel.add(reproduceCheckbox);
        panel.add(starveCheckbox);
        panel.add(growGrassCheckbox);
        return panel;
    }

    private JPanel createWolfRatio() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new TitledBorder("Wilk"));

        wolfReproduce = createSlider(0, 100);
        wolfReproduce.setBorder(new TitledBorder("Szansa rozmnożenia"));

        wolfStarve = createSlider(0, 100);
        wolfStarve.setBorder(new TitledBorder("Wpływ głodu"));

        panel.add(wolfReproduce);
        panel.add(wolfStarve);

        return panel;
    }

    private JPanel createRabbitRatio() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new TitledBorder("Królik"));

        rabbitReproduce = createSlider(0, 100);
        rabbitReproduce.setBorder(new TitledBorder("Szansa rozmnożenia"));

        rabbitStarve = createSlider(0, 100);
        rabbitStarve.setBorder(new TitledBorder("Wpływ głodu"));

        panel.add(rabbitReproduce);
        panel.add(rabbitStarve);

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

    public void addResetButtonListener(ActionListener listerForReset) {
        resetButton.addActionListener(listerForReset);
    }

    public void initResetSliders(int rabbitsCount, int wolvesCount,
            int mapWidth, int mapHeight) {
        this.rabbitsCount.setValue(rabbitsCount);
        this.wolvesCount.setValue(wolvesCount);
        this.mapWidth.setValue(mapWidth);
        this.mapHeight.setValue(mapHeight);
    }

    public void initUpdateSliders(int simulationInterval, int growGrass) {
        this.simulationInterval.setValue(simulationInterval);
        this.growGrass.setValue(growGrass);
    }

    public void initRabbitRatios(int reproducingRatio, int starveRatio) {
        this.rabbitReproduce.setValue(reproducingRatio);
        this.rabbitStarve.setValue(starveRatio);
    }

    public void initWolfRatios(int reproducingRatio, int starveRatio) {
        this.wolfReproduce.setValue(reproducingRatio);
        this.wolfStarve.setValue(starveRatio);
    }

    public void initCheckboxes(boolean canReproduce,
            boolean canStarve, boolean canGrowGrass) {
        this.reproduceCheckbox.setSelected(canReproduce);
        this.starveCheckbox.setSelected(canStarve);
        this.growGrassCheckbox.setSelected(canGrowGrass);
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

    public int getSimulationInterval() {
        return simulationInterval.getValue();
    }

    public double getWolfReproduceRatio() {
        return wolfReproduce.getValue() * 0.01;
    }

    public double getWolfStarveRatio() {
        return wolfStarve.getValue() * 0.01;
    }

    public double getRabbitReproduceRatio() {
        return rabbitReproduce.getValue() * 0.01;
    }

    public double getRabbitStarveRatio() {
        return rabbitStarve.getValue() * 0.01;
    }

    public double getGrowGrassRatio() {
        return growGrass.getValue() * 0.01;
    }

    public boolean canReproduce() {
        return reproduceCheckbox.isSelected();
    }

    public boolean canStarve() {
        return starveCheckbox.isSelected();
    }

    public boolean canGrowGrass() {
        return growGrassCheckbox.isSelected();
    }

}
