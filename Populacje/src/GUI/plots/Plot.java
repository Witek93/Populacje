package GUI.plots;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class Plot extends ChartPanel {

    static private volatile Plot instance;

    private JFreeChart lineChart;
    private final XYSeriesCollection seriesCollection;
    private final Map<String, Series> series;

    private Plot(String x_label, String y_label) {
        super(null);
        this.series = new HashMap<>();
        this.seriesCollection = new XYSeriesCollection();
        init(x_label, y_label);
        this.initSeries();
        System.out.println("konstruktor Plot()");
    }

    private void initSeries() {
        this.addSeries("Populacja królików", "króliki");
        this.addSeries("Populacja wilków", "wilki");
    }

    public static Plot getInstance() {
        if (instance == null) {
            synchronized (Plot.class) {
                if (instance == null) {
                    instance = new Plot("czas", "liczebność");
                }
            }
        }
        return instance;
    }

    public static void reset() {
        synchronized (Plot.class) {
            instance = new Plot("czas", "liczebność");
            instance.getSeriesCollection().removeAllSeries();
            instance.series.clear();
            instance.initSeries();
        }
    }

    private void init(String x_label, String y_label) {
        lineChart = ChartFactory.createXYLineChart(null, x_label, y_label,
                getSeriesCollection(), PlotOrientation.VERTICAL, true, true, false);

        this.setChart(lineChart);
        this.setMinimumSize(new Dimension(200, 200));
        this.setSize(400, 300);
    }

    public final void addSeries(String series_name, String identifier) {
        Series newSeries = new Series(series_name);
        this.series.put(identifier, newSeries);
        getSeriesCollection().addSeries(newSeries.getXYSeries());
    }

    public final XYSeriesCollection getSeriesCollection() {
        return this.seriesCollection;
    }

    public Series getSeries(String key) {
        return this.series.get(key);
    }

}
