package growingpopulations.model;

public class Ratios {

    volatile private double reproduce, starve;

    public double getReproduce() {
        return reproduce;
    }

    public void setReproduce(double reproduce) {
        this.reproduce = reproduce;
    }

    public double getStarve() {
        return starve;
    }

    public void setStarve(double starve) {
        this.starve = starve;
    }

    public Ratios(double reproducingRatio, double starveRatio) {
        this.reproduce = reproducingRatio;
        this.starve = starveRatio;
    }

}
