package baseball.controller;

import baseball.model.AnswerGenerator;
import baseball.model.GuessNumber;
import baseball.model.RandomNumberGenerator;
import baseball.model.Score;
import baseball.model.vo.Number;
import baseball.model.vo.RestartOrExit;
import baseball.util.InputConverter;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        showStartMessage();
        do {
            List<Integer> answer = initAnswer();
            playOneRound(answer);
        } while (!inputRestartOrExit().isExit());
    }

    private void showStartMessage() {
        outputView.printStartMessage();
    }

    private List<Integer> initAnswer() {
        AnswerGenerator answerGenerator = new RandomNumberGenerator();
        List<Integer> answer = answerGenerator.pickThreeNumbers();
        return answer;
    }

    private void playOneRound(final List<Integer> answer) {
        while (true) {
            GuessNumber guessNumber = initGuessNumber();
            Score score = Score.create(guessNumber.calculateStrike(answer), guessNumber.calculateBall(answer));
            showHint(score);
            if (score.isThreeStrike()) {
                showWinMessage();
                return;
            }
        }
    }

    private GuessNumber initGuessNumber() {
        return GuessNumber.create(inputNumbers());
    }

    private List<Number> inputNumbers() {
        String inputNumbers = inputView.inputNumbers();
        InputValidator.validateInputNumbers(inputNumbers);
        return InputConverter.stringToGuessNumberList(inputNumbers);
    }

    private void showHint(Score score) {
        outputView.printHint(score.getStrike(), score.getBall());
    }

    private void showWinMessage() {
        outputView.printWinGameMessage();
    }

    private RestartOrExit inputRestartOrExit() {
        String restartOrExit = inputView.inputRestartOrExit();
        InputValidator.validateRestartOrExit(restartOrExit);
        return new RestartOrExit(InputConverter.stringToRestartOrExit(restartOrExit));
    }
}
