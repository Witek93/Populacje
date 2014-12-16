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

        MenuItem open = new MenuItem("Parametry");
        open.addActionListener((ActionEvent e) -> {
            parametersFrame.setVisible(true);
        });
        open.setShortcut(new MenuShortcut('O'));

        this.parametersMenu.add(open);
        this.add(parametersMenu);
    }

    public ParametersFrame getParametersFrame() {
        return parametersFrame;
    }

}
