package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> input;
    private Integer exit;

    public void setInput() {
        String line = Console.readLine();
        if (validateInput(line)) {
            this.input = inputToList(line);
        }
    }

    private List<Integer> inputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    public List<Integer> getInput() {
        setInput();
        return this.input;
    }

    public Integer getExit() {
        setExit();
        return this.exit;
    }

    private void setExit() {
        String line = Console.readLine();
        validateExit(line);

    }

    private void validateExit(String line) {

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
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
        return true;
    }
}
