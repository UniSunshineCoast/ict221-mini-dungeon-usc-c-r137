import dungeon.engine.Trap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapTest {
    @Test
    public void testTileX() {
        Trap r = new Trap(0, 0);
        assertEquals(0, r.getTileX());
    }

    @Test
    public void testTileY() {
        Trap r = new Trap(0, 3);
        assertEquals(3, r.getTileY());
    }

    @Test
    public void testTileType() {
        Trap r = new Trap(0, 0);
        assertEquals(3, r.getTileType());
    }

    @Test
    public void testTileDamage() {
        Trap r = new Trap(0,0);
        assertEquals(2, r.getTileDamage());
    }
}
