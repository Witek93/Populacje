package wykresy;

import org.jfree.data.xy.XYSeries;

public class Seria {
    XYSeries _xySeries;

    public Seria(String _nazwa) {
        this._xySeries = new XYSeries(_nazwa);
    }

    public void dodajPunkt(float x, float y) {
        this._xySeries.add(x, y);
    }

    public XYSeries getXYSeries() {
        return _xySeries;
    }
    
    
}
