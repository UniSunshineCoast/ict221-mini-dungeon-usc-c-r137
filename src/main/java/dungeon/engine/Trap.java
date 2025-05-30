package dungeon.engine;

public class Trap extends Tiles {

    /**
     * Initializes the position of the Trap, its tile type and damage.
     *
     */
    public Trap(int x, int y) {
        tileX = x;
        tileY = y;
        tileType = 3;
        tileDamage = 2;
    }
}
