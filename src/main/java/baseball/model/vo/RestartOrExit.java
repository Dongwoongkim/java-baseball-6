package baseball.model.vo;

public record RestartOrExit(Integer number) {

    private static final Integer RESTART = 1;
    private static final Integer EXIT = 2;

    public RestartOrExit {
        validate(number);
    }

    private static void validate(Integer restartOrExit) {
        if (restartOrExit != RESTART && restartOrExit != EXIT) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isExit() {
        return number.equals(EXIT);
    }
}
