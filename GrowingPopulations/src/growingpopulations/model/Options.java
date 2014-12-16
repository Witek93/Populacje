package growingpopulations.model;

public class Options {

    private volatile boolean reproduce, randomlyDie, starve, growGrass;

    public Options() {
        this.reproduce = true;
        this.randomlyDie = true;
        this.starve = true;
        this.growGrass = true;
    }

    public boolean canReproduce() {
        return reproduce;
    }

    public void setCanReproduce(boolean canReproduce) {
        this.reproduce = canReproduce;
    }

    public boolean canRandomlyDie() {
        return randomlyDie;
    }

    public void setRandomlyDie(boolean randomlyDie) {
        this.randomlyDie = randomlyDie;
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
