package dungeon.engine;

public class MutantRange extends Tiles {

    /**
     * Initializes the position of the MutantRange, its tile type, damage and score.
     *
     */
    public MutantRange(int x, int y) {
        tileX = x;
        tileY = y;
        tileDamage = 2;
        tileType = 2;
        tileScore = 2;
    }
}
