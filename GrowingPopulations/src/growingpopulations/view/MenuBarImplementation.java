package growingpopulations.view;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;

public class MenuBarImplementation extends MenuBar {

    private final Menu parametersMenu;
    private final ParametersFrame parametersFrame;

    public MenuBarImplementation() {
        super();
        this.parametersFrame = new ParametersFrame();
        this.parametersMenu = new Menu("Symulacja");

        initSimulationOptions();

        this.add(parametersMenu);
    }

    public void initSliderValues(int simulationInterval, int rabbitsCount,
            int wolvesCount, int mapWidth, int mapHeight) {
        getParametersFrame().initSliderValues(simulationInterval, rabbitsCount, wolvesCount, mapWidth, mapHeight);
    }

    public final void initSimulationOptions() {
        MenuItem open = new MenuItem("Parametry");
        open.addActionListener((ActionEvent e) -> {
            parametersFrame.setVisible(true);
        });
        open.setShortcut(new MenuShortcut('O'));

        parametersMenu.add(open);
    }

    public ParametersFrame getParametersFrame() {
        return parametersFrame;
    }

}
