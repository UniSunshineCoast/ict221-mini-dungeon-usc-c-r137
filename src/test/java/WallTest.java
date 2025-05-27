import dungeon.engine.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    public void testTileX() {
        Wall w = new Wall(0, 0);
        assertEquals(0, w.getTileX());
    }

    @Test
    public void testTileY() {
        Wall w = new Wall(0, 3);
        assertEquals(3, w.getTileY());
    }

    @Test
    public void testTileType() {
        Wall w = new Wall(0, 0);
        assertEquals(0, w.getTileType());
    }
}
