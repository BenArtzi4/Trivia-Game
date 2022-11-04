package sample;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic
{

    static final int NUMBER_OF_QUESTION = 12;
    //The line of the question is always the first
    static final int QUESTION = 0;
    //The line of the right answer is always the second
    static final int CORRECT_ANSWER = 1;
    //Each question contain 5 rows of question and 4 answers
    static final int ROWS = 5;

    int score;
    Question question;
    ArrayList<Integer> askedQuestions;
    int questionNumber;


    public GameLogic() throws FileNotFoundException {
        this.score = 0;
        askedQuestions = new ArrayList<Integer>();
        questionNumber = generateRandomForQuestion();
        Question question = new Question(questionNumber);
        askedQuestions.add(questionNumber);
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
        boolean asked = true;
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
}
