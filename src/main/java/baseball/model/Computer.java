package baseball.model;

import baseball.service.NumberGenerateService;
import baseball.service.ScoreCalculateService;
import baseball.view.Result;

import java.util.List;
import java.util.Set;

public class Computer {

    private NumberGenerateService numberGenerateService;
    private ScoreCalculateService scoreCalculateService;

    public Computer() {
        this.numberGenerateService = new NumberGenerateService();
        this.scoreCalculateService = new ScoreCalculateService();
    }

    public List<Integer> numberGenerate() {
        return numberGenerateService.getGeneratedNumbers();
    }

    public Result calculateScore(List<Integer> input, List<Integer> result) {
        Integer strike = scoreCalculateService.calculateStrike(input, result);
        Integer ball = scoreCalculateService.calculateBall(input, result);
        return new Result(strike, ball);
    }

}
