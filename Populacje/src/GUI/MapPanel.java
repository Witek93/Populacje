package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import map.AnimalField;
import map.EmptyField;
import map.Field;
import populacje.Parameters;
import species.Animal;
import species.Rabbit;
import species.Wolf;

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

    public List<Point> getAnimals() {
        ArrayList<Point> animals = new ArrayList<>();
        for (int i = 0; i < Parameters.getMapWidth(); i++) {
            for (int j = 0; j < Parameters.getMapHeight(); j++) {
                if (!isEmptyField(i, j)) {
                    animals.add(new Point(i, j));
                }
            }
        }
        return animals;
    }

    public void removeAnimal(int x, int y) {
        if (isRabbit(x, y)) {
            Parameters.decCurrentRabbitsCount();
        } else if (isWolf(x, y)) {
            Parameters.decCurrentWolvesCount();
        } else {
            return;
        }
        setEmptyField(x, y);
        updateField(x, y);
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

    private boolean isRabbit(int x, int y) {
        if (!isEmptyField(x, y)) {
            if (((AnimalField) getField(x, y)).getCurrentSpecies() instanceof Rabbit) {
                return true;
            }
        }
        return false;
    }

    private boolean isWolf(int x, int y) {
        if (!isEmptyField(x, y)) {
            if (((AnimalField) getField(x, y)).getCurrentSpecies() instanceof Wolf) {
                return true;
            }
        }
        return false;
    }

    public Field getField(int x, int y) {
        return MapPanel.fields[x][y];
    }

    public void moveAnimal(int x, int y, Direction d) {
        if (checkContraints(x, y) && checkContraints(x + d.x, y + d.y)) {
            if (!isEmptyField(x, y)) {
                if (isEmptyField(x + d.x, y + d.y)) { // Animal -> Empty
                    moveAnimalToEmptyField(x, y, d.x, d.y);
                } else if (isWolf(x, y) && isRabbit(x + d.x, y + d.y)) { // Wolf -> Rabbit
                    //TODO zjedz
                    eatRabbit(x + d.x, y + d.y);
                } else if (isRabbit(x, y) && isWolf(x + d.x, y + d.y)) { // Rabbit -> Wolf
                    //TODO uciekaj
                    runAway(x, y, d.x, d.y);
                }
            }
        }
    }

    private void runAway(int x, int y, int dx, int dy) {
        if (checkContraints(x, y) && checkContraints(x - dx, y - dy)) {
            if (isEmptyField(x - dx, y - dy)) {
                moveAnimalToEmptyField(x, y, -dx, -dy);
            }
        }
    }

    private void eatRabbit(int x, int y) {
        removeAnimal(x, y);
    }

    private boolean checkContraints(int x, int y) {
        return x >= 0 && x < Parameters.getMapWidth()
                && y >= 0 && y < Parameters.getMapHeight();
    }

    private void moveAnimalToEmptyField(int x, int y, int dx, int dy) {
        setField(x + dx, y + dy, ((AnimalField) getField(x, y)).getCurrentSpecies());
        updateField(x + dx, y + dy);
        setEmptyField(x, y);
        updateField(x, y);
    }

    public enum Direction {

        NORTH(-1, 0),
        SOUTH(1, 0),
        EAST(0, 1),
        WEST(0, -1),
        NORTH_EAST(-1, 1),
        NORTH_WEST(-1, -1),
        SOUTH_EAST(1, 1),
        SOUTH_WEST(1, -1);

        private Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x, y;

    }

}
