import dungeon.engine.Gold;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldTest {
    @Test
    public void testTileX() {
        Gold g = new Gold(0, 0);
        assertEquals(0, g.getTileX());
    }

    @Test
    public void testTileY() {
        Gold g = new Gold(0, 3);
        assertEquals(3, g.getTileY());
    }

    @Test
    public void testTileScore() {
        Gold g = new Gold(0, 0);
        assertEquals(2, g.getTileScore());
    }

    @Test
    public void testTileType() {
        Gold g = new Gold(0, 0);
        assertEquals(4, g.getTileType());
    }
}
