package mapa;

import gatunki.Zwierze;
import java.awt.Point;
import java.util.List;

public class Mapa {

    private final int _szerokosc, _wysokosc;
    private Pole[][] _pola;

    public Mapa(int szerokosc, int wysokosc) {
        this._szerokosc = szerokosc;
        this._wysokosc = wysokosc;
        inicjujPola();
    }

    private void inicjujPola() {
        _pola = new Pole[_szerokosc][];
        for (int i = 0; i < _szerokosc; i++) {
            _pola[i] = new Pole[_wysokosc];
        }
        resetujPola();
    }

    private void resetujPola() {
        for (int i = 0; i < _szerokosc; i++) {
            for (int j = 0; j < _wysokosc; j++) {
                _pola[i][j] = new Pole(null);
            }
        }
    }

    public void aktualizujMape(List<Zwierze> zwierzeta) {
        resetujPola();
        Point p;
        for (Zwierze zwierze : zwierzeta) {
            p = zwierze.getPoint();
            _pola[p.x][p.y] = new Pole(zwierze);
        }
    }

    public int getSzerokosc() {
        return _szerokosc;
    }

    public int getWysokosc() {
        return _wysokosc;
    }

    public Pole getPole(int i, int j) {
        return _pola[i][j];
    }

}
