package baseball.controller;

import baseball.model.Result;
import baseball.service.AnswerGenerateService;
import baseball.service.ScoreService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private static final Integer EXIT = 2;
    private final AnswerGenerateService answerGenerateService = new AnswerGenerateService();
    private final ScoreService scoreService = new ScoreService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Integer> answer;
        outputView.printStartMessage();
        while (true) {
            answer = makeNewAnswer();
            playOneRound(answer);
            if (inputView.getRestartOrExit() == EXIT) {
                break;
            }
        }
    }

    private void playOneRound(List<Integer> answer) {
        Result result;
        while (true) {
            outputView.printInputRequestMessage();
            result = scoreService.calculateScore(inputView.getSubmit(), answer);
            outputView.printResult(result);
            if (scoreService.isAllStrike(result)) {
                outputView.printRestartOrExitMessage();
                break;
            }
        }
    }

    private List<Integer> makeNewAnswer() {
        List<Integer> answer = answerGenerateService.getGeneratedNumbers();
        return answer;
    }
}
