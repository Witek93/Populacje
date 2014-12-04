package species;

import java.awt.Color;

public class Wolf extends Animal {

    final private static int productiveAge = 10;

    public Wolf() {
        this.age = 0;
        this.health = 25;
    }

    @Override
    public Color getColor() {
        return Color.red;
    }

    @Override
    public int getProductiveAge() {
        return productiveAge;
    }

}
