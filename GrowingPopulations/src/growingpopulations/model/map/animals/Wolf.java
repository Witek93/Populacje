package growingpopulations.model.map.animals;

public class Wolf extends Animal {

    protected static final int MAX_AGE = 25;
    private static final double EATING_FACTOR = 0.5;

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public double getEatingFactor() {
        return EATING_FACTOR;
    }

    public Wolf() {
        this.age = 0;
        this.startvingLevel = 0.0;
    }

}
