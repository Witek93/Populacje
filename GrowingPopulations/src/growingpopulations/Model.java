package growingpopulations;

public class Model {

    private int wolvesCount, rabbitsCount, simulationSpeed;

    public Model() {
        this.wolvesCount = 50;
        this.rabbitsCount = 50;
        this.simulationSpeed = 200;
    }

    public int getWolvesCount() {
        return wolvesCount;
    }

    public void setWolvesCount(int wolvesCount) {
        this.wolvesCount = wolvesCount;
    }

    public int getRabbitsCount() {
        return rabbitsCount;
    }

    public void setRabbitsCount(int rabbitsCount) {
        this.rabbitsCount = rabbitsCount;
    }

    public int getSimulationSpeed() {
        return simulationSpeed;
    }

    public void setSimulationSpeed(int simulationSpeed) {
        this.simulationSpeed = simulationSpeed;
    }
    

}
