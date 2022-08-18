import java.awt.geom.Point2D;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Maze extends PApplet{
    boolean start = true;
    public static List<Point2D> wallsPositions = new ArrayList<>();
    public static Maze instance;

    public static HashMap<Point2D, Node> valid = new HashMap<>();
    public void settings() {
        if (instance == null) {

            instance = this;
        }
        size(800, 800);


    }
    public void draw() {
        if (start) {
            start = false;
            grid();
        }

    }
    public void mousePressed() {
        int x = mouseX;
        int y = mouseY;
        y = roundpos(y);
        x = roundpos(x);
        Point2D wall = new Point2D.Double(x,y);
        if (!wallsPositions.contains(addCord(x,y))) wall(wall);
    }

    public void keyPressed() {
        if (key == 'w') {
            algorithm.shortest_path(addCord(400, 600), addCord(325, 250), Maze.valid.get(new Point2D.Double(325, 250)));
        }

    }

    public int roundpos(int cord) {
        int temp = cord%25;
        cord = cord - temp;
        return cord;
    }

    public void wall(Point2D wall) {
        wallsPositions.add(wall);
        valid.remove(wall);
        fill(0);
        rect((int)wall.getX(),(int)wall.getY(),25,25);

    }

    public void grid() {
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                valid.put(addCord(j * 25, i * 25), new Node(j * 25, i * 25));
                valid.get(addCord(j * 25, i * 25)).distance = MAX_INT;
                fill(255,255,255);
                rect(j * 25, i * 25, 25, 25);


            }
        }
        fill(0, 255, 0);
        rect(400, 600, 25, 25);
        fill(255,0,0);
        rect(325, 250, 25, 25);

    }

    public Point2D addCord(int xcord, int ycord) {
        return new Point2D.Double(xcord, ycord);

    }
}
