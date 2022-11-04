package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private RadioButton answer1;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Button finishBtn;

    @FXML
    private TextField question;

    @FXML
    private TextField score;

    @FXML
    private Button submitBtn;

    GameLogic game = new GameLogic();

    public Controller() throws FileNotFoundException {
    }

    @FXML
    void answer1Pressed(ActionEvent event) {

    }

    @FXML
    void answer2Pressed(ActionEvent event) {

    }

    @FXML
    void answer3Pressed(ActionEvent event) {

    }

    @FXML
    void answer4Pressed(ActionEvent event) {

    }

    public void initialize()
    {
        score.setText("Your current score is: " + game.getScore());
    }

}
