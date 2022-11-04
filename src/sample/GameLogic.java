package sample;

public class GameLogic
{

    int score;

    public GameLogic()
    {
        this.score = 0;
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
}
