package populacje;

import java.util.LinkedList;
import java.util.List;
import gatunki.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Symulacja {

    private int _iloscJedzeniaDlaKrolikow;
    private int _iloscJedzeniaDlaWilkow;
    private List<Zwierze> _zwierzeta;

    final public void setIloscJedzeniaDlaKrolikow(int iloscJedzeniaDlaKrolikow) {
        this._iloscJedzeniaDlaKrolikow = iloscJedzeniaDlaKrolikow;
    }

    public int getIloscJedzeniaDlaKrolikow() {
        return _iloscJedzeniaDlaKrolikow;
    }

    final public void setIloscJedzeniaDlaWilkow(int iloscJedzeniaDlaWilkow) {
        this._iloscJedzeniaDlaWilkow = iloscJedzeniaDlaWilkow;
    }

    public int getIloscJedzeniaDlaWilkow() {
        return _iloscJedzeniaDlaWilkow;
    }

    final public void setZwierzeta(List<Zwierze> _zwierzeta) {
        this._zwierzeta = _zwierzeta;
    }

    final public List<Zwierze> getZwierzeta() {
        return _zwierzeta;
    }

    public Symulacja(int liczbaKrolikow, int liczbaWilkow) {
        setZwierzeta(new LinkedList<>());
        try {
            walidujLiczbeZwierzat(liczbaKrolikow, liczbaWilkow);
            for (int i = 0; i < liczbaKrolikow; i++) {
                getZwierzeta().add(new Krolik());
            }
            for (int i = 0; i < liczbaWilkow; i++) {
                getZwierzeta().add(new Wilk());
            }
        } catch (Exception ex) {
            Logger.getLogger(Symulacja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void walidujLiczbeZwierzat(int liczbaKrolikow, int liczbaWilkow) throws Exception {
        if (liczbaKrolikow < 0 || liczbaWilkow < 0) {
            throw new Exception("Niepoprawna liczba królików i/lub wilków");
        }
    }

}
