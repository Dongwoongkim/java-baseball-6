package baseball.model.vo;

public class Number {

    private static final Integer ZERO_NUMBER = 0;
    private final Integer number;

    private Number(Integer number) {
        this.number = number;
    }

    public static Number create(Integer number) {
        validate(number);
        return new Number(number);
    }

    private static void validate(Integer number) {
        if (isZero(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isZero(Integer number) {
        if (number.equals(ZERO_NUMBER)) {
            return true;
        }
        return false;
    }

    public boolean isEqual(Integer answer) {
        return number.equals(answer);
    }

    public Integer getNumber() {
        return number;
    }
}
