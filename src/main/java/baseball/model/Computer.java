package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private static final Integer BALL_SIZE = 3;
    private final static Integer FIRST_NUMBER = 1;
    private final static Integer LAST_NUMBER = 9;

    public List<Integer> getGeneratedNumbers() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
            addIfNotInList(answer, randomNumber);
        }
        return answer;
    }

    private void addIfNotInList(List<Integer> answer, int randomNumber) {
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public Score calculateScore(List<Integer> playerInput, List<Integer> answer) {
        Integer strike = calculateStrike(playerInput, answer);
        Integer ball = calculateBall(playerInput, answer);
        return new Score(strike, ball);
    }

    public Integer calculateStrike(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> playerInput.get(index)
                        .equals(answer.get(index)))
                .count();
    }

    public Integer calculateBall(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> excludeStrike(playerInput, answer, index) && includeBall(playerInput, answer, index))
                .count();
    }

    private boolean excludeStrike(List<Integer> playerInput, List<Integer> answer, int index) {
        return !playerInput.get(index).equals(answer.get(index));
    }

    private boolean includeBall(List<Integer> playerInput, List<Integer> answer, int index) {
        return playerInput.contains(answer.get(index));
    }
}
