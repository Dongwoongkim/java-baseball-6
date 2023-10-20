package baseball.controller;

import baseball.service.RandomNumberGenerateService;
import baseball.service.ScoreService;
import baseball.view.Input;
import baseball.model.Result;
import baseball.view.Output;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private static final Integer EXIT = 2;
    private final RandomNumberGenerateService randomNumberGenerateService = new RandomNumberGenerateService();
    private final ScoreService scoreService = new ScoreService();
    private final Input input = new Input();
    private final Output output = new Output();
    private Result result = new Result(0, 0);
    private List<Integer> answer = new ArrayList<>();

    public void start() {
        output.printStartMessage();
        while (true) {
            answer = makeNewAnswer();
            playOneRound(answer);
            if (input.getRestartOrExit() == EXIT) {
                break;
            }
        }
    }

    private void playOneRound(List<Integer> answer) {
        while (true) {
            output.printInputRequestMessage();
            result = scoreService.calculateScore(input.getSubmit(), answer);
            output.printResult(result);
            if (scoreService.isAllStrike(result)) {
                output.printRestartOrExitMessage();
                break;
            }
        }
    }

    private List<Integer> makeNewAnswer() {
        List<Integer> answer = randomNumberGenerateService.getGeneratedNumbers();
        return answer;
    }
}
