package growingpopulations.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MapPanel extends JPanel {

    private JPanel[][] fields;
    private int width, height;

    public MapPanel() {
        super();
        this.width = 0;
        this.height = 0;
    }

    synchronized public void reinitialize(int width, int height) {
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

    public void drawAll(Point[] noAnimals, Point[] wolves, Point[] rabbits) {
        for (Point p : wolves) {
            this.fields[p.x][p.y].setBackground(Color.blue);
        }
        for (Point p : rabbits) {
            this.fields[p.x][p.y].setBackground(Color.red);
        }
        for (Point p : noAnimals) {
            this.fields[p.x][p.y].setBackground(Color.green);
        }
    }


    private JPanel createField() {
        JPanel field = new JPanel();
        field.setBorder(new LineBorder(Color.white, 1));
        field.setBackground(Color.green);
        return field;
    }

}
