package growingpopulations.controller;

import growingpopulations.view.MainFrame;
import growingpopulations.model.Model;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {

    MainFrame view;
    Model model;
    ActionListener updateListener, startListener, pauseListener;

    public Controller(MainFrame view, Model model) {
        this.view = view;
        this.model = model;
        this.updateListener = new UpdateListener();
        this.startListener = new StartListener();
        this.pauseListener = new PauseListener();

        this.view.getParametersFrame().addUpdateButtonListener(updateListener);
        this.view.getMenu().addGenerateMenuItemListener(updateListener);

        if (this.model.isStarted()) {
            this.view.addStartPauseButtonListener(startListener);
            this.view.getStartPauseButton().setText("Pause");
        } else {
            this.view.addStartPauseButtonListener(pauseListener);
            this.view.getStartPauseButton().setText("Start");
        }

        this.view.getMenu().initSliderValues(this.model.getSimulationInterval(),
                this.model.getRabbitsCount(), this.model.getWolvesCount(),
                this.model.getMapWidth(), this.model.getMapHeight());
    }

    public void simulate() {
//        if (this.model.getOptions().canDie) {
//            this.model.getMap().dieRabbits();
//            this.model.getMap().dieWolves();
//        }
//
//        if (this.model.getOptions().canStarve) {
//            //TODO wydzielic dla krolikow i wilkow
//            this.model.getMap().starve(this.model.getFactors().getStarvingRatio());
//        }
//
//        if (this.model.getOptions().canReproduce()) {
//            //TODO wydzielic dla krolikow i wilkow
//            this.model.getMap().reproduce(this.model.getFactors().getReproducingRatio());
//        }
//
//        if (this.model.getOptions().canGrowGrass()) {
//            this.model.getMap().growGrass(this.model.getFactors().getGrassGrowingRatio());
//        }

        this.model.getMap().simulate();

        drawMap();
    }

    private void drawMap() {
        List<Point> grass = this.model.getMap().getEmptyCoordinates();
        List<Point> wolves = this.model.getMap().getWolvesCoordinates();
        List<Point> rabbits = this.model.getMap().getRabbitsCoordinates();
        this.view.getMapPanel().drawAll(grass, wolves, rabbits);
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateParameters();
            updateSimulationOptions();
            model.initMap();
            view.getMapPanel().generateMapPanel(model.getMapWidth(), model.getMapHeight());
            drawMap();
            view.getSplitPane().getTopComponent().repaint();
        }

        private void updateParameters() {
            model.setSimulationInterval(view.getSimulationInterval());
            model.setMapWidth(view.getMapWidth());
            model.setMapHeight(view.getMapHeight());
            model.setRabbitsCount(view.getRabbitsCount());
            model.setWolvesCount(view.getWolvesCount());
        }

        private void updateSimulationOptions() {
            model.getOptions().setCanReproduce(view.getMenu().getReproducing());
            model.getOptions().setCanDie(view.getMenu().getDying());
            model.getOptions().setCanStarve(view.getMenu().getStarving());
        }

    }

    private class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Start");
            model.setStarted(false);
            view.addStartPauseButtonListener(pauseListener);
        }

    }

    private class PauseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Pauza");
            model.setStarted(true);
            view.addStartPauseButtonListener(startListener);
        }

    }

}
