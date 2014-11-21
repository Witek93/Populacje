package GUI;

import gatunki.Zwierze;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import mapa.Mapa;
import populacje.Parametry;

public class OknoGlowne {

    JFrame frame;
    PanelMapy panelMapy;
    final private String nazwa;
    final private Parametry parametry;
    final private Mapa mapa;

    public OknoGlowne(String _nazwa, Parametry _parametry, Mapa _mapa) {
        this.nazwa = _nazwa;
        this.parametry = _parametry;
        this.mapa = _mapa;
        inicjuj();
        panelMapy = new PanelMapy(this.mapa);
        frame.add(panelMapy, BorderLayout.CENTER);
        frame.add(zrobPanelOpcji(), BorderLayout.EAST);
        frame.setVisible(true);
    }

    private void inicjuj() {
        frame = new JFrame(nazwa);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
    }

    public void pokaz(List<Zwierze> _zwierzeta) {
        mapa.aktualizujMape(_zwierzeta);
        panelMapy.aktualizuj();
    }

    private JPanel stworzPanelPrzyciskow() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(0, 1, 5, 5);
        panel.setLayout(layout);

        JButton start = new JButton("Start");

        panel.add(start);
        panel.add(new JButton("Aktualizuj"));
        panel.add(new JButton("Resetuj"));
        panel.add(new JButton("Wykres populacji"));
        return panel;
    }

    private JPanel stworzPanelSuwakow() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JSlider szerokosc = new SuwakParametru("Szerokość mapy", 35,
                parametry.getSzerokoscMapy());

        JSlider wysokosc = new SuwakParametru("Wysokość mapy", 45,
                parametry.getWysokoscMapy());

        JSlider ilosc_krolkow = new SuwakParametru("Ilość królików",
                parametry.getMaxKrolikow(), parametry.getIloscKrolikow());

        JSlider ilosc_wilkow = new SuwakParametru("Ilość wilków",
                parametry.getMaxWilkow(), parametry.getIloscWilkow());

        panel.add(szerokosc);
        panel.add(wysokosc);
        panel.add(ilosc_krolkow);
        panel.add(ilosc_wilkow);

        return panel;
    }

    private JPanel zrobPanelOpcji() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Opcje symulacji", JLabel.CENTER), BorderLayout.NORTH);
        panel.setBackground(Color.white);
        panel.add(stworzPanelSuwakow(), BorderLayout.CENTER);
        panel.add(stworzPanelPrzyciskow(), BorderLayout.SOUTH);
        return panel;
    }

}
