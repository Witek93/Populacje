package growingpopulations.model;

public class SimulationOptions {

    private volatile boolean reproduce, randomlyDie, starve, growGrass;

    public SimulationOptions() {
        // if u want to set these values to false then implement some sort of 
        // initial communication for CheckBoxes in MenuBar (they are set to true)
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
