package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JPanel;
import map.AnimalField;
import map.EmptyField;
import map.Field;
import populacje.Parameters;
import species.Animal;

public class MapPanel extends JPanel {

    private static volatile MapPanel instance;
    private static Field[][] fields;

    private MapPanel() {
        super();

        this.setLayout(new GridLayout(
                Parameters.getMapWidth(),
                Parameters.getMapHeight()));
        this.setMinimumSize(new Dimension(200, 200));

        initWithEmptyFields();
    }

    public static MapPanel getInstance() {
        if (MapPanel.instance == null) {
            synchronized (MapPanel.class) {
                if (MapPanel.instance == null) {
                    MapPanel.instance = new MapPanel();
                }
            }
        }
        return MapPanel.instance;
    }

    public static void reset() {
        synchronized (MapPanel.class) {
            instance = new MapPanel();
        }
    }

    public void setAnimalFields(HashMap<Point, Animal> animals) {
        Set<Point> points = animals.keySet();
        for (Point point : points) {
            setField(point.x, point.y, animals.get(point));
            updateField(point.x, point.y);
        }
    }

    private static void setField(int x, int y, Animal animal) {
        MapPanel.fields[x][y] = new AnimalField(animal);
    }

    private static void setEmptyField(int x, int y) {
        MapPanel.fields[x][y] = new EmptyField();
    }

    private void updateField(int x, int y) {
        int index = x * Parameters.getMapHeight() + y;
        MapPanel.getInstance().remove(index);
        MapPanel.getInstance().add(MapPanel.getInstance().getField(x, y), index);
    }

    private void initWithEmptyFields() {
        MapPanel.fields = new Field[Parameters.getMapWidth()][];
        for (int i = 0; i < Parameters.getMapWidth(); i++) {
            MapPanel.fields[i] = new Field[Parameters.getMapHeight()];
            for (int j = 0; j < Parameters.getMapHeight(); j++) {
                MapPanel.fields[i][j] = new EmptyField();
                this.add(MapPanel.fields[i][j]);
            }
        }
    }

    public boolean isEmptyField(int x, int y) {
        return MapPanel.fields[x][y] instanceof EmptyField;
    }

    public Field getField(int x, int y) {
        return MapPanel.fields[x][y];
    }

    public void moveAnimal(int x, int y, Direction d) {
        if (!isEmptyField(x, y) && isEmptyField(x + d.x, y + d.y)) {
            setField(x + d.x, y + d.y, ((AnimalField) getField(x, y)).getCurrentSpecies());
            updateField(x + d.x, y + d.y);

            setEmptyField(x, y);
            updateField(x, y);
        }

    }

    public enum Direction {

        NORTH(0, -1);

        private Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x, y;
    }

}
