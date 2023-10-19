package baseball.service;

import baseball.model.Computer;
import baseball.model.User;

import java.util.List;
import java.util.stream.IntStream;

public class ScoreCalculateService {

    private User userScore;
    private Computer computer;

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