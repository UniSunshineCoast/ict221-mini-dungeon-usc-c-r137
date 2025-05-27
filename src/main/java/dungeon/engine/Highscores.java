package dungeon.engine;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Highscores {
    String[][] highscoresArray;

    public Highscores() throws FileNotFoundException {
        highscoresArray = new String[5][3];
    }

    public void checkHighscore(int i) {
        LocalDate date = LocalDate.now();
        for (int j = 0; j < highscoresArray.length; j++) {
            if (highscoresArray[j][1] == null) {
                highscoresArray[j] = new String[]{String.valueOf(j + 1), String.valueOf(i), String.valueOf(date)};
                break;
            }else if (i > Integer.parseInt(highscoresArray[j][1])) {
                for (int p = highscoresArray.length - 1; p > j; p--){
                    highscoresArray[p] = highscoresArray[p-1];
                }
                highscoresArray[j] = new String[]{String.valueOf(j + 1), String.valueOf(i), String.valueOf(date)};
                break;
            }
        }
        for (int j = 0; j < highscoresArray.length; j++) {
            highscoresArray[j][0] = String.valueOf(j +1);
        }
    }

    public void loadHighscores() throws FileNotFoundException {
        File file = new File("highscores.txt");
        Scanner fileReader = new Scanner(file);
        String regex = ",";
        while (fileReader.hasNextLine()) {
            for (String[] strings : highscoresArray) {
                String data = fileReader.nextLine().replaceAll("\\s+", "");
                String[] splitData = data.split(regex);
                if (!Objects.equals(splitData[0], "null")) {
                    System.arraycopy(splitData, 0, strings, 0, splitData.length);
                }
            }
        }
        fileReader.close();
    }

    public void saveHighscores() throws IOException {
        Writer fileWriter = new FileWriter("highscores.txt");
        for (String[] strings : highscoresArray) {
            if (strings != null) {
                String writeable = Arrays.toString(strings) + "\n";
                fileWriter.write(writeable.replaceAll("\\[", "").replaceAll("]", ""));
            }
        }
        fileWriter.close();
    }

    public Object[] getHighscores() {
        return highscoresArray;
    }
}
