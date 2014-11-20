package populacje;

import populacje.wyjatki.UjemnaIloscZwierzatException;
import populacje.wyjatki.ZaMaloJedzeniaException;

public class Parametry {

    private int _iloscKrolikow;
    private int _iloscWilkow;
    private int _iloscJedzeniaDlaKrolikow;
    private int _iloscJedzeniaDlaWilkow;

    public Parametry(int iloscKrolikow, int iloscWilkow, int iloscJedzeniaDlaKrolikow, int iloscJedzeniaDlaWilkow)
            throws Exception {
        waliduj(iloscKrolikow, iloscWilkow, iloscJedzeniaDlaKrolikow, iloscJedzeniaDlaWilkow);
        setIloscKrolikow(iloscKrolikow);
        setIloscWilkow(iloscWilkow);
        setIloscJedzeniaDlaKrolikow(iloscJedzeniaDlaKrolikow);
        setIloscJedzeniaDlaWilkow(iloscJedzeniaDlaWilkow);
    }

    private void waliduj(int liczbaKrolikow, int liczbaWilkow, int iloscJedzeniaDlaKrolikow, int iloscJedzeniaDlaWilkow)
            throws Exception {
        if (liczbaKrolikow < 0 || liczbaWilkow < 0) {
            throw new UjemnaIloscZwierzatException();
        }
        if (iloscJedzeniaDlaKrolikow < 0 || iloscJedzeniaDlaWilkow < 0) {
            throw new ZaMaloJedzeniaException();
        }
    }

    final public void setIloscKrolikow(int iloscKrolikow) {
        this._iloscKrolikow = iloscKrolikow;
    }

    public int getIloscKrolikow() {
        return _iloscKrolikow;
    }

    final public void setIloscWilkow(int iloscWilkow) {
        this._iloscWilkow = iloscWilkow;
    }

    public int getIloscWilkow() {
        return _iloscWilkow;
    }

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

}
