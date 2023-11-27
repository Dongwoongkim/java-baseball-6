package baseball.model;

import baseball.model.vo.Number;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GuessNumber {

    private static final Integer MIN_INDEX = 0;
    private static final Integer MAX_INDEX = 3;

    private final List<Number> numbers;

    private GuessNumber(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static GuessNumber create(final List<Number> inputNumbers) {
        validate(inputNumbers);
        return new GuessNumber(inputNumbers);
    }

    private static void validate(final List<Number> inputNumbers) {
        if (containsDuplicateNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        if (!isLengthThree(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLengthThree(final List<Number> inputNumbers) {
        if (inputNumbers.size() == 3) {
            return true;
        }
        return false;
    }

    private static boolean containsDuplicateNumber(final List<Number> inputNumbers) {
        Set<Number> uniqueNumbers = new HashSet<>(inputNumbers);
        return inputNumbers.size() != uniqueNumbers.size();
    }

    public Integer calculateStrike(final List<Integer> answer) {
        return (int) IntStream.range(MIN_INDEX, MAX_INDEX)
                .filter(index -> isStrike(answer, index))
                .count();
    }

    public Integer calculateBall(final List<Integer> answer) {
        return (int) IntStream.range(MIN_INDEX, MAX_INDEX)
                .filter(index -> !isStrike(answer, index) && isBall(answer, index))
                .count();
    }

    private boolean isStrike(final List<Integer> answer, final int index) {
        return numbers.get(index).isEqualTo(answer.get(index));
    }

    private boolean isBall(List<Integer> answer, final int index) {
        return answer.contains(numbers.get(index).number());
    }
}
