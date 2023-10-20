package baseball.service;


import baseball.model.Result;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreService {

    private static final Integer THREE_STRIKE = 3;

    public Result calculateScore(List<Integer> input, List<Integer> result) {
        Integer strike = calculateStrike(input, result);
        Integer ball = calculateBall(input, result);
        return new Result(strike, ball);
    }

    public boolean isAllStrike(Result result) {
        return result.getStrike() == THREE_STRIKE;
    }

    public Integer calculateStrike(List<Integer> input, List<Integer> result) {
        return (int) IntStream.range(0, result.size())
                .filter(i -> input.get(i)
                        .equals(result.get(i)))
                .count();
    }

    public Integer calculateBall(List<Integer> input, List<Integer> result) {
        return (int) IntStream.range(0, result.size())
                .filter(i -> excludeStrike(input, result, i) && includeBall(input, result, i))
                .count();
    }

    private boolean excludeStrike(List<Integer> input, List<Integer> result, int i) {
        return !input.get(i).equals(result.get(i));
    }

    private boolean includeBall(List<Integer> input, List<Integer> result, int i) {
        return input.contains(result.get(i));
    }
}