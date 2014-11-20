package populacje;

import gatunki.Zwierze;
import java.util.logging.Level;
import java.util.logging.Logger;
import populacje.wyjatki.UjemnaIloscZwierzatException;
import populacje.wyjatki.ZaMaloJedzeniaException;

public class Populacje {

    public static void main(String[] args) {
        Parametry parametry;
        try {
            parametry = new Parametry(3, 2, 100, 20);
            Symulacja s = new Symulacja(parametry);
            for (Zwierze e : s.getZwierzeta()) {
                System.out.println(e.getClass());
            }
        } catch (UjemnaIloscZwierzatException | ZaMaloJedzeniaException ex) {
            System.err.println("WYJATEK: Niepoprawne dane w parametrach");
        } catch (Exception ex) {
            Logger.getLogger(Populacje.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
