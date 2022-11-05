package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
A class representing the current question in the game
 */
public class Question
{
    /*
    A final variable that holds the number of servers relevant to each question - one question and four answers
     */
    static final int ROWS_IN_QUESTION = 5;
    /*
    A variable that holds the question number
     */
    int numberOfQuestion;

    /*
    Variables that hold the text of the question and the answers
     */
    String question;
    String rightAnswer;
    String wrongAnswer1;
    String wrongAnswer2;
    String wrongAnswer3;


    /*
    Constructor that gets the number of the question to set
     */
    public Question(int num) throws FileNotFoundException
    {
        this.numberOfQuestion = num;
        readQuestion(numberOfQuestion);

    }

    /*
    Getters
     */
    public String getRightAnswer()
    {
        return rightAnswer;
    }

    public String getWrongAnswer1()
    {
        return wrongAnswer1;
    }

    public String getWrongAnswer2()
    {
        return wrongAnswer2;
    }

    public String getWrongAnswer3()
    {
        return wrongAnswer3;
    }

    /*
    A method that reads the current question from the text and the relevant answers
     */
    private void readQuestion(int questionNUmber) throws FileNotFoundException {
        int lineCounter = 0;
        Scanner input = new Scanner(new File("trivia.txt"));
        // Skipping over all irrelevant lines
        while (lineCounter < (questionNUmber*ROWS_IN_QUESTION))
        {
            String st = input.nextLine();
            lineCounter++;
        }
        lineCounter = 0;
        while (input.hasNext() && lineCounter < ROWS_IN_QUESTION )
        {
            String st = input.nextLine();
            switch (lineCounter)
            {
                case 0:
                    question = st;
                    break;
                case 1:
                    rightAnswer = st;

                    break;
                case 2:
                    wrongAnswer1 = st;
                    break;
                case 3:
                    wrongAnswer2 = st;

                    break;
                case 4:
                    wrongAnswer3 = st;
                    break;
            }
            lineCounter++;
        }
        input.close();


    }
}
