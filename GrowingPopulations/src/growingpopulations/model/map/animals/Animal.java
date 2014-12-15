package growingpopulations.model.map.animals;

public interface Animal {

    public void incrementAge();
    public boolean shouldDie();
    public int getAge();
}
