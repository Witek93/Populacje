package gatunki;

import java.util.BitSet;

public abstract class Zwierze {

    private int _wiek;
    private int _aktywneMutacje;
    private BitSet _genom;
    private int _zdrowie;

    final public void setWiek(int _wiek) {
        this._wiek = _wiek;
    }

    final public int getWiek() {
        return _wiek;
    }

    final public void setAktywneMutacje(int _aktywneMutacje) {
        this._aktywneMutacje = _aktywneMutacje;
    }

    final public int getAktywneMutacje() {
        return _aktywneMutacje;
    }

    final protected void setGenom(BitSet _genom) {
        if (this._genom == null) {
            this._genom = _genom;
        } 
    }

    final public BitSet getGenom() {
        return _genom;
    }

    final public void setZdrowie(int _zdrowie) {
        this._zdrowie = _zdrowie;
    }

    final public int getZdrowie() {
        return _zdrowie;
    }

}
