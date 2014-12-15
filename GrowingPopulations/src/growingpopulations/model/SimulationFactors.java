package growingpopulations.model;

public class SimulationFactors {

    private double wolfReproducingRatio, wolfStarveRatio, wolfDieRatio;
    private double rabbitReproducingRatio, rabbitStarveRatio, rabbitDieRatio;
    private double growGrassRatio;

    public SimulationFactors() {
        this.wolfReproducingRatio = 0.1;
        this.wolfStarveRatio = 0.1;
        this.wolfDieRatio = 0.1;

        this.rabbitReproducingRatio = 0.1;
        this.rabbitStarveRatio = 0.1;
        this.rabbitDieRatio = 0.1;

        this.growGrassRatio = 0.1;
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

}
