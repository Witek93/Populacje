package growingpopulations;

import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

    private ParametersFrame parametersFrame;
    private MenuBar menuBar;
    private JPanel panel;
    private JTextArea rabbitsCountText, wolvesCountText, simulationSpeedText;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.parametersFrame = new ParametersFrame();
        this.initFrame();
        this.initMenuBar();
        initPanel();
        this.initTextAreas();
    }

    private void initPanel() {
        this.panel = new JPanel();
        this.add(panel);
    }

    private void initFrame() {
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initMenuBar() {
        menuBar = new MenuBar();
        menuBar.add(getParametersMenu());
        this.setMenuBar(menuBar);
    }

    private void initTextAreas() {
        this.rabbitsCountText = new JTextArea("Not parametrized yet");
        panel.add(rabbitsCountText);
        this.wolvesCountText = new JTextArea("Not parametrized yet");
        panel.add(wolvesCountText);
        this.simulationSpeedText = new JTextArea("Not parametrized yet");
        panel.add(simulationSpeedText);
    }

    private Menu getParametersMenu() {
        Menu menu = new Menu("Parametry");

        MenuItem open = new MenuItem("Otwórz");
        open.addActionListener((ActionEvent e) -> {
            parametersFrame.setVisible(true);
        });
        open.setShortcut(new MenuShortcut('O'));

        menu.add(open);
        return menu;
    }

    public void setSimulationSpeedText(String simulationText) {
        this.simulationSpeedText.setText(simulationText);
    }

    public void setRabbitsCountText(String rabbitsCountText) {
        this.rabbitsCountText.setText(rabbitsCountText);
    }

    public void setWolvesCountText(String wolvesCountText) {
        this.wolvesCountText.setText(wolvesCountText);
    }

    public ParametersFrame getParametersFrame() {
        return parametersFrame;
    }

    public int getSimulationSpeed() {
        return parametersFrame.getSimulationSpeed();
    }

    public int getRabbitsCount() {
        return parametersFrame.getRabbitsCount();
    }

    public int getWolvesCount() {
        return parametersFrame.getWolvesCount();
    }

}
