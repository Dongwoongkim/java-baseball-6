package baseball.util;

import baseball.model.vo.Number;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    private InputConverter() {
    }

    public static List<Number> stringToGuessNumberList(final String numbers) {
        return numbers.chars()
                .mapToObj(number ->
                        new Number(Character.getNumericValue(number))
                ).collect(Collectors.toList());
    }

    public static Integer stringToRestartOrExit(final String restartOrExit) {
        return Integer.valueOf(restartOrExit);
    }
}
