package baseball.model;

public class Score {

    private static final Integer THREE_STRIKE = 3;
    private final Integer strike;
    private final Integer ball;

    private Score(final Integer strike, final Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Score create(final Integer strike, final Integer ball) {
        return new Score(strike, ball);
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        if (strike == THREE_STRIKE) {
            return true;
        }
        return false;
    }
}
