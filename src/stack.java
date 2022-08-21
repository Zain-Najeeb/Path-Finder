import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class stack {
    private ArrayList<Point2D> stack = new ArrayList<>();
    public void push (Point2D point) {
        stack.add(point);
    }

    public void pop () {

        if (stack.size() == 0) return;

        stack.remove(stack.size()-1);
    }

    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    public Point2D peek() {
        return stack.get(stack.size()-1);
    }
}
