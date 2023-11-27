package baseball.util;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateInputNumbers(final String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestartOrExit(final String inputRestartOrExit) {
        if (inputRestartOrExit.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(inputRestartOrExit)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(final String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
