package wykresy;

import java.util.Random;

public class Example {

    public static void main(String arg[]) throws InterruptedException {
        Wykres w1 = GeneratorWykresow.generuj("Wykres populacji", "czas", "liczebność");
        w1.dodajSerie("Populacja krolikow", "króliki");
        w1.iniciuj();

        Random gen = new Random();

        for (int i = 0; i < 100; i++) {
            w1.getSeria("króliki").dodajPunkt(i, gen.nextFloat());
            Thread.sleep(100);
        }
    }
}
