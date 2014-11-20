package populacje;

import java.util.LinkedList;
import java.util.List;
import gatunki.Krolik;
import gatunki.Wilk;
import gatunki.Zwierze;


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
        for(int i = 0; i < liczbaKrolikow; i++)
            getZwierzeta().add(new Krolik());
        for(int i = 0; i < liczbaWilkow; i++)
            getZwierzeta().add(new Wilk());
    }
    
    
    
}
