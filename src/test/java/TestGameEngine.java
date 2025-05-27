import dungeon.engine.GameEngine;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameEngine {
    @Test
    void testGetSize() throws FileNotFoundException {
        GameEngine ge = new GameEngine(10, 3, 0, 0);

        assertEquals(10, ge.getSize());

    }
}
