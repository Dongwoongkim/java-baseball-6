package baseball.exception;

public class InputValidator {

    public static boolean isThreeChar(String input) {
        if (input.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isNumber(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException("입력값에 문자가 포함되어 있습니다.");
        }
        return true;
    }

    public static boolean isBetweenOneAndNine(String input) {
        if (input.chars().anyMatch(c -> c < '1' || c > '9')) {
            throw new IllegalArgumentException("입력값이 1~9 사이의 숫자가 아닙니다.");
        }
        return true;
    }

    public static boolean isNotDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
        return true;
    }

    public static boolean isLengthOne(String line) {
        if (line.length() != 1) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        return true;
    }

    public static boolean isEqualToOneOrTwo(String line) {
        if (line.charAt(0) != '1' || line.charAt(0) != '2') {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        return true;
    }

    public static boolean isInputValid(String input) {
        if (isThreeChar(input) && isNumber(input) && isBetweenOneAndNine(input) && isNotDuplicate(input)) {
            return true;
        }
        return false;
    }

    public static boolean isExitValid(String line) {
        if (isLengthOne(line) && isEqualToOneOrTwo(line)) {
            return true;
        }
        return false;
    }
}
