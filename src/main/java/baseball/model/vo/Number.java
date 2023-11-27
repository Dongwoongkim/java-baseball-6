package baseball.model.vo;

public record Number(Integer number) {

    private static final Integer ZERO_NUMBER = 0;

    public Number {
        validate(number);
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
}
