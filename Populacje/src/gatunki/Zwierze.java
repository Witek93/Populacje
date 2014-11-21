package gatunki;

import java.awt.Color;
import java.awt.Point;

public abstract class Zwierze {

    private int _wiek;
    private int _zdrowie;
    private Point _point;

    abstract public Color getColor();

    final public void setWiek(int _wiek) {
        this._wiek = _wiek;
    }

    final public int getWiek() {
        return _wiek;
    }

    final public void setZdrowie(int _zdrowie) {
        this._zdrowie = _zdrowie;
    }

    final public int getZdrowie() {
        return _zdrowie;
    }

    public void setPoint(Point _point) {
        this._point = _point;
    }

    public Point getPoint() {
        return _point;
    }

    public void translatePoint(int dx, int dy) {
        _point.x += dx;
        _point.y += dy;
    }

    public void movePoint(Point p) {
        _point.move(p.x, p.y);
    }

}
