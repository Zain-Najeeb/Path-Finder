import java.awt.geom.Point2D;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class algorithm {
    public static void shortest_path(Point2D src, Point2D end) {
        Maze.valid.get(src).distance = 0 ;

        List<Point2D> min_pq = new ArrayList<>();

        min_pq.add(src);
        while (!min_pq.isEmpty()) {
            Node node = Maze.valid.get(min_pq.get(0));
            node.checked = true;
            if (Maze.valid.get(min_pq.get(0)) ==Maze.valid.get(end) ) break;
            min_pq.remove(0);
            ArrayList<Point2D> neighbors = neighbours(new Point2D.Double(node.x , node.y));
            for (Point2D neighbor : neighbors) {
                int dist = 1;
                if (dist + node.distance < Maze.valid.get(neighbor).distance) {
                    Maze.valid.get(neighbor).distance = dist + node.distance;
                    Maze.valid.get(neighbor).parent = new Point2D.Double(node.x, node.y);
                    min_pq.add(new Point2D.Double(Maze.valid.get(neighbor).x, Maze.valid.get(neighbor).y ));
                //    Maze.instance.fill(50,60,50);

                }


            }
          min_pq= sorter(min_pq);

        }

    }
    public static List<Point2D> sorter(List<Point2D> pq) {
        List<Integer> sort = new ArrayList<>();
        for (Point2D index : pq) {
            sort.add(Maze.valid.get(index).distance);
        }
        Collections.sort(sort);
        List<Point2D> temp = new ArrayList<>();

        for (int i = 0; i < pq.size(); i++) {
            for (Point2D index : pq ) {
                if (Maze.valid.get(index).distance == sort.get(i) && !temp.contains(index)) {
                    temp.add(index);

                    break;
                }
            }
        }
        return temp;
    }
    public static ArrayList<Point2D> neighbours(Point2D node) {
        ArrayList<Point2D> nodes = new ArrayList<>();
        Point2D n4 = new Point2D.Double(node.getX() ,node.getY() - 25);
        Point2D n1 = new Point2D.Double(node.getX() -25 ,node.getY());
        Point2D n2 = new Point2D.Double(node.getX() + 25 ,node.getY());
        Point2D n3 = new Point2D.Double(node.getX() ,node.getY() + 25);
        if (Maze.valid.containsKey(n1)) {
           if (!Maze.valid.get(n1).checked) {
               nodes.add(n1);
           }
       }  if  (Maze.valid.containsKey(n2)) {
           if (!Maze.valid.get(n2).checked) {
               nodes.add(n2);
           }
       } if  (Maze.valid.containsKey(n3)) {
           if (!Maze.valid.get(n3).checked) {
               nodes.add(n3);
           }
       } if  (Maze.valid.containsKey(n4)) {
           if (!Maze.valid.get(n4).checked) {
               nodes.add(n4);
           }
       }

        return nodes;
    }
}


