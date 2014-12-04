package GUI.options;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import populacje.Parameters;

public class ButtonsPanel extends JPanel {

    JButton startPauseButton;
    JButton resetButton;

    public ButtonsPanel() {
        super(new GridLayout(0, 1, 5, 5));

        startPauseButton = createStartPauseButton();
        this.add(startPauseButton);

        resetButton = createResetButton(startPauseButton);
        this.add(resetButton);

    }

    private JButton createStartPauseButton() {
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parameters.isStarted()) {
                    button.setText("Start");
                    Parameters.setStarted(false);
                } else {
                    button.setText("Pauza");
                    Parameters.setStarted(true);
                }
            }
        });
        return button;
    }

    private JButton createResetButton(JButton startPauseButton) {
        JButton button = new JButton("Resetuj");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parameters.setReset(true);
                startPauseButton.setText("Start");
                Parameters.setStarted(false);
            }
        });

        return button;

    }

}
