package populacje;

import java.util.LinkedList;
import java.util.List;
import gatunki.*;
import java.awt.Point;
import java.util.Random;

public class Symulacja {

    private List<Zwierze> _zwierzeta;
    private final Parametry _parametry;

    public Symulacja(Parametry parametry) {
        setZwierzeta(new LinkedList<>());
        this._parametry = parametry;
        for (int i = 0; i < parametry.getIloscKrolikow(); i++) {
            getZwierzeta().add(new Krolik(new Point(-1, -1)));
        }
        for (int i = 0; i < parametry.getIloscWilkow(); i++) {
            getZwierzeta().add(new Wilk(new Point(-1, -1)));
        }
        rozlokujLosowo();
    }

    final public void rozlokujLosowo() {
        List<Point> points = stworzListePol();
        Point point;
        int index;
        Random gen = new Random();
        for (Zwierze zwierze : getZwierzeta()) {
            index = gen.nextInt(points.size());
            point = points.get(index);
            zwierze.movePoint(point);
            points.remove(index);
        }
    }

    private List<Point> stworzListePol() {
        List<Point> l = new LinkedList<>();
        for (int i = 0; i < _parametry.getSzerokoscMapy(); i++) {
            for (int j = 0; j < _parametry.getWysokoscMapy(); j++) {
                l.add(new Point(i, j));
            }
        }
        return l;
    }

    final public void setZwierzeta(List<Zwierze> _zwierzeta) {
        this._zwierzeta = _zwierzeta;
    }

    final public List<Zwierze> getZwierzeta() {
        return _zwierzeta;
    }

}
