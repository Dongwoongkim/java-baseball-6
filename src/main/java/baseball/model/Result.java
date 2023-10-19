package baseball.model;

public class Result {
    private Integer strike;
    private Integer ball;

    public Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
