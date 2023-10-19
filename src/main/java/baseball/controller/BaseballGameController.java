package baseball.controller;

import baseball.service.NumberGenerateService;
import baseball.service.ScoreService;
import baseball.view.Input;
import baseball.model.Result;
import baseball.view.Output;

import java.util.List;

public class BaseballGameController {

    private static final Integer THREE_STRIKE = 3;
    private NumberGenerateService numberGenerateService;
    private ScoreService scoreService;
    private Input input;
    private Output output;
    private Result result;

    public BaseballGameController() {
        this.numberGenerateService = new NumberGenerateService();
        this.scoreService = new ScoreService();
        this.input = new Input();
        this.result = new Result(0, 0);
        this.output = new Output();
    }

    public void start() {
        output.printStartMessage();
        List<Integer> answer = numberGenerateService.getGeneratedNumbers();
        System.out.println(answer);

        while (true) {
            output.printInputRequestMessage();
            result = scoreService.calculateScore(input.getInput(), answer);
            output.printResult(result);
            if (isAllStrike(result)) {
                output.printRestartOrExitMessage();
                if (input.getExit() == 1) {
                    answer = numberGenerateService.getGeneratedNumbers();
                    continue;
                }
                break;
            }
        }
    }

    private boolean isAllStrike(Result result) {
        return result.getStrike() == THREE_STRIKE;
    }
}