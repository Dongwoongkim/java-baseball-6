package baseball.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessNumberValidatorTest {

    @Test
    @DisplayName("중복없는 1-9 사이의 3자리 숫자는 입력으로 들어올 수 있다.")
    void validInput() {
        assertTrue(GuessNumberValidator.isGuessNumbersValid("123"));
        assertTrue(GuessNumberValidator.isGuessNumbersValid("945"));
        assertTrue(GuessNumberValidator.isGuessNumbersValid("187"));
        assertTrue(GuessNumberValidator.isGuessNumbersValid("328"));
    }

    @Test
    @DisplayName("입력의 길이가 3이 아닐 시 예외가 발생해야 한다.")
    void isLengthNotThree() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumbersValid("12");
        });
    }

    @Test
    @DisplayName("입력에 문자가 있을 시 예외가 발생해야 한다.")
    void isNotNumeric_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumbersValid("1a2");
        });
    }

    @Test
    @DisplayName("입력에 0의 숫자가 있을 시 예외가 발생해야 한다.")
    void isNotBetweenOneAndNine_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumbersValid("023");
        });
    }

    @Test
    @DisplayName("입력에 중복된 숫자가 있을 시 예외가 발생해야 한다.")
    void isDuplicate_Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessNumberValidator.isGuessNumbersValid("112");
        });
    }

}