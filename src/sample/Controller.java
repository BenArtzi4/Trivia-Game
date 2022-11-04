package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

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
    boolean firstGame = true;
    boolean answered = false;

    public Controller() throws FileNotFoundException {
    }

    @FXML
    void answer1Pressed(ActionEvent event) throws FileNotFoundException {
        checkAnswer(event);
    }

    @FXML
    void answer2Pressed(ActionEvent event) throws FileNotFoundException {
        checkAnswer(event);
    }

    @FXML
    void answer3Pressed(ActionEvent event) throws FileNotFoundException {
        checkAnswer(event);
    }

    @FXML
    void answer4Pressed(ActionEvent event) throws FileNotFoundException {
        checkAnswer(event);
    }

    public void initialize() throws FileNotFoundException {
        score.setText("Your current score is: " + game.getScore());
        if (!firstGame)
        {
            game.newGame();
        }
        firstGame = false;
        setTextInQuestion();
        setTextInAnswers();
    }

    public void setTextInQuestion()
    {
        question.setText(game.getQuestion().question);
    }

    public void setTextInAnswers()
    {
        String [] answers = new String []{game.getQuestion().getRightAnswer(), game.getQuestion().getWrongAnswer1(),game.getQuestion().getWrongAnswer2(),game.getQuestion().getWrongAnswer3()};
        RadioButton [] radios = new RadioButton[]{answer1, answer2, answer3, answer4};
        int answersCounter = 0;
        ArrayList<Integer> tempNums = new ArrayList<Integer>();
        Random ran = new Random();
        int questionNumber;

        while (tempNums.size() < 4)
        {
            questionNumber = ran.nextInt(4);;
            if (!appearInTempNUms(tempNums, questionNumber))
            {
                radios[answersCounter].setText(answers[questionNumber]);
                tempNums.add(questionNumber);
                answersCounter++;
                System.out.println("answersCounter: " + answersCounter + "\nquestionNumber: " + questionNumber
                        +  "\n" + answers[questionNumber]);
            }

        }
    }

    private boolean appearInTempNUms(ArrayList<Integer> tempNums, int num)
    {
        for (Integer tempNum : tempNums) {
            if (tempNum == num) {
                return true;
            }
        }
        return false;
    }

    public void checkAnswer(ActionEvent event) throws FileNotFoundException {
        String currAnswer = ((RadioButton) event.getSource()).getText();
        if (currAnswer.equals(game.getQuestion().getRightAnswer()))
        {
            game.rightAnswer();
        }
        else
        {
            game.wrongAnswer();
        }
        game.newQuestion();
        setTextInQuestion();
        setTextInAnswers();
        ((RadioButton) event.getSource()).setSelected(false);
        score.setText("Your current score is: " + game.getScore());
    }
}
