package dungeon.engine;

public class HealthPotion extends Tiles{

    /**
     * Initializes the position of the HealthPotion, its tile type and heal amount.
     *
     */
    public HealthPotion(int x, int y) {
        tileX = x;
        tileY = y;
        tileHeal = 4;
        tileType = 5;
    }
}
