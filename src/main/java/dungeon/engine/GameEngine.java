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
    private static MutantMelee mutantMelee;
    private static MutantRange mutantRange;
    private static Trap trap;
    private static HealthPotion healthPotion;
    private static Gold gold;
    private static Wall wall;
    private static Ladder ladder;
    private static Maps gameMap;
    private static final Random rand = new Random();
    private static Tiles[][] tiles;

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size, int d) {
        map = new Cell[size][size];
        tiles = new Tiles[size][size];
        player = new Player(size);
        gameMap = new Maps();
        gameState = new GameState(100);
        int[][] playerMap = (int[][]) gameMap.getMapVaules();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                Text text = new Text(i + "," + j);
                cell.getChildren().add(text);
                map[i][j] = cell;
            }
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playerMap[i][j] == 1) {
                    Wall newWall = new Wall(i, j);
                    tiles[i][j] = newWall;
                }
            }
        }

        for (int p = 0; p < 1; p++) {
            boolean running = true;
            while(running) {
                int x = 5 + rand.nextInt(4);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    Ladder newLadder = new Ladder(x, y);
                    tiles[x][y] = newLadder;
                    running = false;
                }
            }
        }

        for (int p = 0; p < 3; p++) {
            boolean running = true;
            while(running) {
                int x = rand.nextInt(9);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    MutantMelee newMutant = new MutantMelee(x, y);
                    tiles[x][y] = newMutant;
                    running = false;
                }
            }
        }

        for (int p = 0; p < d; p++) {
            boolean running = true;
            while(running) {
                int x = rand.nextInt(9);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    MutantRange newMutant = new MutantRange(x, y);
                    tiles[x][y] = newMutant;
                    running = false;
                }
            }
        }

        for (int p = 0; p < 5; p++) {
            boolean running = true;
            while(running) {
                int x = rand.nextInt(9);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    Trap newTrap = new Trap(x, y);
                    tiles[x][y] = newTrap;
                    running = false;
                }
            }
        }

        for (int p = 0; p < 5; p++) {
            boolean running = true;
            while(running) {
                int x = rand.nextInt(9);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    Gold newGold = new Gold(x, y);
                    tiles[x][y] = newGold;
                    running = false;
                }
            }
        }

        for (int p = 0; p < 2; p++) {
            boolean running = true;
            while(running) {
                int x = rand.nextInt(9);
                int y = rand.nextInt(9);
                if (tiles[x][y] == null) {
                    HealthPotion newHealthPotion = new HealthPotion(x, y);
                    tiles[x][y] = newHealthPotion;
                    running = false;
                }
            }
        }

        map[0][0].setStyle("-fx-background-color: #7baaa4");
        map[size-1][size-1].setStyle("-fx-background-color: #7baaa4");

        player.setPlayerLocationX(0);
        player.setPlayerLocationY(0);
    }

    public static void checkGold() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int score;
        if (tiles[playerY][playerX] != null) {
            if (tiles[playerY][playerX].getTileType() == 4) {
                score = tiles[playerY][playerX].getTileScore();
                gameState.setScore(score);
                System.out.printf("You have picked up some gold and got %d score\n", score);
                tiles[playerY][playerX] = null;
            }
        }
    }

    public static void checkHealthPotion() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int heal;
        if (tiles[playerY][playerX] != null) {
            if (tiles[playerY][playerX].getTileType() == 5) {
                heal = tiles[playerY][playerX].getTileHeal();
                player.healHealth(heal);
                System.out.printf("You have heal for %d health from a health potion\n", heal);
                tiles[playerY][playerX] = null;
            }
        }
    }

    public  static void checkMeleeAttack() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        int score;
        if(tiles[playerY][playerX] != null) {
            if (tiles[playerY][playerX].getTileType() == 1) {
                damage = tiles[playerY][playerX].getTileDamage();
                score = tiles[playerY][playerX].getTileScore();
                player.damageHealth(damage);
                gameState.setScore(score);
                System.out.printf("You have killed a mutant and taken %d damage and gained %d sore.\n", damage, score);
                tiles[playerY][playerX] = null;
            }
        }
    }

    public static void checkTrap() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        if (tiles[playerY][playerX] != null) {
            if (tiles[playerY][playerX].getTileType() == 3) {
            damage = tiles[playerY][playerX].getTileDamage();
            player.damageHealth(damage);
            System.out.printf("You have step on a trap and have taken %d damage.\n", damage);
            tiles[playerY][playerX] = null;
            }
        }
    }

    public static void checkRangeAttack() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        int damage;
        int score;
        if (playerY < 8) {
            if (tiles[playerY + 2][playerX] != null) {
                if (tiles[playerY + 2][playerX].getTileType() == 2) {
                    damage = tiles[playerY + 2][playerX].getTileDamage();
                    if (rand.nextBoolean()) {
                        player.damageHealth(damage);
                        System.out.printf("You been shoot by a ranged mutant and have taken %d damage.\n", damage);
                    }
                }
            }
        }

        if (playerY > 1) {
            if (tiles[playerY - 2][playerX] != null) {
                if (tiles[playerY -2][playerX].getTileType() == 2) {
                    damage = tiles[playerY - 2][playerX].getTileDamage();
                    if (rand.nextBoolean()) {
                        player.damageHealth(damage);
                        System.out.printf("You been shoot by a ranged mutant and have taken %d damage.\n", damage);
                    }
                }
            }
        }

        if (playerX < 8) {
            if (tiles[playerY][playerX + 2] != null) {
                if (tiles[playerY][playerX + 2].getTileType() == 2) {
                    damage = tiles[playerY][playerX + 2].getTileType();
                    if (rand.nextBoolean()) {
                        player.damageHealth(damage);
                        System.out.printf("You been shoot by a ranged mutant and have taken %d damage.\n", damage);
                    }
                }
            }
        }

        if (playerX > 1) {
            if (tiles[playerY][playerX - 2] != null) {
                if (tiles[playerY][playerX - 2].getTileType() == 2) {
                    damage = tiles[playerY][playerX - 2].getTileDamage();
                    if (rand.nextBoolean()) {
                        player.damageHealth(damage);
                        System.out.printf("You been shoot by a ranged mutant and have taken %d damage.\n", damage);
                    }
                }
            }
        }

        if (tiles[playerY][playerX] != null) {
            if (tiles[playerY][playerX].getTileType() == 2) {
                score = tiles[playerY][playerX].getTileScore();
                gameState.setScore(score);
                System.out.printf("You have killed a ranged mutant and got %d score\n", score);
                tiles[playerY][playerX] = null;
            }
        }
    }

    public static void checkPlayerConditioners() {
        if (player.isDead()) {

        } else if (gameState.getSteps() <= 0) {

        }
    }

    public static void playerMove(boolean x) {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        checkMeleeAttack();
        checkRangeAttack();
        checkHealthPotion();
        checkTrap();
        checkGold();
        checkPlayerConditioners();
        if (x) {
            System.out.printf("You have moved to %d - %d\n", playerX, playerY);
            System.out.printf("Your score is: %d\n", gameState.getScore());
            System.out.printf("Player Steps Taken: %d\n", player.getPlayerSteps());
            System.out.printf("Player Health: %d\n", player.getHealth());
            gameState.setSteps(-1);
        } else {
            System.out.printf("You were unable to move and are still at %d - %d\n", playerX, playerY);
        }
    }

    public static void playerMoveUp() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        if (player.checkPlayerMoveY(1)) {
            if (tiles[playerY + 1][playerX] == null) {
                player.setPlayerLocationY(1);
                playerMove(true);
            } else if (tiles[playerY +1][playerX].getTileType() == 0) {
                playerMove(false);
            } else {
                player.setPlayerLocationY(1);
                playerMove(true);
            }
        } else {
            playerMove(false);
        }
    }

    public static void playerMoveDown() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        if (player.checkPlayerMoveY(-1)) {
            if (tiles[playerY - 1][playerX] == null) {
                player.setPlayerLocationY(-1);
                playerMove(true);
            } else if (tiles[playerY - 1][playerX].getTileType() == 0) {
                playerMove(false);
            } else {
                player.setPlayerLocationY(-1);
                playerMove(true);
            }
        } else {
            playerMove(false);
        }
    }

    public static void playerMoveRight() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        if (player.checkPlayerMoveX(1)) {
            if (tiles[playerY][playerX + 1] == null) {
                player.setPlayerLocationX(1);
                playerMove(true);
            } else if (tiles[playerY][playerX + 1].getTileType() == 0) {
                playerMove(false);
            } else {
                player.setPlayerLocationX(1);
                playerMove(true);
            }
        } else {
            playerMove(false);
        }
    }

    public static void playerMoveLeft() {
        int playerY = player.getPlayerLocationY();
        int playerX = player.getPlayerLocationX();
        if (player.checkPlayerMoveX(-1)) {
            if (tiles[playerY][playerX - 1] == null) {
                player.setPlayerLocationX(-1);
                playerMove(true);
            } else if (tiles[playerY][playerX - 1].getTileType() == 0) {
                playerMove(false);
            } else {
                player.setPlayerLocationX(-1);
                playerMove(true);
            }
        } else {
            playerMove(false);
        }
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
        String userInput;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int d = 3;
        System.out.println("Enter your difficulty 1 - 10");
        userInput = r.readLine();
        if (userInput.matches("[0-10]+")) {
            d = Integer.parseInt(userInput);
        }
        GameEngine engine = new GameEngine(10, d);
        System.out.printf("The size of map is %d * %d\n", engine.getSize(), engine.getSize());

        System.out.println("To move enter 'left', 'right', 'up', 'down' and 'x' to exit");
        while(true) {
            for(int i = map.length; i > 0; i--) {
                for(int j = 0; j < map[i-1].length; j++){
                    if(i-1 == player.getPlayerLocationY() && j == player.getPlayerLocationX()) {
                        System.out.print("P  ");
                    } else if (tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 0) {
                        System.out.print("#  ");
                    } else if(tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 1) {
                        System.out.print("M  ");
                    } else if(tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 2) {
                        System.out.print("R  ");
                    } else if (tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 3) {
                        System.out.print("T  ");
                    }  else if (tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 5) {
                        System.out.print("H  ");
                    } else if (tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 4) {
                        System.out.print("G  ");
                    } else if (tiles[i - 1][j] != null && tiles[i - 1][j].getTileType() == 6) {
                        System.out.print("L  ");
                    } else if (i -1 ==0 && j == 0) {
                        System.out.print("E  ");
                    }else {
                        System.out.print(".  ");
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
