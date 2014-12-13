package growingpopulations.model;

public class SimulationOptions {

    public volatile boolean canReproduce, canDie, canStarve;

    public SimulationOptions() {
        // if u want to set these values to false then implement some sort of 
        // initial communication for CheckBoxes in MenuBar (they are set to true)
        this.canReproduce = true;
        this.canDie = true;
        this.canStarve = true;
    }

    public boolean canReproduce() {
        return canReproduce;
    }

    public void setCanReproduce(boolean canReproduce) {
        this.canReproduce = canReproduce;
    }

    public boolean canDie() {
        return canDie;
    }

    public void setCanDie(boolean canDie) {
        this.canDie = canDie;
    }

    public boolean canStarve() {
        return canStarve;
    }

    public void setCanStarve(boolean canStarve) {
        this.canStarve = canStarve;
    }

}
