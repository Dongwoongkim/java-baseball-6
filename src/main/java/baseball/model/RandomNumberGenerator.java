package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements AnswerGenerator {

    private static final Integer ANSWER_SIZE = 3;
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;

    @Override
    public List<Integer> pickThreeNumbers() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addIfNotExist(answer, randomNumber);
        }
        return answer;
    }

    private void addIfNotExist(final List<Integer> answer, final int randomNumber) {
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
