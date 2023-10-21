package baseball.model;

import java.util.List;

public class Player {

    private Input input;

    public void inputNumbers() {
        input.inputNumbers();
    }

    public Player() {
        this.input = new Input();
    }

    public void inputRestartOrExit() {
        input.inputRestartOrExit();
    }

    public List<Integer> getNumbers() {
        return input.getNumbers();
    }

    public Integer getRestartOrExit() {
        return input.getRestartOrExit();
    }
}
