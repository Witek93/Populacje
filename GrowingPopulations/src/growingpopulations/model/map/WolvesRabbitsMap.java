package growingpopulations.model.map;

import growingpopulations.model.map.animals.*;
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

    public void reproduceRabbits(double rabbitReproduceRatio, int maxCount) {
        Direction d = null;
        Point target = null;
        for (Point p : getRabbitsCoodinatesCopy()) {
            if (getRabbitsCount() >= maxCount || fields[p.x][p.y].animal.isHungry()) {
                return;
            }
            if (rabbitReproduceRatio > generator.nextDouble()) {
                d = randomDirection();
                target = new Point(p.x + d.x, p.y + d.y);
                if (hasNoAnimal(target)) {
                    createRabbit(target);
                }
            }
        }
    }

    public void reproduceWolves(double wolvesReproduceRatio, int maxCount) {
        Direction d = null;
        Point target = null;
        for (Point p : getWolvesCoodinatesCopy()) {
            if (getWolvesCount() >= maxCount || fields[p.x][p.y].animal.isHungry()) {
                return;
            }
            if (wolvesReproduceRatio > generator.nextDouble()) {
                d = randomDirection();
                target = new Point(p.x + d.x, p.y + d.y);
                if (hasNoAnimal(target)) {
                    createWolf(target);
                }
            }
        }
    }

    public void increaseWolvesStarvation(double wolfStarveRatio) {
        for (Point p : getWolvesCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            fields[p.x][p.y].getAnimal().increaseStarvingLevel(wolfStarveRatio);
        }
    }

    public void increaseRabbitsStarvation(double rabbitStarveRatio) {
        for (Point p : getRabbitsCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            fields[p.x][p.y].getAnimal().increaseStarvingLevel(rabbitStarveRatio);
        }
    }

    public void agingProcess(Point[] animals) {
        for (Point p : getRabbitsCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            fields[p.x][p.y].getAnimal().increaseAge();
        }
    }

    public void agingProcess() {
        agingProcess(getRabbitsCoodinatesCopy());
        agingProcess(getWolvesCoodinatesCopy());
    }

    public void updateDeaths() {
        for (Point p : getRabbitsCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            if (fields[p.x][p.y].getAnimal().shouldDie()) {
                removeRabbit(p);
            }
        }
        for (Point p : getWolvesCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            if (fields[p.x][p.y].getAnimal().shouldDie()) {
                removeWolf(p);
            }
        }
    }

    public void moveRabbits() {
        for (Point p : getRabbitsCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            rabbitsMove(p, randomDirection());
        }
    }

    public void moveWolves() {
        for (Point p : getWolvesCoodinatesCopy()) {
            assert !hasNoAnimal(p);
            Point rabbit = findRabbit(p); //TODO
            if (rabbit == null) {
                wolfMove(p, randomDirection());
            } else {
                wolfHunt(p, rabbit);
            }
        }
    }

    public Point findRabbit(Point p) {
        Point target = null;
        for (int i = p.x - 1; i <= p.x + 1; i++) {
            for (int j = p.y - 1; j <= p.y + 1; j++) {
                target = new Point(i, j);
                if (isRabbit(target)) {
                    return target;
                }
            }
        }
        return null;
    }

    public void growGrass(double ratio) {
        for (Field[] fieldRow : fields) {
            for (Field field : fieldRow) {
                field.growGrass(ratio);
            }
        }
    }

    private void rabbitsMove(Point p, Direction d) {
        Point target = new Point(p.x + d.x, p.y + d.y);
        Field field = fields[p.x][p.y];
        Animal rabbit = field.getAnimal();
        if (rabbit.isHungry() && field.hasEnoughGrass()) {
            rabbit.decreaseHunger();
            field.decreaseGrassAmount();
        }
        if (hasNoAnimal(target)) { // Rabbit -> Empty
            moveRabbitToField(p, target);
        }
    }

    private void wolfMove(Point p, Direction d) {
        Point target = new Point(p.x + d.x, p.y + d.y);
        if (hasNoAnimal(target)) { // Wolf -> Empty
            moveWolfToField(p, target);
        }
    }

    private void wolfHunt(Point p, Point rabbit) {
        Animal wolf = fields[p.x][p.y].getAnimal();
        if (wolf.isHungry()) {
            wolf.decreaseHunger();
            removeRabbit(rabbit);
            moveWolfToField(p, rabbit);
        }
    }

    private void moveRabbitToField(Point p, Point target) {
        assert hasNoAnimal(target);
        fields[target.x][target.y].animal = fields[p.x][p.y].getAnimal();
        rabbitsCoordinates.add(target);
        removeRabbit(p);
    }

    private void moveWolfToField(Point p, Point target) {
        assert hasNoAnimal(target);
        fields[target.x][target.y].animal = fields[p.x][p.y].getAnimal();
        wolvesCoordinates.add(target);
        removeWolf(p);
    }

    private void removeRabbit(Point p) {
        if (isRabbit(p)) {
            rabbitsCoordinates.remove(p);
            fields[p.x][p.y].animal = null;
        }
    }

    private void createRabbit(Point p) {
        rabbitsCoordinates.add(p);
        fields[p.x][p.y].animal = new Rabbit();
    }

    private void removeWolf(Point p) {
        if (isWolf(p)) {
            wolvesCoordinates.remove(p);
            fields[p.x][p.y].animal = null;
        }
    }

    private void createWolf(Point p) {
        wolvesCoordinates.add(p);
        fields[p.x][p.y].animal = new Wolf();
    }

    private boolean checkContraints(Point p) {
        return p.x >= 0 && p.x < this.width && p.y >= 0 && p.y < this.height;
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

    public Point[] getWolvesCoodinatesCopy() {
        return wolvesCoordinates.toArray(new Point[wolvesCoordinates.size()]);
    }

    public Point[] getRabbitsCoodinatesCopy() {
        return rabbitsCoordinates.toArray(new Point[rabbitsCoordinates.size()]);
    }

    public int getRabbitsCount() {
        return rabbitsCoordinates.size();
    }

    public int getWolvesCount() {
        return wolvesCoordinates.size();

    }

    private class Field {

        double amount;
        private Animal animal;

        public Field(double amount, Animal animal) {
            this.animal = animal;
            this.amount = 100.0;
        }

        public boolean hasEnoughGrass() {
            return this.amount > 25.0;
        }

        public void decreaseGrassAmount() {
            this.amount = Math.max(0, this.amount - 50.0);
        }

        public void growGrass(double ratio) {
            this.amount = Math.floor(Math.max(20, Math.min(this.amount * (1 + ratio), 200)));
        }

        public Animal getAnimal() {
            return animal;
        }

    }

    private boolean hasNoAnimal(Point p) {
        if (checkContraints(p)) {
            return fields[p.x][p.y].getAnimal() == null;
        }
        return false;
    }

    private boolean isRabbit(Point p) {
        if (checkContraints(p)) {
            return fields[p.x][p.y].getAnimal() instanceof Rabbit;
        }
        return false;
    }

    private boolean isWolf(Point p) {
        if (checkContraints(p)) {
            return fields[p.x][p.y].getAnimal() instanceof Wolf;
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

    public List<Point> getNoAnimalsCoordinates() {
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

}
