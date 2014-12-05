package species;

import java.awt.Color;

public class Rabbit extends Animal {

    public Rabbit() {
        this.age = 0;
        this.productiveAge = 2;
        this.dyingAge = 10;
    }

    @Override
    public Color getColor() {
        return Color.gray;
    }

}
