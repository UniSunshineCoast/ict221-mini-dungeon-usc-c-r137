import dungeon.engine.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryTest {
    @Test
    public void testTileX() {
        Entry e = new Entry(0, 0);
        assertEquals(0, e.getTileX());
    }

    @Test
    public void testTileY() {
        Entry e = new Entry(0, 3);
        assertEquals(3, e.getTileY());
    }

    @Test
    public void testTileType() {
        Entry e = new Entry(0, 0);
        assertEquals(7, e.getTileType());
    }
}
