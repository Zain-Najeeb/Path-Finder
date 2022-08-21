import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class MazeGenerator {
    public static HashMap<Point2D, Node> movesvalid = new HashMap<>();
    public boolean valid = false;
    public boolean half = true;
    public int counter = 0;
    public void generate(Point2D start) {
        stack stack = new stack();

        stack.push(start);
        movesvalid.put(start, new Node((int)start.getX(), (int) start.getY()) );
        movesvalid.get(start).parent = null ;
        movesvalid.get(start).checked = true ;
        while (!stack.isEmpty()) {
           valid = false;
            determineneigbor(stack.peek(), stack);
            if (valid) {
                addwall(stack);
    //            System.out.println(stack.peek());


                movesvalid.get(movesvalid.get(stack.peek()).parent).checked = true;
            } else {
                movesvalid.get(stack.peek()).checked = true;

                stack.pop();


            }
        }
        determineend();
        Maze.instance.fill(255,0,0);
        Maze.instance.rect( (int)Maze.end.getX(), (int)Maze.end.getY(), 25,25 );

    }

    public void addwall(stack stack) {
        int y = 25;
        int x = 0;
        if (stack.peek().getY() != movesvalid.get(stack.peek()).parent.getY() ) {
            x = y;
            y =0;
        }
        Point2D n1 = new Point2D.Double(movesvalid.get(stack.peek()).parent.getX() + x , movesvalid.get(stack.peek()).parent.getY()  +y );
        Point2D n2 = new Point2D.Double(movesvalid.get(stack.peek()).parent.getX() + x*-1 ,movesvalid.get(stack.peek()).parent.getY() + y*-1 );


        Maze.instance.fill(0);


        if (!Maze.wallsPositions.contains(n1) && !movesvalid.containsKey(n1) ) {
            Maze.valid.remove(n1);
            Maze.wallsPositions.add(n1);
            Maze.instance.fill(0,0,0);
            Maze.instance.rect((int)n1.getX(), (int)n1.getY(), 25, 25);

        }
       if (counter %2 == 0 || counter %5 == 0 ) {
           if (!Maze.wallsPositions.contains(n2) && !movesvalid.containsKey(n2)) {
               Maze.wallsPositions.add(n2);
               Maze.valid.remove(n2);
               Maze.instance.fill(0, 0, 0);
               Maze.instance.rect((int) n2.getX(), (int) n2.getY(), 25, 25);
           }
       }
        counter++;



    }
    public void determineneigbor(Point2D node, stack stack) {
        Point2D n4 = new Point2D.Double(node.getX() ,node.getY() - 25);
        Point2D n1 = new Point2D.Double(node.getX() -25 ,node.getY());
        Point2D n2 = new Point2D.Double(node.getX() + 25 ,node.getY());
        Point2D n3 = new Point2D.Double(node.getX() ,node.getY() + 25);
        ArrayList<Point2D> possilbe = new ArrayList<>();
        if (Maze.valid.containsKey(n1) &&!Maze.wallsPositions.contains(n1)) {
            if (!movesvalid.containsKey(n1)) {
                possilbe.add(n1);
            } else {
                if (!movesvalid.get(n1).checked  ) {
                    possilbe.add(n1);
                }
            }
        }
        if (Maze.valid.containsKey(n2) &&!Maze.wallsPositions.contains(n2 )) {
            if (!movesvalid.containsKey(n2)) {
                possilbe.add(n2);
            } else {
                if (!movesvalid.get(n2).checked) {
                    possilbe.add(n2);
                }
            }
        }
        if (Maze.valid.containsKey(n3) &&!Maze.wallsPositions.contains(n3)) {
            if (!movesvalid.containsKey(n3)) {

                possilbe.add(n3);
            } else {
                if (!movesvalid.get(n3).checked) {
                    possilbe.add(n3);
                }
            }
        }
        if (Maze.valid.containsKey(n4) &&!Maze.wallsPositions.contains(n4 )) {
            if (!movesvalid.containsKey(n4)) {
                possilbe.add(n4);
            } else {
                if (!movesvalid.get(n4).checked) {
                    possilbe.add(n4);
                }
            }
        }
        if (possilbe.size() != 0) {
            int max = possilbe.size()-1;
            int num =  (int)Math.floor(Math.random()*(max+1));
     //       System.out.println(possilbe.get(num));
            stack.push(possilbe.get(num));
            Maze.end = stack.peek();
            valid = true;
            if (!movesvalid.containsKey(possilbe.get(num))) {
                movesvalid.put(possilbe.get(num), new Node((int) possilbe.get(num).getX(), (int) possilbe.get(num).getY()));
                movesvalid.get(possilbe.get(num)).parent = node;
            }
        }


    }
    public void determineend() {
        for (int i =32; i > 0; i--) {
            if (movesvalid.containsKey(new Point2D.Double(i*25, 775))) {
                Maze.end = new Point2D.Double(i*25, 775);
                break;
            }
        }


    }


}
