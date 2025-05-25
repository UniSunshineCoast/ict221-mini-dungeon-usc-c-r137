package dungeon.engine;

public class GameState {
    private int steps;
    private int score;
    private int level;
    private int difficulty;

    public GameState(int x) {
        steps = x;
        score = 0;
        level = 1;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
