package sample;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic
{

    static final int NUMBER_OF_QUESTION = 12;

    int score;
    Question question;
    ArrayList<Integer> askedQuestions;
    int questionNumber;


    public GameLogic() throws FileNotFoundException {
        askedQuestions = new ArrayList<Integer>();
        newGame();
    }

    public static int getNumberOfQuestion() {
        return NUMBER_OF_QUESTION;
    }


    public Question getQuestion() {
        return question;
    }

    public ArrayList<Integer> getAskedQuestions() {
        return askedQuestions;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getScore() {
        return score;
    }

    public void rightAnswer() {
        this.score += 10;
    }

    public void wrongAnswer() {
        this.score -= 5;
    }

    // creates new question Object
    public void newQuestion() throws FileNotFoundException {
        this.question = new Question(generateRandomForQuestion());

    }
    public void isRightAnswer(int score) {
        this.score = score;
    }

    /*
    Generate a question that has not yet appeared
     */
    public int generateRandomForQuestion()
    {
        Random ran = new Random();
        int question = ran.nextInt(NUMBER_OF_QUESTION);;
        while (askedQuestion(question))
        {
            question = ran.nextInt(NUMBER_OF_QUESTION);
        }
        return question;
    }

    // get question number and return if that question number already asked
    public boolean askedQuestion(int question)
    {
        for (Integer askedQuestion : askedQuestions) {
            if (askedQuestion == question) {
                return true;
            }
        }
        return false;
    }

    public void newGame() throws FileNotFoundException {
        if (askedQuestions.size() != 0)
        {
            askedQuestions.clear();
        }
        this.score = 0;
        questionNumber = generateRandomForQuestion();
        this.question = new Question(questionNumber);
        askedQuestions.add(questionNumber);
    }
}
