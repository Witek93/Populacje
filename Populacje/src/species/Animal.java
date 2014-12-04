package species;

import java.awt.Color;

public abstract class Animal {

    protected double age;
    protected int health;

    abstract public Color getColor();

    abstract public int getProductiveAge();

    final public void setAge(double age) {
        this.age = age;
    }

    final public double getAge() {
        return age;
    }

    final public void setHealth(int health) {
        this.health = health;
    }

    final public int getHealth() {
        return health;
    }

}
