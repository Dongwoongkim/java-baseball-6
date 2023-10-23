package baseball.model;

import static baseball.util.InputValidator.isGameStateNumberValid;

import camp.nextstep.edu.missionutils.Console;

public enum GameStateNumber {

    DEFAULT(0), RESTART(1), EXIT(2);

    private Integer stateNumber;

    GameStateNumber(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }

    public void input() {
        String input = Console.readLine();
        validateGameStateNumber(input);
        this.stateNumber = Integer.parseInt(input);
    }

    private void validateGameStateNumber(String input) {
        if (!isGameStateNumberValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isExit() {
        if (this.stateNumber == EXIT.stateNumber) {
            return true;
        }
        return false;
    }
}
