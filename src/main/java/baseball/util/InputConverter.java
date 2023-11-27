package baseball.util;

import baseball.model.vo.Number;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    private InputConverter() {
    }

    public static List<Number> stringToGuessNumberList(String numbers) {
        return numbers.chars()
                .mapToObj(number ->
                        Number.create(Character.getNumericValue(number))
                ).collect(Collectors.toList());
    }
}
