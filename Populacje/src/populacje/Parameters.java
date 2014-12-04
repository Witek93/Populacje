package populacje;

import simulations.RandomSimulation;

public class Parameters {

    private static volatile Parameters instance = null;

    private static int currentRabbitsCount;
    private static int rabbitsCount;
    private static int currentWolvesCount;
    private static int wolvesCount;
    private static int currentMapWidth;
    private static int mapWidth;
    private static int currentMapHeight;
    private static int mapHeight;
    private static boolean started, resetSimulation;
    private static Runnable algorithm;

    public static final int MAP_MAX_WIDTH = 50;
    public static final int MAP_MAX_HEIGHT = 50;

    private Parameters() {
    }

    private Parameters(int rabbitsCount, int wolvesCount, int mapWidth,
            int mapHeight, boolean isStarted, Runnable algorithm) {
        Parameters.currentRabbitsCount = rabbitsCount;
        Parameters.rabbitsCount = rabbitsCount;
        Parameters.currentWolvesCount = wolvesCount;
        Parameters.wolvesCount = wolvesCount;
        Parameters.currentMapWidth = mapWidth;
        Parameters.mapWidth = mapWidth;
        Parameters.currentMapHeight = mapHeight;
        Parameters.mapHeight = mapHeight;
        Parameters.started = isStarted;
        Parameters.algorithm = algorithm;
        Parameters.resetSimulation = true;
    }

    public static Parameters getInstance() {
        synchronized (Parameters.class) {
            if (instance == null) {
                instance = new Parameters(10, 2, 15, 25, false, new RandomSimulation());
            }
        }
        return instance;
    }

    public static void update() {
        currentMapHeight = mapHeight;
        currentMapWidth = mapWidth;
        currentRabbitsCount = rabbitsCount;
        currentWolvesCount = wolvesCount;
    }

    public int getMaxRabbitsCount() {
        return (int) (getMapWidth() * getMapHeight() * 0.5);
    }

    public int getMaxWolvesCount() {
        return (int) (getMapWidth() * getMapHeight() * 0.2);
    }

    final public void setRabbitsCount(int rabbitsCount) {
        Parameters.rabbitsCount = rabbitsCount;
    }

    public int getRabbitsCount() {
        return currentRabbitsCount;
    }

    final public void setWolvesCount(int wolvesCount) {
        Parameters.wolvesCount = wolvesCount;
    }

    public int getWolvesCount() {
        return currentWolvesCount;
    }

    final public void setMapWidth(int mapWidth) {
        Parameters.mapWidth = mapWidth;
    }

    public int getMapWidth() {
        return currentMapWidth;
    }

    final public void setMapHeight(int mapHeight) {
        Parameters.mapHeight = mapHeight;
    }

    public int getMapHeight() {
        return currentMapHeight;
    }

    final public void setStarted(boolean isStarted) {
        Parameters.started = isStarted;
    }

    public boolean isStarted() {
        return started;
    }

    public static Runnable getAlgorithm() {
        return algorithm;
    }

    public static void setAlgorithm(Runnable algorithm) {
        Parameters.algorithm = algorithm;
    }

    public boolean wasResetPressed() {
        return resetSimulation;
    }

    public void setReset(boolean value) {
        Parameters.resetSimulation = value;
    }

}
