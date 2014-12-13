package growingpopulations.model;

public class SimulationFactors {

    private double reproducingRatio, grassGrowingRatio, starvingRatio;

    public SimulationFactors() {
        this.reproducingRatio = 0.1;
        this.grassGrowingRatio = 0.1;
        this.starvingRatio = 0.1;
    }

    public double getReproducingRatio() {
        return reproducingRatio;
    }

    public void setReproducingRatio(double reproducingRatio) {
        this.reproducingRatio = reproducingRatio;
    }

    public double getGrassGrowingRatio() {
        return grassGrowingRatio;
    }

    public void setGrassGrowingRatio(double grassGrowingRatio) {
        this.grassGrowingRatio = grassGrowingRatio;
    }

    public double getStarvingRatio() {
        return starvingRatio;
    }

    public void setStarvingRatio(double starvingRatio) {
        this.starvingRatio = starvingRatio;
    }

}
