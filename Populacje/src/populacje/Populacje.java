package populacje;

import GUI.OknoGlowne;
import mapa.Mapa;

public class Populacje {

    public static void main(String[] args) throws InterruptedException {

        Parametry parametry = new Parametry(100, 2, 20, 30);
        Symulacja s = new Symulacja(parametry);
        Mapa mapa = new Mapa(parametry.getSzerokoscMapy(), parametry.getWysokoscMapy());

        OknoGlowne okno = new OknoGlowne("Symulacja populacji", parametry, mapa);

        while (true) {
            Thread.sleep(500);
            s.rozlokujLosowo();
            okno.pokaz(s.getZwierzeta());
        }
    }

}
