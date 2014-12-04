package GUI.plots;

import org.jfree.data.xy.XYSeries;

public class Series {
    XYSeries xySeries;

    public Series(String series_name) {
        this.xySeries = new XYSeries(series_name);
    }

    public void appendPoint(float x, float y) {
        this.xySeries.add(x, y);
    }

    public XYSeries getXYSeries() {
        return xySeries;
    }
    
    
}
