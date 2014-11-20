package wykresy;

public class GeneratorWykresow {
    
    static public Wykres generuj(String nazwa, String xLabel, String yLabel) {
        return new Wykres(nazwa, xLabel, yLabel);
    }
    
    static public Seria generujSerie(String nazwa) {
        return new Seria(nazwa);
    }

}
