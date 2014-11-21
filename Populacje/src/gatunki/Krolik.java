package gatunki;

import java.awt.Color;
import java.awt.Point;

public class Krolik extends Zwierze {

    final private static int WIEK_PLODNY = 5;

    public Krolik(Point point) {
        setWiek(0);
        setZdrowie(10);
        setPoint(point);
    }

    @Override
    public Color getColor() {
        return Color.gray;
    }

}
