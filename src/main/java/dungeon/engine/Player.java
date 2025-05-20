package dungeon.engine;

public class Player {
    private int playerSteps;
    private int playerLocationX;
    private int playerLocationY;
    private int playerTreasures;
    // Player constructor to initialize objects default data structures
    public Player() {
        playerSteps = 0;
        playerLocationX = 0;
        playerLocationY = 0;
        playerTreasures = 0;
    }

    public void setPlayerLocationY(int y) {
        this.playerLocationY = playerLocationY + y;
    }

    public void setPlayerLocationX(int x) {
        this.playerLocationX = playerLocationX + x;
    }

    public int getPlayerLocationY() {
        return this.playerLocationY;
    }

    public int getPlayerLocationX() {
        return this.playerLocationX;
    }
}
