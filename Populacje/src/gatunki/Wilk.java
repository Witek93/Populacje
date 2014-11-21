package gatunki;

import java.awt.Color;
import java.awt.Point;

public class Wilk extends Zwierze {

    final private static int WIEK_PLODNY = 10;

    public Wilk(Point point) {
        setWiek(0);
        setZdrowie(25);
        setPoint(point);
    }

    @Override
    public Color getColor() {
        return Color.red;
    }

}
