package baseball.model.computer;

import java.util.List;

public class Computer {

    private GameAnswer gameAnswer;
    private Score score;

    public Computer(GameAnswer gameAnswer, Score score) {
        this.gameAnswer = gameAnswer;
        this.score = score;
    }

    public void makeAnswer() {
        gameAnswer.makeAnswer();
    }

    public List<Integer> getGameAnswer() {
        return gameAnswer.getAnswer();
    }

    public void calculateScore(List<Integer> playerInput) {
        score.calculate(playerInput, getGameAnswer());
    }

    public Score getScore() {
        return score;
    }

    public boolean isScoreAllStrike() {
        return score.isAllStrike();
    }

    public void initScore() {
        score.initScore();
    }
}