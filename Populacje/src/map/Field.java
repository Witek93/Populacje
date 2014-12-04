package map;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public abstract class Field extends JPanel {

    public Field() {
        super();
        this.setBorder(new LineBorder(Color.white, 1));
    }
    
    
    
}
