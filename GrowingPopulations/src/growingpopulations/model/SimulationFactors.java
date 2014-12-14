package growingpopulations.model;

public class SimulationFactors {

    private double wolfReproducingRatio, wolfStarvingRatio, wolfEatingRatio;
    private double rabbitReproducingRatio, rabbitStarvingRatio, rabbitEatingRatio;
    private double grassGrowingRatio;

    public SimulationFactors() {
        this.wolfReproducingRatio = 0.1;
        this.wolfStarvingRatio = 0.1;
        this.wolfEatingRatio = 0.1;

        this.rabbitReproducingRatio = 0.1;
        this.rabbitStarvingRatio = 0.1;
        this.rabbitEatingRatio = 0.1;

        this.grassGrowingRatio = 0.1;
    }

    public double getWolfReproducingRatio() {
        return wolfReproducingRatio;
    }

    public void setWolfReproducingRatio(double wolfReproducingRatio) {
        this.wolfReproducingRatio = wolfReproducingRatio;
    }

    public double getWolfStarvingRatio() {
        return wolfStarvingRatio;
    }

    public void setWolfStarvingRatio(double wolfStarvingRatio) {
        this.wolfStarvingRatio = wolfStarvingRatio;
    }

    public double getWolfEatingRatio() {
        return wolfEatingRatio;
    }

    public void setWolfEatingRatio(double wolfEatingRatio) {
        this.wolfEatingRatio = wolfEatingRatio;
    }

    public double getRabbitReproducingRatio() {
        return rabbitReproducingRatio;
    }

    public void setRabbitReproducingRatio(double rabbitReproducingRatio) {
        this.rabbitReproducingRatio = rabbitReproducingRatio;
    }

    public double getRabbitStarvingRatio() {
        return rabbitStarvingRatio;
    }

    public void setRabbitStarvingRatio(double rabbitStarvingRatio) {
        this.rabbitStarvingRatio = rabbitStarvingRatio;
    }

    public double getRabbitEatingRatio() {
        return rabbitEatingRatio;
    }

    public void setRabbitEatingRatio(double rabbitEatingRatio) {
        this.rabbitEatingRatio = rabbitEatingRatio;
    }

    public double getGrassGrowingRatio() {
        return grassGrowingRatio;
    }

    public void setGrassGrowingRatio(double grassGrowingRatio) {
        this.grassGrowingRatio = grassGrowingRatio;
    }

}
