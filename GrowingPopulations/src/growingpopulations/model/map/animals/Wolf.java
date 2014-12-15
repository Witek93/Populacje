package growingpopulations.model.map.animals;

public class Wolf implements Animal {

    private int age;
    private final static int MAX_AGE = 20;

    public Wolf() {
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
