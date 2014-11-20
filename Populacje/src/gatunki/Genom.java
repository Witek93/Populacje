package gatunki;

import java.util.BitSet;
import java.util.Random;

public class Genom {

    final private BitSet _genom;

    public Genom(int length) {
        this._genom = new BitSet(length);
        randomize();
    }

    private void randomize() {
        Random generator = new Random();
        for (int i = 0; i < this.length(); i++) {
            if (generator.nextInt(3) == 0) {
                get().set(i);
            }
        }
    }

    public BitSet get() {
        return _genom;
    }
    
    public int length() {
        return get().size();
    }

}
