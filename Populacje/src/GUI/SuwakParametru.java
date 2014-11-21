package GUI;

import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class SuwakParametru extends JSlider {

    public SuwakParametru(String _title, int _max, int _current_value) {
        super(0, _max, _current_value);
        setBorder(new TitledBorder(_title));
        setMajorTickSpacing(_max / 5);
        setPaintLabels(true);
        setPaintTicks(true);
    }

}
