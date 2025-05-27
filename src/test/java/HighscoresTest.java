import dungeon.engine.Highscores;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HighscoresTest {
    @Test
    public void testGetHighscore() throws FileNotFoundException {
        LocalDate date = LocalDate.now();
        Highscores hs = new Highscores();
        String[][] expectedArray = {
                {"1", "5", String.valueOf(date)},
                {"2", "4", String.valueOf(date)},
                {"3", "3", String.valueOf(date)},
                {"4", "2", String.valueOf(date)},
                {"5", "1", String.valueOf(date)}
        };
        hs.checkHighscore(1);
        hs.checkHighscore(2);
        hs.checkHighscore(3);
        hs.checkHighscore(4);
        hs.checkHighscore(5);
        String[][] hsArray = (String[][]) hs.getHighscores();
        for (int i = 0; i < expectedArray.length; i++) {
            assertArrayEquals(expectedArray[i], hsArray[i]);
        }
    }
}
