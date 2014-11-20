package wykresy;

public class Gen {
    
    public static void main(String arg[]) throws InterruptedException{
    GeneratorWykresow g = new GeneratorWykresow(2);
    
    g.wyswietlXY();
        for (int i=0;i<50;i++){
            g.dodajPunkt(i, i,1);
            Thread.sleep(1000);
            g.dodajPunkt(i, i+1,2);
        }
}
}
