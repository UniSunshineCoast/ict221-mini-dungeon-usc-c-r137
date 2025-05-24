package dungeon.engine;

public class Gold {
    private final int score = 2;
    private final int goldLocationX;
    private final int goldLocationY;

    public Gold(int x, int y) {
        goldLocationX = x;
        goldLocationY = y;
    }

    public int getGoldLocationX() {
        return goldLocationX;
    }

    public int getGoldLocationY() {
        return goldLocationY;
    }

    public int getScore() {
        return score;
    }
}
