package populacje;

import simulations.RandomSimulation;

public class Parameters {

    private static int currentRabbitsCount = 10, rabbitsCount = 10;
    private static int currentWolvesCount = 2, wolvesCount = 2;
    private static int currentMapWidth = 15, mapWidth = 15;
    private static int currentMapHeight = 25, mapHeight = 25;
    private static boolean started = false, resetSimulation = true;
    private static Runnable algorithm = new RandomSimulation();

    public static final int MAP_MAX_WIDTH = 50;
    public static final int MAP_MAX_HEIGHT = 50;

    private Parameters() {
        //to avoid making any instances of class Parameters
    }

    public static void update() {
        Parameters.currentMapHeight = mapHeight;
        Parameters.currentMapWidth = mapWidth;
        Parameters.currentRabbitsCount = rabbitsCount;
        Parameters.currentWolvesCount = wolvesCount;
    }

    public static int getMaxRabbitsCount() {
        return (int) (getMapWidth() * getMapHeight() * 0.5);
    }

    public static int getMaxWolvesCount() {
        return (int) (getMapWidth() * getMapHeight() * 0.5);
    }

    public static void setRabbitsCount(int rabbitsCount) {
        Parameters.rabbitsCount = rabbitsCount;
    }

    public static int getRabbitsCount() {
        return Parameters.currentRabbitsCount;
    }

    public static void setWolvesCount(int wolvesCount) {
        Parameters.wolvesCount = wolvesCount;
    }

    public static int getWolvesCount() {
        return Parameters.currentWolvesCount;
    }

    public static int getCurrentRabbitsCount() {
        return currentRabbitsCount;
    }

    public static void decCurrentRabbitsCount() {
        Parameters.currentRabbitsCount--;
    }

    public static void decCurrentWolvesCount() {
        Parameters.currentWolvesCount--;
    }

    public static void incCurrentRabbitsCount() {
        Parameters.currentRabbitsCount++;
    }

    public static void incCurrentWolvesCount() {
        Parameters.currentWolvesCount++;
    }

    public static int getCurrentWolvesCount() {
        return currentWolvesCount;
    }

    public static void setMapWidth(int mapWidth) {
        Parameters.mapWidth = mapWidth;
    }

    public static int getMapWidth() {
        return Parameters.currentMapWidth;
    }

    public static void setMapHeight(int mapHeight) {
        Parameters.mapHeight = mapHeight;
    }

    public static int getMapHeight() {
        return Parameters.currentMapHeight;
    }

    public static void setStarted(boolean isStarted) {
        Parameters.started = isStarted;
    }

    public static boolean isStarted() {
        return Parameters.started;
    }

    public static Runnable getAlgorithm() {
        return Parameters.algorithm;
    }

    public static void setAlgorithm(Runnable algorithm) {
        Parameters.algorithm = algorithm;
    }

    public static boolean wasResetPressed() {
        return Parameters.resetSimulation;
    }

    public static void setReset(boolean value) {
        Parameters.resetSimulation = value;
    }

}
