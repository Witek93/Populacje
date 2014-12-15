package growingpopulations.view.plots;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Plot extends ChartPanel {

    static private volatile Plot instance = null;

    private final JFreeChart lineChart;
    private final XYSeriesCollection seriesCollection;
    private final Map<String, XYSeries> seriesMap;

    private Plot(String x_label, String y_label) {
        super(null);
        this.seriesMap = new HashMap<>();
        this.seriesCollection = new XYSeriesCollection();

        this.addSeries("Populacja królików", "króliki");
        this.addSeries("Populacja wilków", "wilki");

        this.lineChart = ChartFactory.createXYLineChart(null, x_label, y_label,
                this.seriesCollection, PlotOrientation.VERTICAL, true, true, false);

        init();
    }

    public static Plot getInstance() {
        if (Plot.instance == null) {
            reset();
        }
        return Plot.instance;
    }

    public static void reset() {
        synchronized (Plot.class) {
            Plot.instance = new Plot("czas", "liczebność");
        }
    }

    private void init() {
        this.removeAll();
        this.setChart(this.lineChart);
        this.setMinimumSize(new Dimension(200, 200));
        this.setSize(400, 300);
    }

    public final void addSeries(String series_name, String identifier) {
        XYSeries newSeries = new XYSeries(series_name);
        this.seriesMap.put(identifier, newSeries);
        this.seriesCollection.addSeries(newSeries);
    }

    public XYSeries getSeries(String key) {
        return this.seriesMap.get(key);
    }

}
