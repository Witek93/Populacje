package growingpopulations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    MainFrame view;
    Model model;

    public Controller(MainFrame view, Model model) {
        this.view = view;
        this.model = model;

        this.view.getParametersFrame().addUpdateListener(new UpdateListener());
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateParameters();
            updateTextAreas();
        }

        private void updateParameters() {
            int simulationSpeed = view.getSimulationSpeed();
            model.setSimulationSpeed(simulationSpeed);

            int rabbitsCount = view.getRabbitsCount();
            model.setRabbitsCount(rabbitsCount);

            int wolvesCount = view.getWolvesCount();
            model.setWolvesCount(wolvesCount);
        }

        private void updateTextAreas() {
            int simulationSpeed = view.getSimulationSpeed();
            view.setSimulationSpeedText("Simulation speed: " + simulationSpeed + "[ms]");
            int rabbitsCount = view.getRabbitsCount();
            view.setRabbitsCountText("Rabbits count: " + rabbitsCount);
            int wolvesCount = view.getWolvesCount();
            view.setWolvesCountText("Wolves count: " + wolvesCount);
        }

    }

}
