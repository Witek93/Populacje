package growingpopulations.model;

public class Parameters {

    volatile private int mapWidth, mapHeight;
    volatile private int rabbitsCount, wolvesCount;
    volatile private boolean started;

    public Parameters(int mapWidth, int mapHeight,
            int rabbitsCount, int wolvesCount, boolean started) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.rabbitsCount = rabbitsCount;
        this.wolvesCount = wolvesCount;
        this.started = started;
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

}
