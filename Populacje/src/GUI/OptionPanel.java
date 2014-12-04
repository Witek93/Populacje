package GUI;

import GUI.options.ButtonsPanel;
import GUI.options.SlidersPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OptionPanel extends JPanel {

    SlidersPanel slidersPanel;
    ButtonsPanel buttonsPanel;

    public OptionPanel() {
        super(new BorderLayout());

        init();

        this.slidersPanel = new SlidersPanel();
        add(this.slidersPanel, BorderLayout.CENTER);

        this.buttonsPanel = new ButtonsPanel();
        add(this.buttonsPanel, BorderLayout.SOUTH);
    }

    private void init() {
        this.setMinimumSize(new Dimension(200, 0));
        this.setBorder(new TitledBorder("Opcje symulacji"));
        this.setBackground(Color.white);
    }

}
