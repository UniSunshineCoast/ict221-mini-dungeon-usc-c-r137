package dungeon.engine;

public class MutantMelee extends Tiles {

    /**
     * Initializes the position of the MutantMelee, its tile type, damage and score.
     *
     */
    public MutantMelee(int x, int y) {
        tileX = x;
        tileY = y;
        tileType = 1;
        tileDamage = 2;
        tileScore = 2;
    }
}
