package dungeon.engine;

import java.io.Serializable;

public class Tiles implements Serializable {
    protected int tileDamage;
    protected int tileX;
    protected int tileY;
    protected int tileType;
    protected int tileScore;
    protected int tileHeal;

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public int getTileType() {
        return tileType;
    }

    public int getTileScore() {
        return tileScore;
    }

    public int getTileHeal() {
        return tileHeal;
    }

    public int getTileDamage() {
        return tileDamage;
    }
}
