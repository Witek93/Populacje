package growingpopulations.model;

public class Options {

    private volatile boolean reproduce, starve, growGrass;

    public Options() {
        this.reproduce = true;
        this.starve = true;
        this.growGrass = true;
    }

    public boolean canReproduce() {
        return reproduce;
    }

    public void setCanReproduce(boolean canReproduce) {
        this.reproduce = canReproduce;
    }

    public boolean canStarve() {
        return starve;
    }

    public void setCanStarve(boolean canStarve) {
        this.starve = canStarve;
    }

    public boolean canGrowGrass() {
        return growGrass;
    }

    public void setCanGrowGrass(boolean canGrowGrass) {
        this.growGrass = canGrowGrass;
    }

}
