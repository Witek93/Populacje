package species;

import java.awt.Color;

public class Wolf extends Animal {

    public Wolf() {
        this.age = 0;
        this.productiveAge = 6;
        this.dyingAge = 20;
    }

    @Override
    public Color getColor() {
        return Color.red;
    }
}
