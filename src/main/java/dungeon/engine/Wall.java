package dungeon.engine;

public class Wall extends Tiles {

    /**
     * Initializes the position of the Wall and its tile type.
     *
     */
    public Wall(int x, int y) {
        tileX = x;
        tileY = y;
        tileType = 0;
    }
}
