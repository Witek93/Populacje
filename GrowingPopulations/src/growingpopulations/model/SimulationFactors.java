package growingpopulations.model;

public class SimulationFactors {

    volatile private double wolfReproducingRatio, wolfStarveRatio, wolfDieRatio;
    volatile private double rabbitReproducingRatio, rabbitStarveRatio, rabbitDieRatio;
    volatile private double growGrassRatio;
    volatile private int simulationInterval;

    public SimulationFactors() {
        this.wolfReproducingRatio = 0.20;
        this.wolfStarveRatio = 0.05;
        this.wolfDieRatio = 0.1;

        this.rabbitReproducingRatio = 0.9;
        this.rabbitStarveRatio = 0.10;
        this.rabbitDieRatio = 0.05;

        this.growGrassRatio = 0.55;

        this.simulationInterval = 50;
    }

    public double getWolfReproducingRatio() {
        return wolfReproducingRatio;
    }

    public void setWolfReproducingRatio(double wolfReproducingRatio) {
        this.wolfReproducingRatio = wolfReproducingRatio;
    }

    public double getWolfStarveRatio() {
        return wolfStarveRatio;
    }

    public void setWolfStarveRatio(double wolfStarveRatio) {
        this.wolfStarveRatio = wolfStarveRatio;
    }

    public double getWolfDieRatio() {
        return wolfDieRatio;
    }

    public void setWolfDieRatio(double wolfDieRatio) {
        this.wolfDieRatio = wolfDieRatio;
    }

    public double getRabbitReproducingRatio() {
        return rabbitReproducingRatio;
    }

    public void setRabbitReproducingRatio(double rabbitReproducingRatio) {
        this.rabbitReproducingRatio = rabbitReproducingRatio;
    }

    public double getRabbitStarveRatio() {
        return rabbitStarveRatio;
    }

    public void setRabbitStarveRatio(double rabbitStarveRatio) {
        this.rabbitStarveRatio = rabbitStarveRatio;
    }

    public double getRabbitDieRatio() {
        return rabbitDieRatio;
    }

    public void setRabbitDieRatio(double rabbitDieRatio) {
        this.rabbitDieRatio = rabbitDieRatio;
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
