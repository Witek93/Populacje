package populacje;

import GUI.SimulationWindow;

public class Populations {

    public static void main(String[] args) throws InterruptedException {

        // potrzebne, aby szerokość mapy mogła być większa niż 45
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        
        Thread thread = new Thread(new SimulationWindow());
        thread.start();

    }

}
