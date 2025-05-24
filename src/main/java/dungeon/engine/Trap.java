package dungeon.engine;

public class Trap extends Enemy{
    private final int trapLocationX;
    private final int trapLocationY;

    public Trap(int x, int y) {
        trapLocationX = x;
        trapLocationY = y;
    }

    public int getTrapLocationY() {
        return trapLocationY;
    }

    public int getTrapLocationX() {
        return trapLocationX;
    }

}
