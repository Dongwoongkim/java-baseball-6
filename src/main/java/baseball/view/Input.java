package baseball.view;

import static baseball.converter.StringToListConverter.StringToList;
import static baseball.exception.InputValidator.isRestartOrExitValid;
import static baseball.exception.InputValidator.isSubmitValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public List<Integer> getSubmit() {
        String line = Console.readLine();
        if (isSubmitValid(line)) {
            return StringToList(line);
        }
        throw new IllegalArgumentException();
    }

    public Integer getRestartOrExit() {
        String line = Console.readLine();
        if (isRestartOrExitValid(line)) {
            return Integer.parseInt(line);
        }
        throw new IllegalArgumentException();
    }
}
