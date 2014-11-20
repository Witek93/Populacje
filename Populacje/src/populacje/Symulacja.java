package populacje;

import java.util.LinkedList;
import java.util.List;
import gatunki.*;

public class Symulacja {

    private List<Zwierze> _zwierzeta;
    private Parametry _parametry;

    public Symulacja(Parametry parametry) {
        setZwierzeta(new LinkedList<>());
        this._parametry = parametry;
        for (int i = 0; i < parametry.getIloscKrolikow(); i++) {
            getZwierzeta().add(new Krolik());
        }
        for (int i = 0; i < parametry.getIloscWilkow(); i++) {
            getZwierzeta().add(new Wilk());
        }
    }

    final public void setZwierzeta(List<Zwierze> _zwierzeta) {
        this._zwierzeta = _zwierzeta;
    }

    final public List<Zwierze> getZwierzeta() {
        return _zwierzeta;
    }

}
