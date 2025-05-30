package dungeon.engine;

import java.io.Serializable;

public class GameState implements Serializable {
    private int steps;
    private int score;
    private int level;
    private int difficulty;

    /**
     * Initializes the steps, score and level.
     *
     */
    public GameState(int x) {
        steps = x;
        score = 0;
        level = 1;
    }

    /**
     * Sets the score for the current game.
     *
     */
    public void setScore(int x) {
        score = score + x;
    }

    /**
     * The current game score.
     *
     * @return the current game score, int.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the steps for the current game.
     *
     */
    public void setSteps(int x) {
        steps = steps - x;
    }

    /**
     * The current game steps.
     *
     * @return the current game steps, int.
     */
    public int getSteps() {
        return steps;
    }

    /**
     * The current game level.
     *
     * @return the game level, int.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level for the current game.
     *
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * The current game difficulty.
     *
     * @return the game difficulty, int.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty for the current game.
     *
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
