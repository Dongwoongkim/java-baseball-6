package baseball.view;

import static baseball.converter.StringToListConverter.StringToList;
import static baseball.exception.InputValidator.isRestartOrExitValid;
import static baseball.exception.InputValidator.isSubmitValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_REQUEST_MSG = "숫자를 입력해주세요 : ";

    public void printInputRequestMessage() {
        System.out.print(INPUT_REQUEST_MSG);
    }

    public void printRestartOrExitMessage() {
        System.out.print(RESTART_OR_EXIT);
    }

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
