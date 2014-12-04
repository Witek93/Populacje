package GUI.options;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import populacje.Parameters;

public class SlidersPanel extends JPanel {

    JSlider rabbitsCountSlider;
    JSlider wolvesCountSlider;
    JSlider mapWidthSlider;
    JSlider mapHeightSlider;

    public SlidersPanel() {
        super(new GridLayout(0, 1, 5, 5));

        rabbitsCountSlider = createRabbitsCountSlider();
        this.add(rabbitsCountSlider);

        wolvesCountSlider = createWolvesCountSlider();
        this.add(wolvesCountSlider);

        mapWidthSlider = createMapWidthSlider();
        this.add(mapWidthSlider);

        mapHeightSlider = createMapHeightSlider();
        this.add(mapHeightSlider);
    }

    private JSlider createRabbitsCountSlider() {
        JSlider slider = new SuwakParametru("Ilość królików",
                Parameters.getMaxRabbitsCount(),
                Parameters.getRabbitsCount());
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Parameters.setRabbitsCount(slider.getValue());
            }
        });
        return slider;
    }

    private JSlider createWolvesCountSlider() {
        JSlider slider = new SuwakParametru("Ilość wilków",
                Parameters.getMaxWolvesCount(),
                Parameters.getWolvesCount());
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Parameters.setWolvesCount(slider.getValue());
            }
        });
        return slider;
    }

    private JSlider createMapWidthSlider() {
        JSlider slider = new SuwakParametru("Wysokość mapy",
                Parameters.MAP_MAX_WIDTH,
                Parameters.getMapWidth());
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Parameters.setMapWidth(slider.getValue());
                update(rabbitsCountSlider, Parameters.getMaxRabbitsCount());
                update(wolvesCountSlider, Parameters.getMaxWolvesCount());
            }
        });
        return slider;
    }

    private JSlider createMapHeightSlider() {
        JSlider slider = new SuwakParametru("Szerokość mapy",
                Parameters.MAP_MAX_HEIGHT,
                Parameters.getMapHeight());
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Parameters.setMapHeight(slider.getValue());
                update(rabbitsCountSlider, Parameters.getMaxRabbitsCount());
                update(wolvesCountSlider, Parameters.getMaxWolvesCount());
            }
        });
        return slider;
    }

    private void update(JSlider slider, int max) {
        if (slider.getValue() > max) {
            slider.setValue(max);
        }
        slider.setMaximum(max);
        slider.createStandardLabels((max / 5 > 10) ? max / 5 : 10);
        slider.setMajorTickSpacing(max / 5);
    }

    public class SuwakParametru extends JSlider {

        public SuwakParametru(String title, int max, int current_value) {
            super(0, max, current_value);
            setBorder(new TitledBorder(title));
            setMajorTickSpacing(max / 5);
            setPaintLabels(true);
            setPaintTicks(true);
        }

    }

}
