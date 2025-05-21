package dungeon.engine;

public class GameState {
    private int steps;
    private int score;

    public GameState(int x) {
        steps = x;
        score = 0;
    }

    public void setScore(int x) {
        score = score + x;
    }

    public int getScore() {
        return score;
    }

    public void setSteps(int x) {
        steps = steps + x;
    }

    public int getSteps() {
        return steps;
    }
}
