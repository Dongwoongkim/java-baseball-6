package baseball.domain;

public class User {

    private String input;

    public void setInput(String input) {
        if (validateInput(input)) {
            System.out.println("pass");
            this.input = input;
        }
    }

    public String getInput() {
        return input;
    }

    public boolean validateInput(String input) {
        if (isThreeChar(input) && isNumber(input) && isBetween1And9(input) && isNotDuplicate(input)) {
            return true;
        }
        return false;
    }

    public boolean isThreeChar(String input) {
        if (input.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("입력값에 문자가 포함되어 있습니다.");
            }
        }
        return true;
    }

    public boolean isBetween1And9(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("입력값이 1~9 사이의 숫자가 아닙니다");
            }
        }
        return true;
    }

    private boolean isNotDuplicate(String input) {
        if (input.charAt(0) != input.charAt(1) && input.charAt(1) != input.charAt(2)) {
            return true;
        }
        throw new IllegalArgumentException("중복된 값이 존재합니다.");
    }
}
