package dungeon.gui;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;

public class CustomerOutputStream extends OutputStream {
    private final TextArea consoleTextArea;

    public CustomerOutputStream(TextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
    }

    @Override
    public void write(int b) throws IOException {
        consoleTextArea.appendText(String.valueOf((char)b));
    }
}
