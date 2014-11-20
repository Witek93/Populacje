package populacje;

import populacje.gatunki.Krolik;
import populacje.gatunki.Zwierze;



public class Populacje {


    public static void main(String[] args) {
        Zwierze z = new Krolik();
        System.out.println(z.getZdrowie());
    }
    
}
