package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question {
    static final int ROWS_IN_QUESTION = 5;


    int numberOfQuestion;
    String question;
    String rightAnswer;
    String wrongAnswer1;
    String wrongAnswer2;
    String wrongAnswer3;


    /*
    Get the number of the question to set
     */
    public Question(int num) throws FileNotFoundException {
        this.numberOfQuestion = num;
        readQuestion(numberOfQuestion);

    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    private void readQuestion(int questionNUmber) throws FileNotFoundException {
        int lineCounter = 0;
        Scanner input = new Scanner(new File("trivia.txt"));
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
