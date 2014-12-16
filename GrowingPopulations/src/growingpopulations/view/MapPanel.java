package growingpopulations.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MapPanel extends JPanel {

    private JPanel[][] fields;
    private int width, height;
    private final Color wolfColor, rabbitColor, grassColor;

    public MapPanel() {
        super();
        this.width = 0;
        this.height = 0;
        this.wolfColor = Color.red;
        this.rabbitColor = Color.gray;
        this.grassColor = Color.green;
    }

    synchronized public void generateMapPanel(int width, int height) {
        this.width = width;
        this.height = height;

        this.removeAll();
        this.setLayout(new GridLayout(width, height));
        this.initFields();
        this.revalidate();
    }

    private void initFields() {
        fields = new JPanel[this.width][];
        for (int i = 0; i < this.width; i++) {
            fields[i] = new JPanel[this.height];
            for (int j = 0; j < this.height; j++) {
                fields[i][j] = createField();
                this.add(fields[i][j]);
            }
        }
    }

    public void drawAll(List<Point> noAnimals, List<Point> wolves, List<Point> rabbits) {
        for (Point p : wolves) {
            this.fields[p.x][p.y].setBackground(wolfColor);
        }
        for (Point p : rabbits) {
            this.fields[p.x][p.y].setBackground(rabbitColor);
        }
        for (Point p : noAnimals) {
            this.fields[p.x][p.y].setBackground(grassColor);
        }
    }


    private JPanel createField() {
        JPanel field = new JPanel();
        field.setBorder(new LineBorder(Color.white, 1));
        field.setBackground(Color.green);
        return field;
    }

}
