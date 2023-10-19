package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerateService {
    public List<Integer> getGeneratedNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        List<Integer> result = numbers.subList(0, 3);
        return result;
    }
}
