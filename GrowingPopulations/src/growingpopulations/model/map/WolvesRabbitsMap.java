package growingpopulations.model.map;

import growingpopulations.model.map.animals.Animal;
import growingpopulations.model.map.animals.Rabbit;
import growingpopulations.model.map.animals.Wolf;
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
        initFields(wolvesCount, rabbitsCount);
    }

    public void simulate() {
        simulateRabbits();
        simulateWolves();
    }

    private void simulateRabbits() {
        Point[] points = rabbitsCoordinates.toArray(new Point[rabbitsCoordinates.size()]);
        for (Point p : points) {
            assert !isEmpty(p.x, p.y);
            Animal animal = fields[p.x][p.y].getAnimal();
            animal.incrementAge();
            if (animal.shouldDie()) {
                rabbitsCoordinates.remove(p);
            } else {
                moveRabbit(p, randomDirection());
            }
        }
    }

    private void simulateWolves() {
        Point[] points = wolvesCoordinates.toArray(new Point[wolvesCoordinates.size()]);
        for (Point p : points) {
            assert !isEmpty(p.x, p.y);
            Animal animal = fields[p.x][p.y].getAnimal();
            animal.incrementAge();
            if (animal.shouldDie()) {
                wolvesCoordinates.remove(p);
            } else {
                moveWolf(p, randomDirection());
            }
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
            moveToEmpty(p, d);
            rabbitsCoordinates.remove(p);
            rabbitsCoordinates.add(new Point(p.x + d.x, p.y + d.y));
        }
    }

    public void agingProcess(Point p) {
        assert !isEmpty(p.x, p.y);
        Animal animal = fields[p.x][p.y].getAnimal();
        animal.incrementAge();
        if (animal.shouldDie()) {
            if (isWolf(p.x, p.y)) {
                wolvesCoordinates.remove(p);
            } else if (isRabbit(p.x, p.y)) {
                rabbitsCoordinates.remove(p);
            }
        }
    }

    public void moveWolf(Point p, Direction d) {
        if (isEmpty(p.x + d.x, p.y + d.y)) { // Wolf -> Empty
            moveToEmpty(p, d);
            wolvesCoordinates.remove(p);
            wolvesCoordinates.add(new Point(p.x + d.x, p.y + d.y));
        }
    }

    private void moveToEmpty(Point p, Direction d) {
        fields[p.x + d.x][p.y + d.y].animal = fields[p.x][p.y].getAnimal();
        fields[p.x][p.y].animal = null;
    }

    private boolean checkContraints(int x, int y) {
        return x >= 0 && x < this.width && y >= 0 && y < this.height;
    }

    private void initFields(int wolvesCount, int rabbitsCount) {
        reset();

        ArrayList<Point> points = new ArrayList<>(this.width + this.height);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                points.add(new Point(i, j));
            }
        }

        Point point;
        for (int i = 0; i < wolvesCount; i++) {
            point = points.get(generator.nextInt(points.size()));
            points.remove(point);
            fields[point.x][point.y].animal = new Wolf();
            wolvesCoordinates.add(point);
        }

        for (int i = 0; i < rabbitsCount; i++) {
            point = points.get(generator.nextInt(points.size()));
            points.remove(point);
            fields[point.x][point.y].animal = new Rabbit();
            rabbitsCoordinates.add(point);
        }
    }

    private void reset() {
        this.wolvesCoordinates.clear();
        this.rabbitsCoordinates.clear();

        this.fields = new Field[this.width][];
        for (int i = 0; i < this.width; i++) {
            this.fields[i] = new Field[this.height];
            for (int j = 0; j < this.height; j++) {
                this.fields[i][j] = new Field(100, null);
            }
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

    }

    private boolean isEmpty(int x, int y) {
        if (checkContraints(x, y)) {
            return fields[x][y].getAnimal() == null;
        }
        return false;
    }

    private boolean isWolf(int x, int y) {
        if (checkContraints(x, y)) {
            return fields[x][y].getAnimal() instanceof Wolf;
        }
        return false;
    }

    private boolean isRabbit(int x, int y) {
        if (checkContraints(x, y)) {
            return fields[x][y].getAnimal() instanceof Rabbit;
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
