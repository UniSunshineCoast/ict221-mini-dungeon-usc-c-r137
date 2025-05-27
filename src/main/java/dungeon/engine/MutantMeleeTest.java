package dungeon.engine;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutantMeleeTest {
    @Test
    public void testTileX() {
        MutantMelee m = new MutantMelee(0, 0);
        assertEquals(0, m.getTileX());
    }

    @Test
    public void testTileY() {
        MutantMelee m = new MutantMelee(0, 3);
        assertEquals(3, m.getTileY());
    }

    @Test
    public void testTileType() {
        MutantMelee m = new MutantMelee(0, 0);
        assertEquals(1, m.getTileType());
    }
    @Test
    public void testTileDamage() {
        MutantMelee m = new MutantMelee(0, 0);
        assertEquals(2, m.getTileDamage());
    }
    @Test
    public void testTileScore() {
        MutantMelee m = new MutantMelee(0, 0);
        assertEquals(2, m.getTileScore());
    }
}
