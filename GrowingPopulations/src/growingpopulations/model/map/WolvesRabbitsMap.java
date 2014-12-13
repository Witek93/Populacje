package growingpopulations.model.map;

import growingpopulations.model.map.fields.Animal;
import growingpopulations.model.map.fields.Rabbit;
import growingpopulations.model.map.fields.Wolf;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WolvesRabbitsMap {

    private Field[][] fields;
    private final List<Point> wolvesCoordinates, rabbitsCoordinates;
    private final int width, height;
    private final Random generator;
    private static final Direction[] directions = Direction.values();

    public WolvesRabbitsMap(int width, int height, int wolvesCount, int rabbitsCount) {
        this.width = width;
        this.height = height;
        this.generator = new Random();
        this.wolvesCoordinates = new ArrayList<>(wolvesCount);
        this.rabbitsCoordinates = new ArrayList<>(rabbitsCount);
        initFields();
        initAnimals(wolvesCount, rabbitsCount);
    }

    public void simulate() {
        simulateWolves();
        simulateRabbits();
    }

    private void simulateRabbits() {
        List<Point> points = new ArrayList<>(rabbitsCoordinates);
        for (Point p : points) {
            //TODO
            moveRabbit(p, randomDirection());
        }
    }

    private void simulateWolves() {
        List<Point> points = new ArrayList<>(wolvesCoordinates);
        for (Point p : points) {
            //TODO
//            moveWolf(p.x, p.y, randomDirection());

        }
    }

    public void growGrass(int ratio) {
        for (Field[] fieldRow : fields) {
            for (Field field : fieldRow) {
                field.growGrass(ratio);
            }
        }
    }

    public void moveRabbit(Point p, Direction d) {
        if (isEmpty(p.x + d.x, p.y + d.y)) { // Rabbit -> Empty
            move(p.x, p.y, d.x, d.y);
            rabbitsCoordinates.remove(p);
            rabbitsCoordinates.add(new Point(p.x + d.x, p.y + d.y));
        }
    }

    private void move(int x, int y, int dx, int dy) {
        fields[x + dx][y + dy].animal = fields[x][y].getAnimal();
        fields[x][y].animal = null;
    }

    private boolean checkContraints(int x, int y) {
        return x >= 0 && x < this.width && y >= 0 && y < this.height;
    }

    private void initFields() {
        fields = new Field[this.width][];
        for (int i = 0; i < this.width; i++) {
            fields[i] = new Field[this.height];
            for (int j = 0; j < this.height; j++) {
                fields[i][j] = new Field(100, null);
            }
        }
    }

    private void initAnimals(int wolvesCount, int rabbitsCount) {
        ArrayList<Point> points = new ArrayList<>(this.width + this.height);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                points.add(new Point(i, j));
            }
        }

        Point point;
        for (int i = 0; i < wolvesCount; i++) {
            point = points.get(generator.nextInt(points.size()));
            fields[point.x][point.y].animal = new Wolf();
            wolvesCoordinates.add(point);
        }

        for (int i = 0; i < rabbitsCount; i++) {
            point = points.get(generator.nextInt(points.size()));
            fields[point.x][point.y].animal = new Rabbit();
            rabbitsCoordinates.add(point);
        }
    }

    public List<Point> getRabbitsCoordinates() {
        return rabbitsCoordinates;
    }

    public List<Point> getWolvesCoordinates() {
        return wolvesCoordinates;
    }

    public List<Point> getEmptyCoordinates() {
        List<Point> points = new ArrayList<>(width * height);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                points.add(new Point(i, j));
            }
        }
        points.removeAll(rabbitsCoordinates);
        points.removeAll(wolvesCoordinates);
        return points;
    }

    private class Field {

        double amount;
        private Animal animal;

        public Field(double amount, Animal animal) {
            this.animal = animal;
        }

        public void growGrass(int ratio) {
            this.amount *= (1 + ratio);
        }

        public Animal getAnimal() {
            return animal;
        }

        public boolean isEmpty() {
            return this.animal == null;
        }

    }

    private boolean isEmpty(int x, int y) {
        if (checkContraints(x, y)) {
            return fields[x][y].isEmpty();
        }
        return false;
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

    private Direction randomDirection() {
        return directions[generator.nextInt(directions.length)];
    }

}
