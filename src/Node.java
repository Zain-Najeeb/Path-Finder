import java.awt.geom.Point2D;

public class Node {
    public Point2D parent;
    public int distance;
    public int x;
    public int y;
    public boolean checked = false;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
