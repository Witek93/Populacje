package GUI;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import mapa.Pole;

public class PoleMapy extends JPanel {

    Pole _pole;

    public PoleMapy(Pole _pole) {
        super();
        this._pole = _pole;
        this.setBorder(new LineBorder(Color.white, 1));
    }

}
