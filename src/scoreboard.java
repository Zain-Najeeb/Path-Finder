import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class scoreboard extends menus {

    public void view() {
        Maze.instance.textSize(30);
        Maze.instance.fill(255,255,255);
        for (int i = 0; i <5; i++) {
            Maze.instance.rect(450, 125 + i*30, 200,30);
            Maze.instance.rect(650, 125 + i*30, 100,30);
        }
        Maze.instance.rect(0, 740, 300, 60);
        Maze.instance.fill(0);
        Maze.instance.text("BACK", 100, 780);
        Maze.instance.text("GLOBAL LEADERBOARD (TOP 5)" , 400, 50);
        Maze.instance.textSize(15);
        Maze.instance.text("Name", 500, 120);
        Maze.instance.text("Score", 675, 120);

        int counter =0 ;

        for (String key : Maze.getdata.scores.keySet()) {
            if (counter <5 ) {
                Maze.instance.text(key, 500, 150 + 30*counter);
                Maze.instance.text(Maze.getdata.scores.get(key), 675, 150 + 30*counter);
                counter++;
            } else break;

        }


    }

    public void actions(int x, int y) throws Exception {
        if (0  <= x && x <=300 && 740 <= y && y <= 800) {
            Maze.maze.view.next();
        }
    }


    public void next() {
        Maze.maze.reset();
        Maze.maze.grid();
        Maze.maze.view = new gameView();
        Maze.maze.view.view();
    }
    public String getMenu() {
        return "scoreboard";
    }


}
