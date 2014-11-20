package wykresy;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class Wykres {

    private XYSeriesCollection _seria_danych;
    private final Map<String, Seria> _serie;
    private final String _nazwa;
    private final String _xLabel;
    private final String _yLabel;

    public Wykres(String _nazwa, String _xLabel, String _yLabel) {
        this._serie = new HashMap<>();
        this._nazwa = _nazwa;
        this._xLabel = _xLabel;
        this._yLabel = _yLabel;

        setDataset(new XYSeriesCollection());
    }

    public void dodajSerie(String nazwa, String klucz) {
        Seria seria = GeneratorWykresow.generujSerie(nazwa);
        getSerie().put(klucz, seria);
        getDataset().addSeries(seria.getXYSeries());
    }

    public final void iniciuj() {
        JFreeChart chart = ChartFactory.createXYLineChart(null, _xLabel, _yLabel,
                getDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame(_nazwa, chart);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public final XYSeriesCollection getDataset() {
        return _seria_danych;
    }

    public final void setDataset(XYSeriesCollection dataset) {
        this._seria_danych = dataset;
    }

    private Map<String, Seria> getSerie() {
        return this._serie;
    }

    public Seria getSeria(String key) {
        return getSerie().get(key);
    }

}
