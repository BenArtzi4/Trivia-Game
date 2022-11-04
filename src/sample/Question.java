package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question {
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
        readQueastion();

    }

    private void readQueastion() throws FileNotFoundException {
        int lineCounter = 0;
        Scanner input = new Scanner(new File("trivia.txt"));
        while (input.hasNext() && lineCounter < 5 )
        {
            String st = input.next();
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
