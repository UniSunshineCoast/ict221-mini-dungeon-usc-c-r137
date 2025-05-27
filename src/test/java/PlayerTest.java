import dungeon.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerX() {
        Player p = new Player(10);
        p.setPlayerLocationX(1);
        assertEquals(1, p.getPlayerLocationX());
        p.setPlayerLocationX(2);
        assertEquals(3,p.getPlayerLocationX());
        p.setPlayerLocationX(100);
        assertEquals(103, p.getPlayerLocationX());
    }

    @Test
    public void testPlayerY() {
        Player p = new Player(10);
        p.setPlayerLocationY(1);
        assertEquals(1, p.getPlayerLocationY());
        p.setPlayerLocationY(2);
        assertEquals(3, p.getPlayerLocationY());
        p.setPlayerLocationY(100);
        assertEquals(103, p.getPlayerLocationY());
    }

    @Test
    public void testCheckPlayerX() {
        Player p = new Player(10);
        assertTrue(p.checkPlayerMoveX(1));
        assertFalse(p.checkPlayerMoveX(-1));
        assertFalse(p.checkPlayerMoveX(10));
        assertTrue(p.checkPlayerMoveX(9));
    }

    @Test
    public void testCheckPlayerY() {
        Player p = new Player(10);
        assertTrue(p.checkPlayerMoveY(1));
        assertFalse(p.checkPlayerMoveY(-1));
        assertFalse(p.checkPlayerMoveY(10));
        assertTrue(p.checkPlayerMoveY(9));
    }

    @Test
    public void testHealth() {
        Player p = new Player(10);
        assertEquals(10, p.getHealth());
        assertEquals(10, p.getMaxHealth());
        p.damageHealth(3);
        assertEquals(7, p.getHealth());
        assertEquals(10, p.getMaxHealth());
        p.healHealth(3);
        assertEquals(10, p.getHealth());
        assertEquals(10, p.getMaxHealth());
        p.healHealth(1);
        assertEquals(10, p.getHealth());
        assertEquals(10, p.getMaxHealth());
        assertFalse(p.isDead());
        p.damageHealth(10);
        assertTrue(p.isDead());
        p.healHealth(1);
        assertFalse(p.isDead());
    }
}
