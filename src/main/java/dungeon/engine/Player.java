package dungeon.engine;

import java.util.ArrayList;
import java.util.Arrays;

public class Player implements HealthInterface {
    private int playerSteps;
    private int playerLocationX;
    private int playerLocationY;
    private ArrayList<String> playerTreasures = new ArrayList<String>();
    private final int playerSize;
    private int playerMaxHealth;
    private int playerHealth;
    // Player constructor to initialize objects default data structures
    public Player(int x) {
        playerLocationX = 0;
        playerLocationY = 0;
        playerSize = x - 1;
        playerSteps = 0;
        playerMaxHealth = getMaxHealth();
        playerHealth = getMaxHealth();
    }

    public boolean setPlayerLocationY(int y) {
        if (playerLocationY + y < 0 || playerLocationY + y > this.playerSize) {
            return false;
        } else {
            this.playerSteps++;
            this.playerLocationY = playerLocationY + y;
            return true;
        }
    }

    public boolean setPlayerLocationX(int x) {
        if (playerLocationX + x < 0 || playerLocationX + x > this.playerSize) {
            return false;
        } else {
            this.playerSteps++;
            this.playerLocationX = playerLocationX + x;
            return true;
        }
    }

    public int getPlayerLocationY() {
        return this.playerLocationY;
    }

    public int getPlayerLocationX() {
        return this.playerLocationX;
    }

    public int getPlayerSteps() {
        return this.playerSteps;
    }

    @Override
    public int getHealth() {
        return this.playerHealth;
    }

    @Override
    public int getMaxHealth() {
        return 10;
    }

    @Override
    public void damageHealth(int x) {
        this.playerHealth = getHealth() - x;
        isDead();
    }

    @Override
    public boolean isDead() {
        return getHealth() <= 0;
    }
}
