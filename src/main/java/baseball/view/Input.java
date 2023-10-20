package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static baseball.exception.InputValidator.*;
import static baseball.converter.StringToListConverter.StringToList;

public class Input {
    private List<Integer> input;
    private Integer exit;

    public List<Integer> getInput() {
        setInput();
        return this.input;
    }

    public Integer getExit() {
        setExit();
        return this.exit;
    }

    public void setInput() {
        String line = Console.readLine();
        if (isInputValid(line)) {
            this.input = StringToList(line);
        }
    }

    private void setExit() {
        String line = Console.readLine();
        if (isExitValid(line)) {
            this.exit = Integer.parseInt(line);
        }
    }
}
