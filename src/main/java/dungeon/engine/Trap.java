package dungeon.engine;

public class Trap extends Tiles {
    public Trap(int x, int y) {
        tileX = x;
        tileY = y;
        tileType = 3;
        tileDamage = 2;
    }
}
