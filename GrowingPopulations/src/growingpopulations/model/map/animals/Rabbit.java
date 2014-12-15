package growingpopulations.model.map.animals;

public class Rabbit implements Animal {

    private int age;
    private static final int MAX_AGE = 10;

    public Rabbit() {
        this.age = 0;
    }

    @Override
    public void incrementAge() {
        this.age++;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean shouldDie() {
        return this.age > MAX_AGE;
    }

}
