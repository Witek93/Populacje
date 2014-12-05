package species;

import java.awt.Color;

public abstract class Animal {

    protected int age;
    protected int dyingAge;
    protected int productiveAge;

    abstract public Color getColor();

    public boolean isProductiveAge() {
        return getAge() >= productiveAge;
    }

    final public void incAge() {
        this.age++;
    }

    final public int getAge() {
        return age;
    }

    public boolean isDyingAge() {
        return getAge() >= dyingAge;
    }

}
