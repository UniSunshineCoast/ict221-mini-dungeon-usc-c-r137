package dungeon.engine;

public class Gold extends Tiles {

    /**
     * Initializes the position of the Gold, its tile type and score.
     *
     */
    public Gold(int x, int y) {
        tileX = x;
        tileY = y;
        tileScore = 2;
        tileType = 4;
    }
}
