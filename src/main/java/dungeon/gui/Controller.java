package dungeon.gui;

import dungeon.engine.Cell;
import dungeon.engine.GameEngine;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;

public class Controller {
    @FXML
    private GridPane gridPane;

    GameEngine engine;

    @FXML
    public void initialize() throws FileNotFoundException {
        engine = new GameEngine(10, 3, 0, 0);

        updateGui();
    }

    private void updateGui() {
        //Clear old GUI grid pane
        gridPane.getChildren().clear();

        //Loop through map board and add each cell into grid pane
        for(int i = 0; i < engine.getSize(); i++) {
            for (int j = 0; j < engine.getSize(); j++) {
                Cell cell = engine.getMap()[i][j];
                gridPane.add(cell, j, i);
            }
        }
        gridPane.setGridLinesVisible(true);
    }

}
