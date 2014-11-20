package wykresy;

import java.util.LinkedList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GeneratorWykresow {

    private XYSeriesCollection dataset;
    private LinkedList<XYSeries> serie;
    //private XYSeries seria,seria;

    public final XYSeriesCollection getDataset() {
        return dataset;
    }
    /*
     public final XYSeries getSeria(){
     return seria;
     } 
    
     public final XYSeries getSeria2(){
     return seria2;
     }
    
     public final void setSeria1(XYSeries seria1){
     this.seria=seria1;
     }
    
     public final void setSeria2(XYSeries seria2){
     this.seria2=seria2;
     }
     */

    public final void setDataset(XYSeriesCollection dataset) {
        this.dataset = dataset;
    }

    public XYSeries getSeria(int i) { //zwraca nr populacji
        for (int j = 0; j < serie.size(); j++) {
            if (serie.get(j) == serie.get(i)) {
                return serie.get(j);
            }
        }

        return null;
    }

    public GeneratorWykresow(int iloscGatunkow) {
        serie = new LinkedList<>();

        /*setSeria1(new XYSeries("Populacja"));
         setSeria2(new XYSeries("Populacja2"));*/
        setDataset(new XYSeriesCollection());

        for (int i = 0; i < iloscGatunkow; i++) {
            serie.add(new XYSeries("Populacja " + (i + 1)));
            getDataset().addSeries(serie.get(i));
        }
    }

    public void dodajPunkt(float x, float y, int i) {//i = nr populacji
        getSeria(i - 1).add(x, y);
    }

    public void wyswietlXY() {
        JFreeChart chart = ChartFactory.createXYLineChart("Wykres", "Time", "Y - lable", getDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("XYArea Chart", chart);
        frame.setVisible(true);
        frame.setSize(400, 300);

        // XYPlot plot = chart.getXYPlot();
        //DateAxis axis = (DateAxis) plot.getDomainAxis();
        //axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
    }
}
