package growingpopulations.controller;

import growingpopulations.view.MainFrame;
import growingpopulations.model.Model;
import growingpopulations.model.Factors;
import growingpopulations.model.Options;
import growingpopulations.model.map.WolvesRabbitsMap;
import growingpopulations.view.ParametersFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        if (this.model.getParameters().isStarted()) {
            this.view.addStartPauseButtonListener(startListener);
            this.view.getStartPauseButton().setText("Pause");
        } else {
            this.view.addStartPauseButtonListener(pauseListener);
            this.view.getStartPauseButton().setText("Start");
        }

        this.view.getParametersFrame().initResetSliders(
                this.model.getParameters().getRabbitsCount(),
                this.model.getParameters().getWolvesCount(),
                this.model.getParameters().getMapWidth(),
                this.model.getParameters().getMapHeight());

        this.view.getParametersFrame().initUpdateSliders(
                this.model.getFactors().getSimulationInterval(),
                (int) (this.model.getFactors().getGrowGrassRatio() * 100)
        );

        this.view.getParametersFrame().initRabbitRatios(
                (int) (this.model.getFactors().getRabbitReproducingRatio() * 100),
                (int) (this.model.getFactors().getRabbitStarveRatio() * 100),
                (int) (this.model.getFactors().getRabbitDieRatio() * 100));

        this.view.getParametersFrame().initWolfRatios(
                (int) (this.model.getFactors().getWolfReproducingRatio() * 100),
                (int) (this.model.getFactors().getWolfStarveRatio() * 100),
                (int) (this.model.getFactors().getWolfDieRatio() * 100));

        this.view.getParametersFrame().initCheckboxes(
                this.model.getOptions().canReproduce(),
                this.model.getOptions().canRandomlyDie(),
                this.model.getOptions().canStarve(),
                this.model.getOptions().canGrowGrass());

        this.view.getParametersFrame().addUpdateButtonListener(updateListener);
        this.view.getParametersFrame().addResetButtonListener(resetListener);
    }

    synchronized public void simulate() {
        WolvesRabbitsMap map = this.model.getMap();
        Factors factors = this.model.getFactors();
        Options options = this.model.getOptions();

        if (options.canRandomlyDie()) {
//            this.model.getMap().dieRabbits();
//            this.model.getMap().dieWolves();
        }

        if (options.canStarve()) {
            map.increaseRabbitsStarvation(factors.getRabbitStarveRatio());
            map.increaseWolvesStarvation(factors.getWolfStarveRatio());
        }

        if (options.canReproduce()) {
            map.reproduceRabbits(factors.getRabbitReproducingRatio(),
                    this.model.calculateMaxRabbitsCount());
            map.reproduceWolves(factors.getWolfReproducingRatio(),
                    this.model.calculateMaxWolvesCount());
        }

        if (options.canGrowGrass()) {
            map.growGrass(factors.getGrowGrassRatio());
        }

        map.moveWolves();
        map.moveRabbits();
        map.agingProcess();
        map.updateDeaths();

        this.drawMap();
    }

    private void drawMap() {
        synchronized (Controller.class) {
            this.view.getMapPanel().drawAll(
                    this.model.getMap().getNoAnimalsCoordinates(),
                    this.model.getMap().getWolvesCoordinates(),
                    this.model.getMap().getRabbitsCoordinates());
        }
    }

    public void updatePlot() {
        this.view.getPlot().addAnimalsAmount(this.model.getMap().getRabbitsCount(),
                this.model.getMap().getWolvesCount());
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (Controller.class) {
                updateParameters();
            }
        }

        private void updateParameters() {
            ParametersFrame parameters = view.getParametersFrame();
            Factors factors = model.getFactors();
            Options options = model.getOptions();

            factors.setSimulationInterval(parameters.getSimulationInterval());
            factors.setGrowGrassRatio(parameters.getGrowGrassRatio());

            //checkboxes: reproduce, starve, dieRandomly, growGrass
            options.setCanReproduce(parameters.canReproduce());
            options.setCanStarve(parameters.canStarve());
            options.setRandomlyDie(parameters.canDie());
            options.setCanGrowGrass(parameters.canGrowGrass());

            //wolf&rabbit: reproduce, dieRandomly, starve
            factors.setWolfReproducingRatio(parameters.getWolfReproduceRatio());
            factors.setWolfDieRatio(parameters.getWolfDieRatio());
            factors.setWolfStarveRatio(parameters.getWolfStarveRatio());
            factors.setRabbitReproducingRatio(parameters.getRabbitReproduceRatio());
            factors.setRabbitDieRatio(parameters.getRabbitDieRatio());
            factors.setRabbitStarveRatio(parameters.getRabbitStarveRatio());
        }

    }

    private class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (Controller.class) {
                resetParameters();
                view.getPlot().reset();
                view.getMapPanel().generateMapPanel(
                        model.getParameters().getMapWidth(),
                        model.getParameters().getMapHeight());
                drawMap();
                view.getSplitPane().getTopComponent().repaint();
            }
        }

        public void resetParameters() {
            model.getParameters().setMapWidth(view.getParametersFrame().getMapWidth());
            model.getParameters().setMapHeight(view.getParametersFrame().getMapHeight());
            model.getParameters().setRabbitsCount(view.getParametersFrame().getRabbitsCount());
            model.getParameters().setWolvesCount(view.getParametersFrame().getWolvesCount());
            updateListener.updateParameters();
            model.resetMap();
        }

    }

    private class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Start");
            model.getParameters().setStarted(false);
            view.addStartPauseButtonListener(pauseListener);
        }

    }

    private class PauseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Pauza");
            model.getParameters().setStarted(true);
            view.addStartPauseButtonListener(startListener);
        }

    }

}
