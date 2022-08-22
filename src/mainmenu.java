public class mainmenu extends menus {
    public static String name = "";
    public static String typing = "";
    public static boolean next = false;
    public void view() {
        Maze.instance.fill(0);
        Maze.instance.textSize(15);
        Maze.instance.text("Click the next button or press the 'Enter' button to start! If you do not enter a username your highscroes wont be saved! ", 150, 200);
        Maze.instance.fill(255,255,255);
        Maze.instance.rect(400, 60, 400, 60);
        Maze.instance.rect(450, 240, 300, 60);
        Maze.instance.fill(0);
        Maze.instance.textSize(30);
        Maze.instance.text("Next", 550, 280);
        Maze.instance.text("Enter your name!", 470, 50);
    }

    public static void text() {
        Maze.instance.fill(0);
        Maze.instance.textSize(20);
        Maze.instance.text(mainmenu.typing, 410, 100);
    }

    public void actions(int x, int y) {

        if (450 <= x && 750 >= x && y>=225 && y <= 300) {
            keyPressed('\n');
;
        }

    }
    public static void keyPressed(char key) {

        if (key == '\n') {
            name =typing;
            next = true;
            next();
        } else {
            if (key != 65535 && key!=8) {
                typing += key;
            }
            if (key ==8) {
                if (typing.length() !=0) {
                  typing=  typing.substring(0, typing.length()-1) ;
                    Maze.instance.fill(255,255,255);
                    Maze.instance.rect(400, 60, 400, 60);
                }
            }
        }
    }



    public static void next() {
        Maze.maze.reset();
        Maze.maze.grid();
        Maze.maze.view = new gameView();
        Maze.maze.view.view();
    }

    public String getMenu() {
        return "menu";
    }

}
