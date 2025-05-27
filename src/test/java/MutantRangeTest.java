import dungeon.engine.MutantRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutantRangeTest {
    @Test
    public void testTileX() {
        MutantRange r = new MutantRange(0, 0);
        assertEquals(0, r.getTileX());
    }

    @Test
    public void testTileY() {
        MutantRange r = new MutantRange(0, 3);
        assertEquals(3, r.getTileY());
    }

    @Test
    public void testTileType() {
        MutantRange r = new MutantRange(0, 0);
        assertEquals(2, r.getTileType());
    }
    @Test
    public void testTileDamage() {
        MutantRange r = new MutantRange(0, 0);
        assertEquals(2, r.getTileDamage());
    }
    @Test
    public void testTileScore() {
        MutantRange r = new MutantRange(0, 0);
        assertEquals(2, r.getTileScore());
    }
}
