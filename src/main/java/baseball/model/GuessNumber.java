package baseball.model;

import baseball.model.vo.Number;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GuessNumber {

    private final List<Number> numbers;

    private GuessNumber(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static GuessNumber create(List<Number> inputNumbers) {
        validate(inputNumbers);
        return new GuessNumber(inputNumbers);
    }

    private static void validate(List<Number> inputNumbers) {
        if (containsDuplicateNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean containsDuplicateNumber(List<Number> inputNumbers) {
        Set<Number> uniqueNumbers = new HashSet<>(inputNumbers);
        return inputNumbers.size() != uniqueNumbers.size();
    }

    public Integer calculateStrike(List<Integer> answer) {
        return (int) IntStream.range(0, 3)
                .filter(index -> isStrike(answer, index))
                .count();
    }

    public Integer calculateBall(List<Integer> answer) {
        return (int) IntStream.range(0, 3)
                .filter(index -> !isStrike(answer, index) && isBall(answer, index))
                .count();
    }

    private boolean isStrike(List<Integer> answer, int index) {
        return numbers.get(index).isEqual(answer.get(index));
    }

    private boolean isBall(List<Integer> answer, int index) {
        return answer.contains(numbers.get(index).getNumber());
    }
}
