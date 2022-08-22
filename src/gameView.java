import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class gameView extends menus{
    public static boolean created = false;

    public static List<Point2D> fastest= new ArrayList<>();


    public void view() {

        Maze.instance.fill(255,255,255);
        Maze.instance.rect(850, 60, 300, 60);
        Maze.instance.rect(850, 180, 300, 60);
        Maze.instance.rect(850, 180, 300, 60);
        Maze.instance.textSize(30);
        Maze.instance.fill(0);
        Maze.instance.text("Use WASD TO Move!", 870, 50);
        Maze.instance.text("Score", 950, 690);
        Maze.instance.text("Highscore", 930, 590);
        Maze.instance.textSize(40);
        Maze.instance.text("Generate!", 900, 110);
        Maze.instance.text("Solve!", 925, 230);
        score();
    }
    public void actions(int x,int y) {
        if (850 <= x && x < 1150) {

            if (50 <= y && y <= 110) {
                Maze.maze.clearing();
                Maze.maze.grid() ;
                Maze.score= 0;
                player.score = 0;
                Maze.mazeGenerator.generate();
                algorithm.shortest_path(Maze.maze.addCord(0, 0), Maze.end);
                created = true;
                viewshortest(false);
            }
            if (175<= y && y <= 230 && created) {
                viewshortest(true);
                created = false;

            }



        }
    }

    public static void circle(){
        Maze.instance.fill(255,233,0);
        Maze.instance.ellipse(Maze.player.x,Maze.player.y,12.5f,12.5f);
    }
    public static void score() {
        Maze.instance.fill(255,255,255);

        Maze.instance.rect(850, 700, 300, 60);
        Maze.instance.fill(0);
        Maze.instance.textSize(40);
        Maze.instance.text(Maze.score , 975, 745 );
    }

    public static void highscore() {
        Maze.instance.fill(255,255,255);

        Maze.instance.rect(850, 600, 300, 60);
        Maze.instance.fill(0);
        Maze.instance.textSize(40);
        Maze.instance.text(Maze.highscore , 975, 645 );

    }


    public String getMenu() {
        return "Main";
    }

    public void viewshortest(boolean colour) {
        Point2D src = new Point2D.Double(0,0);
        Node ends = Maze.valid.get(Maze.end);
        while (true) {

            if (colour) {
                Maze.instance.fill(0, 255, 0);
                Maze.instance.rect(ends.x, ends.y, 25, 25);
            } else {
                fastest.add(new Point2D.Double(ends.x, ends.y));
            }
            if (Maze.valid.get(ends.parent) == Maze.valid.get(src)) break;
            ends = Maze.valid.get(ends.parent);


        }
    }

}
