package dungeon.engine;

import java.io.Serializable;

public class Tiles implements Serializable {
    protected int tileDamage;
    protected int tileX;
    protected int tileY;
    protected int tileType;
    protected int tileScore;
    protected int tileHeal;

    /**
     * Tiles current x position.
     *
     * @return tiles x position, int.
     */
    public int getTileX() {
        return tileX;
    }

    /**
     * Tiles current y position.
     *
     * @return tiles y position, int.
     */
    public int getTileY() {
        return tileY;
    }

    /**
     * Tiles current type.
     *
     * @return tiles type, int.
     */
    public int getTileType() {
        return tileType;
    }

    /**
     * Tiles current score.
     *
     * @return tiles score, int.
     */
    public int getTileScore() {
        return tileScore;
    }

    /**
     * Tiles current heal amount.
     *
     * @return tiles heal amount, int.
     */
    public int getTileHeal() {
        return tileHeal;
    }

    /**
     * Tiles current damage amount.
     *
     * @return tiles damage amount, int.
     */
    public int getTileDamage() {
        return tileDamage;
    }
}
