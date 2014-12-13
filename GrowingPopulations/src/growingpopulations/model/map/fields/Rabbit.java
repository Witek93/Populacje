package growingpopulations.model.map.fields;

public class Rabbit implements Animal {

    private int age;

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

}
