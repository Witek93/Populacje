package growingpopulations.model;

import growingpopulations.model.map.WolvesRabbitsMap;

public class Model {

    private final Parameters parameters;
    private final Options options;
    private final Factors factors;
    private WolvesRabbitsMap map;

    public Model() {
        this.parameters = new Parameters(30, 40, 300, 20, true);
        this.options = new Options();
        this.factors = new Factors();
        this.map = new WolvesRabbitsMap(
                parameters.getMapWidth(), parameters.getMapHeight(),
                parameters.getWolvesCount(), parameters.getRabbitsCount());
    }

    public final void reinitializeMap() {
        this.map = new WolvesRabbitsMap(
                parameters.getMapWidth(), parameters.getMapHeight(),
                parameters.getWolvesCount(), parameters.getRabbitsCount());
    }

    public int calculateMaxRabbitsCount() {
        return (int) (parameters.getMapHeight() * parameters.getMapWidth() * 0.5);
    }

    public int calculateMaxWolvesCount() {
        return (int) (parameters.getMapHeight() * parameters.getMapWidth() * 0.2);
    }

    // ----------------------- getters & setters -------------------------

    public Parameters getParameters() {
        return parameters;
    }

    public Options getOptions() {
        return options;
    }

    public Factors getFactors() {
        return factors;
    }

    public WolvesRabbitsMap getMap() {
        return map;
    }

}
