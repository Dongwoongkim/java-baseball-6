package baseball.controller;

import baseball.model.Result;
import baseball.service.AnswerGenerateService;
import baseball.service.ScoreService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final Integer EXIT = 2;
    private final AnswerGenerateService answerGenerateService = new AnswerGenerateService();
    private final ScoreService scoreService = new ScoreService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Integer> answer;
        printStartMessage();
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
            inputView.printInputRequestMessage();
            result = scoreService.calculateScore(inputView.getSubmit(), answer);
            outputView.printResult(result);
            if (scoreService.isAllStrike(result)) {
                inputView.printRestartOrExitMessage();
                break;
            }
        }
    }

    private List<Integer> makeNewAnswer() {
        List<Integer> answer = answerGenerateService.getGeneratedNumbers();
        return answer;
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }
}
