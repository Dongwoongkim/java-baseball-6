package baseball.model;

import static baseball.converter.StringToListConverter.StringToList;
import static baseball.exception.InputValidator.isInputNumbersValid;
import static baseball.exception.InputValidator.isRestartOrExitValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {

    private List<Integer> numbers;
    private Integer restartOrExit;

    public void inputNumbers() {
        String input = Console.readLine();
        if (!isInputNumbersValid(input)) {
            throw new IllegalArgumentException();
        }
        this.numbers = StringToList(input);
    }

    public void inputRestartOrExit() {
        String input = Console.readLine();
        if (!isRestartOrExitValid(input)) {
            throw new IllegalArgumentException();
        }
        this.restartOrExit = Integer.parseInt(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getRestartOrExit() {
        return restartOrExit;
    }
}
