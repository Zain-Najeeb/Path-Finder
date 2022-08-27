import java.util.*;

public class mainmenu extends menus {
    public static String name = "";
    public static String typing = "";

    public void view() {
        Maze.instance.fill(0);
        Maze.instance.textSize(15);
        Maze.instance.text("Click the next button or press the 'Enter' button to start! If you do not enter a username your HighScore wont be saved!", 150, 350);
        Maze.instance.text("Name must be less than 13 characters!", 450, 150);
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

    public void actions(int x, int y)throws Exception  {

        if (450 <= x && 750 >= x && y>=225 && y <= 300) {
            keyPressed('\n');

        }

    }
    public static void keyPressed(char key) throws Exception{

        if (key == '\n') {
            name =typing;
            name = name.toUpperCase();
            mainmenu.getDatabase();
            Maze.maze.view.next();
        } else {
            if (key != 65535 && key!=8 && typing.length() <= 12) {
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


    public static void getDatabase() throws Exception {
        String get = Maze.getdata.getHTML("https://zainnartech.com/requests/get.php");
        String result = get.replaceAll("\\s+", " ");
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(result.split(" ")));
        HashMap<String, Integer> temp = new HashMap<>();
        for (int i =1; i < arr.size(); ) {
            temp.put(arr.get(i-1),Integer.valueOf(arr.get(i)));
            i +=2;
        }
        Maze.getdata.scores=  Maze.sortscore(temp);

    }



    public void next() {
        if (Maze.getdata.scores.containsKey(name)) {
            Maze.highscore =Maze.getdata.scores.get(name);
            Maze.getdata.doesExist = true;
        }

        Maze.maze.reset();
        Maze.maze.grid();
        Maze.maze.view = new gameView();
        Maze.maze.view.view();
    }

    public String getMenu() {
        return "menu";
    }

}
