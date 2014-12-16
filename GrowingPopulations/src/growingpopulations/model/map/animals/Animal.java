package growingpopulations.model.map.animals;

abstract public class Animal {

    protected int age;
    protected double startvingLevel;

    public abstract int getMaxAge();

    public abstract double getEatingFactor();

    public void decreaseHunger() {
        this.startvingLevel = Math.max(0, this.startvingLevel - getEatingFactor());
    }

    public boolean isHungry() {
        return this.startvingLevel > 0.7;
    }

    public boolean shouldDie() {
        if (this.age > getMaxAge()) {
            return true;
        }
        if (this.startvingLevel == 1.0) {
            return true;
        }
        return false;
    }

    public void increaseAge() {
        this.age++;
    }

    public void increaseStarvingLevel(double starvingInfluence) {
        this.startvingLevel = Math.min(1.0, startvingLevel + starvingInfluence);
    }

    public int getAge() {
        return age;
    }

}
