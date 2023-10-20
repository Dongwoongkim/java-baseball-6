package baseball.controller;

import baseball.model.Result;
import baseball.service.AnswerGenerateService;
import baseball.service.ScoreService;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class BaseballGameController {

    private static final Integer EXIT = 2;
    private final AnswerGenerateService answerGenerateService = new AnswerGenerateService();
    private final ScoreService scoreService = new ScoreService();
    private final Input input = new Input();
    private final Output output = new Output();

    public void start() {
        List<Integer> answer;
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
        Result result;
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
        List<Integer> answer = answerGenerateService.getGeneratedNumbers();
        return answer;
    }
}
