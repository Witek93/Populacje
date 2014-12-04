package species;

import java.awt.Color;

public class Rabbit extends Animal {

    final private static int productiveAge = 5;

    public Rabbit() {
        this.age = 0;
        this.health = 10;
    }

    @Override
    public Color getColor() {
        return Color.gray;
    }

    @Override
    public int getProductiveAge() {
        return productiveAge;
    }

}
