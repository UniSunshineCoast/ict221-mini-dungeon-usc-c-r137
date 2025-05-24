package dungeon.engine;

import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Random;

public class GameEngine {

    /**
     * An example board to store the current game state.
     *
     * Note: depending on your game, you might want to change this from 'int' to String or something?
     */
    private static Cell[][] map;
    private static Player player;
    private static GameState gameState;
    private static MutantMelee[][] mutantMelee;
    private static MutantRange[][] mutantRange;
    private static Random rand = new Random();

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new Cell[size][size];
        mutantMelee = new MutantMelee[size][size];
        mutantRange = new MutantRange[size][size];
        player = new Player(size);
        gameState = new GameState(100);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                Text text = new Text(i + "," + j);
                cell.getChildren().add(text);
                map[i][j] = cell;
                if (j % 8 == 0 && j != 0) {
                    MutantMelee mutant = new MutantMelee(i , j);
                    mutantMelee[i][j] = mutant;
                }
                if (j % 6 == 0 && j != 0) {
                    MutantRange mutant = new MutantRange(i, j);
                    mutantRange[i][j] = mutant;
                }
            }
        }

        map[0][0].setStyle("-fx-background-color: #7baaa4");
        map[size-1][size-1].setStyle("-fx-background-color: #7baaa4");

        player.setPlayerLocationX(0);
        player.setPlayerLocationY(0);
    }

    public  static void checkMeleeAttack() {
        if(mutantMelee[player.getPlayerLocationY()][player.getPlayerLocationX()] != null) {
            player.damageHealth(mutantMelee[player.getPlayerLocationY()][player.getPlayerLocationX()].getEnemyDamage());
            System.out.printf("The player has killed a mutant and taken %d damage\n", mutantMelee[player.getPlayerLocationY()][player.getPlayerLocationX()].getEnemyDamage());
            mutantMelee[player.getPlayerLocationY()][player.getPlayerLocationX()] = null;
        }
    }

    public static void checkRangeAttack() {
        System.out.println("Checking Ranged Attack");
        System.out.println(player.getPlayerLocationX());
        if (player.getPlayerLocationY() != 8 || player.getPlayerLocationY() != 9) {
            if (mutantRange[player.getPlayerLocationY()+2][player.getPlayerLocationX()] != null) {
                if (rand.nextBoolean()) {player.damageHealth(mutantRange[player.getPlayerLocationY()+2][player.getPlayerLocationX()].getEnemyDamage());}
            }
        }

        if (player.getPlayerLocationY() != 0 || player.getPlayerLocationY() != 1) {
//            if (mutantRange[player.getPlayerLocationY()-2][player.getPlayerLocationX()] != null) {
//                if (rand.nextBoolean()) {player.damageHealth(mutantRange[player.getPlayerLocationY()-2][player.getPlayerLocationX()].getEnemyDamage());}
//            }
        }

//        if (player.getPlayerLocationX() != 8 || player.getPlayerLocationX() != 9) {
//            System.out.println("Pass");
//            if (mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()+2] != null) {
//                System.out.println("Attempting Damage");
//                if (rand.nextBoolean()) {player.damageHealth(mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()+2].getEnemyDamage());}
//            }
//        }

//        if (player.getPlayerLocationX() != 1 || player.getPlayerLocationX() != 0) {
//            if (mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()-2] != null) {
//                if (rand.nextBoolean()) {player.damageHealth(mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()-2].getEnemyDamage());}
//            }
//        }

        if (mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()] != null) {
            mutantRange[player.getPlayerLocationY()][player.getPlayerLocationX()] = null;
        }
    }

    public static void playerMove(boolean x) {
        checkMeleeAttack();
        checkRangeAttack();
        if (x) {
            System.out.printf("You have moved to %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
            System.out.printf("Total steps %d\n", player.getPlayerSteps());
            System.out.printf("Player Health: %d\n", player.getHealth());
            gameState.setSteps(-1);
        } else {
            System.out.printf("You were unable to move and are still at %d - %d\n", player.getPlayerLocationX(), player.getPlayerLocationY());
        }
    }

    public static void playerMoveUp() {
        playerMove(player.setPlayerLocationY(1));
    }

    public static void playerMoveDown() {
        playerMove(player.setPlayerLocationY(-1));
    }

    public static void playerMoveRight() {
        playerMove(player.setPlayerLocationX(1));
    }

    public static void playerMoveLeft() {
        playerMove(player.setPlayerLocationX(-1));
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
        System.out.println(mutantMelee[8][8]);
        while(true) {
            for(int i = map.length; i > 0; i--) {
                for(int j = 0; j < map[i-1].length; j++){
                    if(i-1 == player.getPlayerLocationY() && j == player.getPlayerLocationX()) {
                        System.out.print("P  ");
                    } else if(mutantMelee[i -1][j] != null) {
                        System.out.print("M  ");
                    } else if(mutantRange[i -1][j] != null) {
                        System.out.print("R  ");
                    } else {
                        System.out.printf("%d%d ",i-1,j);
                    }
                }
                System.out.print("\n");
            }
            System.out.println("Enter your move");
            userInput = r.readLine();
            if (userInput.equalsIgnoreCase("left")) {
                playerMoveLeft();
            } else if (userInput.equalsIgnoreCase("right")) {
                playerMoveRight();
            } else if (userInput.equalsIgnoreCase("up")) {
                playerMoveUp();
            } else if (userInput.equalsIgnoreCase("down")) {
                playerMoveDown();
            } else if (userInput.equalsIgnoreCase("x")) {
                break;
            }
        }
    }
}
