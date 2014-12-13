package growingpopulations.view;

import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarImplementation extends MenuBar {

    private final Menu parametersMenu;
    private final ParametersFrame parametersFrame;
    private MenuItem generate, reproducingCheckbox, dyingCheckbox, starvingCheckbox;

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
        generate = new MenuItem("Generuj");
        generate.setShortcut(new MenuShortcut('G'));

        MenuItem open = new MenuItem("Parametry");
        open.addActionListener((ActionEvent e) -> {
            parametersFrame.setVisible(true);
        });
        open.setShortcut(new MenuShortcut('O'));

        reproducingCheckbox = new CheckboxMenuItem("rozmnażanie", true);
        dyingCheckbox = new CheckboxMenuItem("śmiertelność", true);
        starvingCheckbox = new CheckboxMenuItem("głód", true);

        parametersMenu.add(generate);
        parametersMenu.add(open);
        parametersMenu.add(reproducingCheckbox);
        parametersMenu.add(dyingCheckbox);
        parametersMenu.add(starvingCheckbox);
    }

    public void addGenerateMenuItemListener(ActionListener listenForUpdate) {
        generate.addActionListener(listenForUpdate);
    }

    public ParametersFrame getParametersFrame() {
        return parametersFrame;
    }

    public boolean getReproducing() {
        return reproducingCheckbox.isEnabled();
    }

    public boolean getDying() {
        return dyingCheckbox.isEnabled();
    }

    public boolean getStarving() {
        return starvingCheckbox.isEnabled();
    }

}
