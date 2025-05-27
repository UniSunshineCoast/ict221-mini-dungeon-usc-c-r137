import dungeon.engine.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    public void testTileX() {
        Ladder l = new Ladder(0, 0);
        assertEquals(0, l.getTileX());
    }

    @Test
    public void testTileY() {
        Ladder l = new Ladder(0, 3);
        assertEquals(3, l.getTileY());
    }

    @Test
    public void testTileType() {
        Ladder l = new Ladder(0, 0);
        assertEquals(6, l.getTileType());
    }
}
