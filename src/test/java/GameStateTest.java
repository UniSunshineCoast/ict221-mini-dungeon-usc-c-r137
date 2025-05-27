import dungeon.engine.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    @Test
    public void testScore() {
        GameState gs = new GameState(100);
        assertEquals(0, gs.getScore());
        gs.setScore(3);
        assertEquals(3, gs.getScore());
        gs.setScore(1);
        assertEquals(4, gs.getScore());
        gs.setScore(1000);
        assertEquals(1004, gs.getScore());
    }

    @Test
    public void testSteps() {
        GameState gs = new GameState(100);
        assertEquals(100, gs.getSteps());
        gs.setSteps(4);
        assertEquals(96, gs.getSteps());
        gs.setSteps(10);
        assertEquals(86, gs.getSteps());
        gs.setSteps(100);
        assertEquals(-14, gs.getSteps());
    }

    @Test
    public void testLevel() {
        GameState gs = new GameState(100);
        assertEquals(1, gs.getLevel());
        gs.setLevel(1);
        assertEquals(1, gs.getLevel());
        gs.setLevel(100);
        assertEquals(100, gs.getLevel());
        gs.setLevel(1000);
        assertEquals(1000, gs.getLevel());
    }

    @Test
    public void testDifficulty() {
        GameState gs = new GameState(100);
        gs.setDifficulty(3);
        assertEquals(3, gs.getDifficulty());
        gs.setDifficulty(8);
        assertEquals(8, gs.getDifficulty());
        gs.setDifficulty(100);
        assertEquals(100, gs.getDifficulty());
    }
}
