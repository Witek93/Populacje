package growingpopulations.model;

import growingpopulations.model.map.WolvesRabbitsMap;

public class Model {

    volatile private int simulationInterval;
    volatile private int mapWidth, mapHeight;
    volatile private int rabbitsCount, wolvesCount;
    volatile private boolean started;
    private final SimulationOptions options;
    private final SimulationFactors factors;
    private WolvesRabbitsMap map;

    public Model() {
        this.rabbitsCount = 3;
        this.wolvesCount = 2;
        this.mapWidth = 5;
        this.mapHeight = 5;
        this.simulationInterval = 300;
        this.started = true;
        this.options = new SimulationOptions();
        this.factors = new SimulationFactors();
        initMap();
    }

    public final void initMap() {
        this.map = new WolvesRabbitsMap(mapWidth, mapHeight, wolvesCount, rabbitsCount);
    }

    // ----------------------- getters & setters -------------------------
    public int getSimulationInterval() {
        return simulationInterval;
    }

    public void setSimulationInterval(int simulationInterval) {
        this.simulationInterval = simulationInterval;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public int getRabbitsCount() {
        return rabbitsCount;
    }

    public void setRabbitsCount(int rabbitsCount) {
        this.rabbitsCount = rabbitsCount;
    }

    public int getWolvesCount() {
        return wolvesCount;
    }

    public void setWolvesCount(int wolvesCount) {
        this.wolvesCount = wolvesCount;
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

}
