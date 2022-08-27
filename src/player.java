import java.awt.geom.Point2D;

public class player {
    public float x = 12.5f;
    public float y =12.5f;
    public static int score = 0;


    public void move(char direction) throws Exception {
        if (direction == 'w' || direction == 'a'  ||direction == 's' ||direction == 'd' ) {
          if (gameView.created) {
                int movex  = 25;
                int movey = 0;
                if (direction == 'w') {
                    movex =0;
                    movey = -25;
                } else if (direction == 'a') {
                    movex = -25;
                } else if (direction == 's') {
                    movex = 0;
                    movey = 25;
                }


              Point2D n4 = new Point2D.Double( (Maze.player.x + movex) -12.5 ,Maze.player.y + movey -12.5);
                if (Maze.valid.containsKey(n4)) {
                    Maze.instance.fill(255, 0 ,0);
                    Maze.instance.rect(Maze.player.x - 12.5f, Maze.player.y - 12.5f, 25, 25);
                    Maze.player.x += movex;
                    Maze.player.y += movey;
                  score(false, n4);
                    if (n4.getX() == Maze.end.getX() && n4.getY() == Maze.end.getY()) {
                        score(true, n4);
                       Maze.maze.view.actions(900, 200);

                    }
                }
          }
        }
    }

    public void score (boolean end, Point2D node) {


        if (!Maze.playervalid.get(node).checked) {
            if (gameView.fastest.contains(node)) {
                score += 1;
            } else {
                score--;
            }
        }

        if (!end) {
            Maze.playervalid.get(node).checked = true;
            Maze.score = score;
            gameView.score();
        } else{

             score =0 ;

        }
    }

}
