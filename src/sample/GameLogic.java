package sample;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic
{

    /*
    A final variable that holds the total number of questions in the file
     */
    final int NUMBER_OF_QUESTION = 12;
    final int INITIAL = 0;
    final int RIGHT_ANSWER_POINTS = 10;
    final int WRONG_ANSWER_POINTS = 5;


    /*
    A variable that holds the player's current score
     */
    int score;

    /*
    A variable that holds the current question
     */
    Question question;
    /*
    Array of the numbers of the questions asked
     */
    ArrayList<Integer> askedQuestions;
    /*
    A variable that holds the current question number
     */
    int questionNumber;

    /*
    A constructor that initializes the relevant variables and chooses question randomness from the file
     */
    public GameLogic() throws FileNotFoundException
    {
        askedQuestions = new ArrayList<Integer>();
        newGame();
    }


    /*
    Getters
     */
    public Question getQuestion() {
        return question;
    }

    public ArrayList<Integer> getAskedQuestions()
    {
        return askedQuestions;
    }

    public int getScore()
    {
        return score;
    }

    public void rightAnswer()
    {
        this.score += RIGHT_ANSWER_POINTS;
    }

    public void wrongAnswer()
    {
        this.score -= WRONG_ANSWER_POINTS;
    }

    // A method that creates new question Object
    public void newQuestion() throws FileNotFoundException
    {
        this.question = new Question(generateRandomForQuestion());

    }


    /*
    Generate a random question that has not yet appeared
     */
    public int generateRandomForQuestion()
    {
        Random ran = new Random();
        int question = ran.nextInt(NUMBER_OF_QUESTION);
        while (askedQuestion(question))
        {
            question = ran.nextInt(NUMBER_OF_QUESTION);
        }
        askedQuestions.add(question);
        return question;
    }

    /*
    A method that receives a question number and checks whether the question has already been asked
    */
    public boolean askedQuestion(int question)
    {
        for (Integer askedQuestion : askedQuestions) {
            if (askedQuestion == question) {
                return true;
            }
        }
        return false;
    }

    /*
    A method that initializes a new game and the relevant variables
     */
    public void newGame() throws FileNotFoundException
    {
        if (askedQuestions.size() != INITIAL)
        {
            askedQuestions.clear();
        }
        this.score = INITIAL;
        questionNumber = generateRandomForQuestion();
        this.question = new Question(questionNumber);
    }

    /*
    A method that adds the current question to the set of asked questions
     */
    public void addQuestionToArray() throws FileNotFoundException
    {
        System.out.println(askedQuestions);

    }

    /*
    A method that is invoked when the game ends for some reason and checks if the player wants to play another game
     */
    public void gameFinish() throws FileNotFoundException
    {
        JOptionPane.showMessageDialog(null, "Well done!\nYour Score is: " + score, "Trivia", JOptionPane.INFORMATION_MESSAGE);
        int answer = JOptionPane.showConfirmDialog(null,"Would you answer more questions?", "Trivia", JOptionPane.YES_NO_OPTION);
        /*
        Test again
         */
        if (answer != INITIAL)
        {
            System.exit(0);
        }
        newGame();
    }
}
