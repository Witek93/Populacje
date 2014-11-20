package populacje.gatunki;

import java.util.BitSet;


public class Krolik extends Zwierze {

    public Krolik() {
        setWiek(0);
        setAktywneMutacje(0);
        setGenom(new BitSet(8));
        setZdrowie(10);
    }
    
}
