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
    private static Trap[][] trap;
    private static final Random rand = new Random();

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new Cell[size][size];
        mutantMelee = new MutantMelee[size][size];
        mutantRange = new MutantRange[size][size];
        trap = new Trap[size][size];
        player = new Player(size);
        gameState = new GameState(100);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                Text text = new Text(i + "," + j);
                cell.getChildren().add(text);
                map[i][j] = cell;
                if (j % 9 == 0 && j != 0) {
                    MutantMelee mutant = new MutantMelee(i , j);
                    mutantMelee[i][j] = mutant;
                }
                if (j % 8 == 0 && j != 0) {
                    MutantRange mutant = new MutantRange(i, j);
                    mutantRange[i][j] = mutant;
                }
                if (j % 7 == 0 && j !=0) {
                    Trap newTrap = new Trap(i, j);
                    trap[i][j] = newTrap;
                }
            }
        }

        map[0][0].setStyle("-fx-background-color: #7baaa4");
        map[size-1][size-1].setStyle("-fx-background-color: #7baaa4");

        player.setPlayerLocationX(0);
        player.setPlayerLocationY(0);
    }

    public  static void checkMeleeAttack() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        if(mutantMelee[playerY][playerX] != null) {
            damage = mutantMelee[playerY][playerX].getEnemyDamage();
            player.damageHealth(damage);
            System.out.printf("You have killed a mutant and taken %d damage.\n", damage);
            mutantMelee[playerY][playerX] = null;
        }
    }

    public static void checkTrap() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        if (trap[playerY][playerX] != null) {
            damage = trap[playerY][playerX].getEnemyDamage();
            player.damageHealth(damage);
            System.out.printf("You have step on a trap and have taken %d damage.\n", damage);
            trap[playerY][playerX] = null;
        }
    }

    public static void checkRangeAttack() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        if (playerY < 8) {
            if (mutantRange[playerY + 2][playerX] != null) {
                damage = mutantRange[playerY+2][playerX].getEnemyDamage();
                if (rand.nextBoolean()) {player.damageHealth(damage);}
            }
        }

        if (playerY > 1) {
            if (mutantRange[playerY - 2][playerX] != null) {
                damage = mutantRange[playerY - 2][playerX].getEnemyDamage();
                if (rand.nextBoolean()) {player.damageHealth(damage);}
            }
        }

        if (playerX < 8) {
            if (mutantRange[playerY][playerX + 2] != null) {
                damage = mutantRange[playerY][playerX + 2].getEnemyDamage();
                if (rand.nextBoolean()) {player.damageHealth(damage);}
            }
        }

        if (playerX > 1) {
            if (mutantRange[playerY][playerX - 2] != null) {
                damage = mutantRange[playerY][playerX - 2].getEnemyDamage();
                if (rand.nextBoolean()) {player.damageHealth(damage);}
            }
        }

        if (mutantRange[playerY][playerX] != null) {
            mutantRange[playerY][playerX] = null;
        }
    }

    public static void playerMove(boolean x) {
        checkMeleeAttack();
        checkRangeAttack();
        checkTrap();
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
                    } else if(mutantMelee[i - 1][j] != null) {
                        System.out.print("M  ");
                    } else if(mutantRange[i - 1][j] != null) {
                        System.out.print("R  ");
                    } else if (trap[i - 1][j] != null) {
                        System.out.print("T  ");
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
