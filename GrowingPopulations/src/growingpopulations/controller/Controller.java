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
    UpdateListener updateListener;
    ActionListener resetListener, startListener, pauseListener;

    public Controller(MainFrame view, Model model) {
        this.view = view;
        this.model = model;
        this.updateListener = new UpdateListener();
        this.resetListener = new ResetListener();
        this.startListener = new StartListener();
        this.pauseListener = new PauseListener();

        this.view.getParametersFrame().addUpdateButtonListener(updateListener);
        this.view.getParametersFrame().addResetButtonListener(resetListener);

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

    synchronized public void simulate() {
        if (this.model.getOptions().canRandomlyDie()) {
//            this.model.getMap().dieRabbits();
//            this.model.getMap().dieWolves();
        }

        if (this.model.getOptions().canStarve()) {
            //TODO wydzielic dla krolikow i wilkow
//            this.model.getMap().starve(this.model.getFactors().getStarvingRatio());
        }

        if (this.model.getOptions().canReproduce()) {
            //TODO wydzielic dla krolikow i wilkow
//            this.model.getMap().reproduce(this.model.getFactors().getReproducingRatio());
        }

        if (this.model.getOptions().canGrowGrass()) {
//            this.model.getMap().growGrass(this.model.getFactors().getGrassGrowingRatio());
        }

        this.model.getMap().simulate();

        drawMap();
    }

    private void drawMap() {
        synchronized (Controller.class) {
            List<Point> grass = this.model.getMap().getEmptyCoordinates();
            List<Point> wolves = this.model.getMap().getWolvesCoordinates();
            List<Point> rabbits = this.model.getMap().getRabbitsCoordinates();
            this.view.getMapPanel().drawAll(grass, wolves, rabbits);
        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (Controller.class) {
                updateParameters();
            }
        }

        private void updateParameters() {
            model.setSimulationInterval(view.getParametersFrame().getSimulationInterval());
            model.getFactors().setGrowGrassRatio(view.getParametersFrame().getGrowGrassRatio());

            //checkboxes: reproduce, starve, dieRandomly, growGrass
            model.getOptions().setCanReproduce(view.getParametersFrame().canReproduce());
            model.getOptions().setCanStarve(view.getParametersFrame().canStarve());
            model.getOptions().setRandomlyDie(view.getParametersFrame().canDie());
            model.getOptions().setCanGrowGrass(view.getParametersFrame().canGrowGrass());

            //wolf&rabbit: reproduce, dieRandomly, starve
            model.getFactors().setWolfReproducingRatio(view.getParametersFrame().getWolfReproduceRatio());
            model.getFactors().setWolfDieRatio(view.getParametersFrame().getWolfDieRatio());
            model.getFactors().setWolfStarveRatio(view.getParametersFrame().getWolfStarveRatio());
            model.getFactors().setRabbitReproducingRatio(view.getParametersFrame().getRabbitReproduceRatio());
            model.getFactors().setRabbitDieRatio(view.getParametersFrame().getRabbitDieRatio());
            model.getFactors().setRabbitStarveRatio(view.getParametersFrame().getRabbitStarveRatio());
        }

    }

    private class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (Controller.class) {
                resetParameters();
                view.getMapPanel().generateMapPanel(model.getMapWidth(), model.getMapHeight());
                drawMap();
                view.getSplitPane().getTopComponent().repaint();
            }
        }

        public void resetParameters() {
            model.setMapWidth(view.getParametersFrame().getMapWidth());
            model.setMapHeight(view.getParametersFrame().getMapHeight());
            model.setRabbitsCount(view.getParametersFrame().getRabbitsCount());
            model.setWolvesCount(view.getParametersFrame().getWolvesCount());
            updateListener.updateParameters();
            model.initMap();
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
