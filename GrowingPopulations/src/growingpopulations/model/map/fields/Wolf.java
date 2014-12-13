package growingpopulations.model.map.fields;

public class Wolf implements Animal {

    private int age;

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

}
