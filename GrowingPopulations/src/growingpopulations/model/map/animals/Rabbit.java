package growingpopulations.model.map.animals;

public class Rabbit extends Animal {

    protected static final int MAX_AGE = 15;
    private static final double EATING_FACTOR = 0.3;

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public double getEatingFactor() {
        return EATING_FACTOR;
    }

    public Rabbit() {
        this.age = 0;
        this.startvingLevel = 0.0;
    }

}
