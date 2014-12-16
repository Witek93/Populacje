package growingpopulations.controller;

import growingpopulations.GrowingPopulations;
import growingpopulations.model.*;
import growingpopulations.model.map.WolvesRabbitsMap;
import growingpopulations.view.MainFrame;
import growingpopulations.view.ParametersFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Runnable {

    MainFrame view;
    Model model;
    ActionListener startListener, pauseListener;

    public Controller(MainFrame view, Model model) {
        this.view = view;
        this.model = model;
        this.startListener = new StartListener();
        this.pauseListener = new PauseListener();
        
        this.view.getMapPanel().reinitialize(
                getParameters().getMapWidth(),
                getParameters().getMapHeight());

        ActionListener updateListener = (ActionEvent e) -> {
            synchronized (Controller.class) {
                updateModelParameters();
            }
        };

        ActionListener resetListener = (ActionEvent e) -> {
            synchronized (Controller.class) {
                resetParameters();
            }
        };

        if (getParameters().isStarted()) {
            this.view.addStartPauseButtonListener(startListener);
            this.view.getStartPauseButton().setText("Pause");
        } else {
            this.view.addStartPauseButtonListener(pauseListener);
            this.view.getStartPauseButton().setText("Start");
        }

        initParametersOnView();

        getParametersFrame().addUpdateButtonListener(updateListener);
        getParametersFrame().addResetButtonListener(resetListener);
    }

    private void initParametersOnView() {
        Options options = this.model.getOptions();
        getParametersFrame().initResetSliders(
                getParameters().getRabbitsCount(),
                getParameters().getWolvesCount(),
                getParameters().getMapWidth(),
                getParameters().getMapHeight());
        getParametersFrame().initUpdateSliders(
                this.model.getFactors().getSimulationInterval(),
                (int) (this.model.getFactors().getGrowGrassRatio() * 100));
        getParametersFrame().initRabbitRatios(
                (int) (getRabbitRatios().getReproduce() * 100),
                (int) (getRabbitRatios().getStarve() * 100));
        getParametersFrame().initWolfRatios(
                (int) (getWolfRatios().getReproduce() * 100),
                (int) (getWolfRatios().getStarve() * 100));
        getParametersFrame().initCheckboxes(options.canReproduce(),
                options.canStarve(), options.canGrowGrass());
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (getParameters().isStarted()) {
                    this.simulate();
                    this.updatePlot();
                    Thread.sleep(this.model.getFactors().getSimulationInterval());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(GrowingPopulations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    synchronized public void simulate() {
        Factors factors = this.model.getFactors();
        Options options = this.model.getOptions();

        if (options.canStarve()) {
            getModelMap().increaseRabbitsStarvation(getRabbitRatios().getStarve());
            getModelMap().increaseWolvesStarvation(getWolfRatios().getStarve());
        }

        if (options.canReproduce()) {
            getModelMap().reproduceRabbits(
                    getRabbitRatios().getReproduce(),
                    this.model.calculateMaxRabbitsCount());
            getModelMap().reproduceWolves(
                    getWolfRatios().getReproduce(),
                    this.model.calculateMaxWolvesCount());
        }

        if (options.canGrowGrass()) {
            getModelMap().growGrass(factors.getGrowGrassRatio());
        }

        getModelMap().moveWolves();
        getModelMap().moveRabbits();
        getModelMap().agingProcess();
        getModelMap().updateDeaths();

        this.drawMap();
    }

    private void drawMap() {
        synchronized (Controller.class) {
            this.view.getMapPanel().drawAll(
                    getModelMap().getNoAnimalsCoordinates(),
                    getModelMap().getWolvesCoordinatesCopy(),
                    getModelMap().getRabbitsCoordinatesCopy());
        }
    }

    public void updatePlot() {
        view.getPlot().addAnimalsCount(getModelMap().getRabbitsCount(), getModelMap().getWolvesCount());
    }

    private void resetParameters() {
        getParameters().setMapWidth(getParametersFrame().getMapWidth());
        getParameters().setMapHeight(getParametersFrame().getMapHeight());
        getParameters().setRabbitsCount(getParametersFrame().getRabbitsCount());
        getParameters().setWolvesCount(getParametersFrame().getWolvesCount());
        updateModelParameters();
        model.reinitializeMap();
        view.getPlot().reinitialize();
        view.getMapPanel().reinitialize(getParameters().getMapWidth(), getParameters().getMapHeight());
        drawMap();
        view.repaint();
    }

    private void updateModelParameters() {
        model.getOptions().setCanReproduce(getParametersFrame().canReproduce());
        model.getOptions().setCanStarve(getParametersFrame().canStarve());
        model.getOptions().setCanGrowGrass(getParametersFrame().canGrowGrass());

        model.getFactors().setSimulationInterval(getParametersFrame().getSimulationInterval());
        model.getFactors().setGrowGrassRatio(getParametersFrame().getGrowGrassRatio());

        getWolfRatios().setReproduce(getParametersFrame().getWolfReproduceRatio());
        getWolfRatios().setStarve(getParametersFrame().getWolfStarveRatio());

        getRabbitRatios().setReproduce(getParametersFrame().getRabbitReproduceRatio());
        getRabbitRatios().setStarve(getParametersFrame().getRabbitStarveRatio());
    }

    private class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Start");
            getParameters().setStarted(false);
            view.addStartPauseButtonListener(pauseListener);
        }
    }

    private class PauseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getStartPauseButton().setText("Pauza");
            getParameters().setStarted(true);
            view.addStartPauseButtonListener(startListener);
        }
    }

    // ----------------------- getters & setters -----------------------
    private WolvesRabbitsMap getModelMap() {
        return this.model.getMap();
    }

    private Parameters getParameters() {
        return this.model.getParameters();
    }

    private ParametersFrame getParametersFrame() {
        return this.view.getParametersFrame();
    }

    private Ratios getWolfRatios() {
        return this.model.getFactors().getWolfRatios();
    }

    private Ratios getRabbitRatios() {
        return this.model.getFactors().getRabbitRatios();
    }

}
