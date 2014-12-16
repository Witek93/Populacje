package growingpopulations.model;

public class Factors {

    volatile private Ratios wolfRatios, rabbitRatios;
    volatile private double growGrassRatio;
    volatile private int simulationInterval;

    public Factors() {
        // reproduce, starve
        this.wolfRatios = new Ratios(0.7, 0.07);
        this.rabbitRatios = new Ratios(0.45, 0.1);
        this.growGrassRatio = 0.55;
        this.simulationInterval = 50;
    }

    public Ratios getRabbitRatios() {
        return rabbitRatios;
    }

    public Ratios getWolfRatios() {
        return wolfRatios;
    }

    public double getGrowGrassRatio() {
        return growGrassRatio;
    }

    public void setGrowGrassRatio(double growGrassRatio) {
        this.growGrassRatio = growGrassRatio;
    }

    public int getSimulationInterval() {
        return simulationInterval;
    }

    public void setSimulationInterval(int simulationInterval) {
        this.simulationInterval = simulationInterval;
    }
}
