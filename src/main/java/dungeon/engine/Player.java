package dungeon.engine;

import java.io.Serializable;

public class Player implements HealthInterface, Serializable {
    private int playerLocationX;
    private int playerLocationY;
    private final int playerSize;
    private int playerHealth;
    // Player constructor to initialize objects default data structures
    public Player(int x) {
        playerLocationX = 0;
        playerLocationY = 0;
        playerSize = x - 1;
        playerHealth = getMaxHealth();
    }

    public boolean checkPlayerMoveY(int y) {
        return this.playerLocationY + y >= 0 && this.playerLocationY + y <= this.playerSize;
    }

    public boolean checkPlayerMoveX(int x) {
        return this.playerLocationX + x >= 0 && this.playerLocationX + x <= this.playerSize;
    }

    public void setPlayerLocationY(int y) {
        this.playerLocationY = this.playerLocationY + y;
    }

    public void setPlayerLocationX(int x) {
        this.playerLocationX = this.playerLocationX + x;
    }

    public int getPlayerLocationY() {
        return this.playerLocationY;
    }

    public int getPlayerLocationX() {
        return this.playerLocationX;
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
    }

    @Override
    public boolean isDead() {
        return getHealth() <= 0;
    }

    @Override
    public void healHealth(int x) {
        if (this.playerHealth + x > 10) {
            this.playerHealth = getMaxHealth();
        } else {
            this.playerHealth = getHealth() + x;
        }
    }
}
