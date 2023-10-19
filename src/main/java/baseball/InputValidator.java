package baseball;

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

    public static boolean isBetween1And9(String input) {
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
        return line.length() == 1;
    }

    public static boolean isEqualTo1or2(String line) {
        return line.charAt(0) == '1' || line.charAt(0) == '2';
    }

    public static boolean validateInput(String input) {
        if (isThreeChar(input) && isNumber(input) && isBetween1And9(input) && isNotDuplicate(input)) {
            return true;
        }
        return false;
    }

    public static void validateExit(String line) {
        if (!isLengthOne(line)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        if (!isEqualTo1or2(line)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
    }
}
