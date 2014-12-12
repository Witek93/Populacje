package growingpopulations;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class ParametersFrame extends JFrame {

    private JPanel panel;
    private JSlider simulationSpeed;
    private JSlider rabbitsCount;
    private JSlider wolvesCount;
    private JButton updateButton;

    public ParametersFrame() {
        this.panel = new JPanel(new GridLayout(0, 1));
        this.updateButton = new JButton("Aktualizuj");
        
        initPanel();
        
        this.setLocation(100, 100);
        this.setMinimumSize(new Dimension(300, 300));

    }

    private void initPanel() {

        initSliders();

        panel.add(simulationSpeed);
        panel.add(rabbitsCount);
        panel.add(wolvesCount);

        panel.add(updateButton);

        this.add(panel);
    }

    private void initSliders() {
        simulationSpeed = createSlider(50, 3000, 200);
        simulationSpeed.setBorder(new TitledBorder("Prędkość symulacji [ms]"));

        rabbitsCount = createSlider(0, 100, 50);
        rabbitsCount.setBorder(new TitledBorder("Liczba królików"));

        wolvesCount = createSlider(0, 100, 50);
        wolvesCount.setBorder(new TitledBorder("Liczba wilków"));
    }

    private JSlider createSlider(int min, int max, int value) {
        JSlider slider = new JSlider(min, max, value);
        slider.setMajorTickSpacing((max - min) / 5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    public void addUpdateListener(ActionListener listenForUpdateButton) {
        updateButton.addActionListener(listenForUpdateButton);
    }

    public int getSimulationSpeed() {
        return simulationSpeed.getValue();
    }

    public int getRabbitsCount() {
        return rabbitsCount.getValue();
    }

    public int getWolvesCount() {
        return wolvesCount.getValue();
    }

}
