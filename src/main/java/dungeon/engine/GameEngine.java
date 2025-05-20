package dungeon.engine;

import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GameEngine {

    /**
     * An example board to store the current game state.
     *
     * Note: depending on your game, you might want to change this from 'int' to String or something?
     */
    private Cell[][] map;
    private static Player player;

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new Cell[size][size];
        player = new Player();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                Text text = new Text(i + "," + j);
                cell.getChildren().add(text);
                map[i][j] = cell;
            }
        }

        map[0][0].setStyle("-fx-background-color: #7baaa4");
        map[size-1][size-1].setStyle("-fx-background-color: #7baaa4");
    }

    public static void playerMoveUp() {
        player.setPlayerLocationY(1);
    }

    public static void playerMoveDown() {
        player.setPlayerLocationY(-1);
    }

    public static void playerMoveRight() {
        player.setPlayerLocationX(1);
    }

    public static void playerMoveLeft() {
        player.setPlayerLocationX(-1);
    }

    /**
     * The size of the current game.
     *
     * @return this is both the width and the height.
     */
    public int getSize() {
        return map.length;
    }

    /**
     * The map of the current game.
     *
     * @return the map, which is a 2d array.
     */
    public Cell[][] getMap() {
        return map;
    }

    /**
     * Plays a text-based game
     */
    public static void main(String[] args) throws IOException {
        GameEngine engine = new GameEngine(10);
        System.out.printf("The size of map is %d * %d\n", engine.getSize(), engine.getSize());

        String userInput;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("To move enter 'left', 'right', 'up', 'down' and 'x' to exit");
        while(true) {
            System.out.println("Enter your move");
            userInput = r.readLine();
            if (userInput.equalsIgnoreCase("left")) {
                playerMoveLeft();
                System.out.printf("You have moved to %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
            } else if (userInput.equalsIgnoreCase("right")) {
                playerMoveRight();
                System.out.printf("You have moved to %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
            } else if (userInput.equalsIgnoreCase("up")) {
                playerMoveUp();
                System.out.printf("You have moved to %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
            } else if (userInput.equalsIgnoreCase("down")) {
                playerMoveDown();
                System.out.printf("You have moved to %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
            } else if (userInput.equalsIgnoreCase("x")) {
                break;
            }
        }
    }
}
