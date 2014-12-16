package growingpopulations.model;

import growingpopulations.model.map.WolvesRabbitsMap;

public class Model {

    volatile private Parameters parameters;
//    volatile private int simulationInterval;
    volatile private boolean started;
    private final SimulationOptions options;
    private final SimulationFactors factors;
    private WolvesRabbitsMap map;

    public Model() {
        this.parameters = new Parameters(30, 40, 300, 20);
        this.started = true;
        this.options = new SimulationOptions();
        this.factors = new SimulationFactors();
        this.map = new WolvesRabbitsMap(
                parameters.mapWidth, parameters.mapHeight,
                parameters.wolvesCount, parameters.rabbitsCount);
    }

    public final void resetMap() {
        this.map = new WolvesRabbitsMap(
                parameters.mapWidth, parameters.mapHeight,
                parameters.wolvesCount, parameters.rabbitsCount);
    }

    public int calculateMaxRabbitsCount() {
        return (int) (getMapHeight() * getMapWidth() * 0.5);
    }

    public int calculateMaxWolvesCount() {
        return (int) (getMapHeight() * getMapWidth() * 0.2);
    }

    // ----------------------- getters & setters -------------------------
    public int getSimulationInterval() {
        return getFactors().getSimulationInterval();
    }

    public void setSimulationInterval(int simulationInterval) {
        this.getFactors().setSimulationInterval(simulationInterval);
    }

    public int getMapWidth() {
        return parameters.mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.parameters.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return parameters.mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.parameters.mapHeight = mapHeight;
    }

    public int getRabbitsCount() {
        return parameters.rabbitsCount;
    }

    public void setRabbitsCount(int rabbitsCount) {
        this.parameters.rabbitsCount = rabbitsCount;
    }

    public int getWolvesCount() {
        return parameters.wolvesCount;
    }

    public void setWolvesCount(int wolvesCount) {
        this.parameters.wolvesCount = wolvesCount;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public SimulationOptions getOptions() {
        return options;
    }

    public SimulationFactors getFactors() {
        return factors;
    }

    public WolvesRabbitsMap getMap() {
        return map;
    }

    private class Parameters {

        volatile private int mapWidth, mapHeight;
        volatile private int rabbitsCount, wolvesCount;

        public Parameters(int mapWidth, int mapHeight, int rabbitsCount, int wolvesCount) {
            this.mapWidth = mapWidth;
            this.mapHeight = mapHeight;
            this.rabbitsCount = rabbitsCount;
            this.wolvesCount = wolvesCount;
        }

    }

}
