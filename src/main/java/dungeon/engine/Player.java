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

    /**
     * Check player position and if it's valid.
     *
     * @return valid player position, boolean.
     */
    public boolean checkPlayerMoveY(int y) {
        return this.playerLocationY + y >= 0 && this.playerLocationY + y <= this.playerSize;
    }

    /**
     * Check player position and if it's valid.
     *
     * @return valid player position, boolean.
     */
    public boolean checkPlayerMoveX(int x) {
        return this.playerLocationX + x >= 0 && this.playerLocationX + x <= this.playerSize;
    }

    /**
     * Sets the players y position.
     *
     */
    public void setPlayerLocationY(int y) {
        this.playerLocationY = this.playerLocationY + y;
    }

    /**
     * Sets the players x position.
     *
     */
    public void setPlayerLocationX(int x) {
        this.playerLocationX = this.playerLocationX + x;
    }

    /**
     * Players current Y position.
     *
     * @return players y position, int.
     */
    public int getPlayerLocationY() {
        return this.playerLocationY;
    }

    /**
     * Players current X position.
     *
     * @return players x position, int.
     */
    public int getPlayerLocationX() {
        return this.playerLocationX;
    }

    /**
     * Player current health.
     *
     * @return players current health, int.
     */
    @Override
    public int getHealth() {
        return this.playerHealth;
    }

    /**
     * Player max health.
     *
     * @return players max health, int.
     */
    @Override
    public int getMaxHealth() {
        return 10;
    }

    /**
     * Damaged players current health.
     *
     */
    @Override
    public void damageHealth(int x) {
        this.playerHealth = getHealth() - x;
    }

    /**
     * Checks if players health is below or equal to zero.
     *
     * @return player still alive, boolean.
     */
    @Override
    public boolean isDead() {
        return getHealth() <= 0;
    }

    /**
     * Heals players current health.
     *
     */
    @Override
    public void healHealth(int x) {
        if (this.playerHealth + x > 10) {
            this.playerHealth = getMaxHealth();
        } else {
            this.playerHealth = getHealth() + x;
        }
    }
}
