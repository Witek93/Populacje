package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import mapa.Mapa;
import mapa.Pole;

public class PanelMapy extends JPanel {

    private final Mapa mapa;

    public PanelMapy(Mapa _mapa) {
        super(new GridLayout(_mapa.getSzerokosc(), _mapa.getWysokosc()));
        this.setBorder(new LineBorder(Color.black, 3));
        this.mapa = _mapa;
        generujPola();
    }

    public void aktualizuj() {
        Pole pole;
        PoleMapy pm;
        for (int i = 0; i < mapa.getSzerokosc(); i++) {
            for (int j = 0; j < mapa.getWysokosc(); j++) {
                pole = mapa.getPole(i, j);
                pm = (PoleMapy) this.getComponent(i * mapa.getWysokosc() + j);
                if (pole.getObecny_osobnik() == null) {
                    pm.setBackground(Color.green);
                } else {
                    pm.setBackground(pole.getObecny_osobnik().getColor());
                }
            }
        }
    }

    private void generujPola() {
        Pole pole;
        PoleMapy pm;
        for (int i = 0; i < mapa.getSzerokosc(); i++) {
            for (int j = 0; j < mapa.getWysokosc(); j++) {
                pole = mapa.getPole(i, j);
                pm = new PoleMapy(pole);
                if (pole.getObecny_osobnik() == null) {
                    pm.setBackground(Color.green);
                } else {
                    pm.setBackground(pole.getObecny_osobnik().getColor());
                }
                this.add(pm);
            }
        }
    }

}
