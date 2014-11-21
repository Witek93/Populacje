package populacje;

public class Parametry {

    private int _iloscKrolikow;
    private int _iloscWilkow;
    private int _szerokoscMapy;
    private int _wysokoscMapy;

    public final int MAX_SZEROKOSC_MAPY = 100;
    public final int MAX_WYSOKOSC_MAPY = 100;

    public Parametry(int iloscKrolikow, int iloscWilkow, int szerokoscMapy, int wysokoscMapy) {
        setIloscKrolikow(iloscKrolikow);
        setIloscWilkow(iloscWilkow);
        setSzerokoscMapy(szerokoscMapy);
        setWysokoscMapy(wysokoscMapy);
    }

    public int getMaxKrolikow() {
        return (int) (getSzerokoscMapy() * getWysokoscMapy() * 0.5);
    }

    public int getMaxWilkow() {
        return (int) (getSzerokoscMapy() * getWysokoscMapy() * 0.2);
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

    final public void setSzerokoscMapy(int _szerokoscMapy) {
        this._szerokoscMapy = _szerokoscMapy;
    }

    public int getSzerokoscMapy() {
        return _szerokoscMapy;
    }

    final public void setWysokoscMapy(int _wysokoscMapy) {
        this._wysokoscMapy = _wysokoscMapy;
    }

    public int getWysokoscMapy() {
        return _wysokoscMapy;
    }

}
