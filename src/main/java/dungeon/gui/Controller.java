package dungeon.gui;

import dungeon.engine.Cell;
import dungeon.engine.GameEngine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Controller {
    @FXML
    private GridPane gridPane;
    @FXML
    private Button buttonUp;
    @FXML
    private Button buttonDown;
    @FXML
    private Button buttonRight;
    @FXML
    private Button buttonLeft;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonHelp;
    @FXML
    private Button buttonExit;
    @FXML
    private Label lblScore;
    @FXML
    private Label lblHealth;
    @FXML
    private Label lblSteps;
    @FXML
    private TextArea consoleTextArea;
    @FXML
    private Button buttonRun;
    @FXML
    private Button buttonLoad;

    GameEngine engine;

    @FXML
    public void initialize() throws FileNotFoundException {
        buttonUp.setDisable(true);
        buttonDown.setDisable(true);
        buttonRight.setDisable(true);
        buttonLeft.setDisable(true);
        buttonSave.setDisable(true);
        buttonHelp.setDisable(true);

        consoleTextArea.textProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                consoleTextArea.setScrollTop(Double.MAX_VALUE);
            }
        });

        buttonHelp.setOnAction(event -> {
            System.out.println("Use the directional buttons to move the player around the dungeon. Your goal is to " +
                    "get the highest score without dying within th dungeon. You can save the game at any time by" +
                    "pressing the save button. Good Luck!");
            updateGui();
        });

        buttonLoad.setOnAction(event -> {
            try {
                engine = new GameEngine(10, 3, 0, 0);
                GameEngine.loadGame(10);
                buttonUp.setDisable(false);
                buttonDown.setDisable(false);
                buttonRight.setDisable(false);
                buttonLeft.setDisable(false);
                buttonSave.setDisable(false);
                buttonHelp.setDisable(false);
                buttonLoad.setDisable(true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonRun.setOnAction(event -> {
            try {
                engine = new GameEngine(10, 3, 0, 0);
                buttonUp.setDisable(false);
                buttonDown.setDisable(false);
                buttonRight.setDisable(false);
                buttonLeft.setDisable(false);
                buttonSave.setDisable(false);
                buttonHelp.setDisable(false);
                buttonLoad.setDisable(true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonUp.setOnAction(event -> {
            try {
                GameEngine.playerMoveUp();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonDown.setOnAction(event -> {
            try {
                GameEngine.playerMoveDown();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonRight.setOnAction(event -> {
            try {
                GameEngine.playerMoveRight();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonLeft.setOnAction(event -> {
            try {
                GameEngine.playerMoveLeft();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateGui();
        });

        buttonSave.setOnAction(event -> {
            GameEngine.saveGame();
            updateGui();
        });

        buttonExit.setOnAction(event -> {
            System.exit(0);
        });

        lblScore.setText("Score: ");
        lblHealth.setText("Health: ");
        lblSteps.setText("Remaining Steps: ");

        gridPane.setGridLinesVisible(true);
    }

    private void updateGui() {
        //Clear old GUI grid pane
        gridPane.getChildren().retainAll(gridPane.getChildren().get(0));
//        gridPane.getChildren().clear();
        gridPane.setScaleX(-1);

        //Loop through map board and add each cell into grid pane
        for(int i = engine.getSize() - 1; i >= 0; i--) {
            for (int j = engine.getMap()[i].length - 1; j >= 0; j--) {
                if (i == engine.getPlayerY() && j == engine.getPlayerX()) {
                    Label lblValue = new Label("P");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i , j) == 0) {
                    Label lblValue = new Label("#");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 1) {
                    Label lblValue = new Label("M");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 2) {
                    Label lblValue = new Label("R");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 3) {
                    Label lblValue = new Label("T");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 5) {
                    Label lblValue = new Label("H");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 4) {
                    Label lblValue = new Label("G");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 6) {
                    Label lblValue = new Label("L");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else if (engine.getTiles()[i][j] != null && engine.getTileType(i, j) == 7) {
                    Label lblValue = new Label("E");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                } else {
                    Label lblValue = new Label(".");
                    lblValue.setMinWidth(50);
                    lblValue.setMinHeight(50);
                    lblValue.setAlignment(Pos.CENTER);
                    lblValue.setScaleY(-1);
                    gridPane.add(lblValue, j, i, 1, 1);
                }
            }
        }

        lblScore.setText(String.format("Score: %d", engine.getScore()));
        lblHealth.setText(String.format("Health: %d/%d", engine.getPlayerHealth(), engine.getPlayerMaxHealth()));
        lblSteps.setText(String.format("Remaining Steps: %d", engine.getSteps()));

        System.setOut(new PrintStream(new CustomerOutputStream(consoleTextArea)));

        if (engine.getGameRunning()) {
            buttonUp.setDisable(true);
            buttonDown.setDisable(true);
            buttonRight.setDisable(true);
            buttonLeft.setDisable(true);
            buttonSave.setDisable(true);
            buttonHelp.setDisable(true);
        }

    }
}

