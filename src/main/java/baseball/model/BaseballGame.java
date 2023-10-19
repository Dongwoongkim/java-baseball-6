package baseball.model;

import baseball.service.NumberGenerateService;
import baseball.service.ScoreCalculateService;
import baseball.view.OutputView;
import baseball.view.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private Computer computer;
    private OutputView outputView;
    private User user;

    public BaseballGame() {
        this.computer = new Computer();
        this.outputView = new OutputView();
        this.user = new User();
    }

    public void startGame() {
        outputView.printStartMessage();
        List<Integer> answer = computer.numberGenerate();
        System.out.println(answer);

        while (true) {
            outputView.printInputRequestMessage();
            Result result = computer.calculateScore(user.getInput(), answer);
            outputView.printResult(result);
            if (isAllStrike(result)) {
                outputView.printRestartOrExitMessage();
                break;
            }
        }
    }

    private boolean isAllStrike(Result result) {
        return result.getStrike() == 3;
    }
}
