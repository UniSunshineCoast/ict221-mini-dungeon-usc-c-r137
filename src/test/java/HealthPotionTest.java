import dungeon.engine.HealthPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthPotionTest {
    @Test
    public void testTileX() {
        HealthPotion h = new HealthPotion(0, 0);
        assertEquals(0, h.getTileX());
    }

    @Test
    public void testTileY() {
        HealthPotion h = new HealthPotion(0, 3);
        assertEquals(3, h.getTileY());
    }

    @Test
    public void testTileHeal() {
        HealthPotion h = new HealthPotion(0, 0);
        assertEquals(4, h.getTileHeal());
    }

    @Test
    public void testTileType() {
        HealthPotion h = new HealthPotion(0, 0);
        assertEquals(5, h.getTileType());
    }
}
