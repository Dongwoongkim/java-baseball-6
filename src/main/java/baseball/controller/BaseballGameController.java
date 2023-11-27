package baseball.controller;

import baseball.model.AnswerGenerator;
import baseball.model.GuessNumber;
import baseball.model.RandomNumberGenerator;
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

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        while (true) {
            playOneRound();
            outputView.printWinGameMessage();
            RestartOrExit restartOrExit = inputRestartOrExit();
            if (restartOrExit.isExit()) {
                return;
            }
        }
    }

    private RestartOrExit inputRestartOrExit() {
        String restartOrExit = inputView.inputRestartOrExit();
        InputValidator.validateRestartOrExit(restartOrExit);
        return new RestartOrExit(InputConverter.stringToRestartOrExit(restartOrExit));
    }

    private void playOneRound() {
        List<Integer> answer = initAnswer();
        
        while (true) {
            GuessNumber guessNumber = initGuessNumber();
            Integer strike = guessNumber.calculateStrike(answer);
            Integer ball = guessNumber.calculateBall(answer);
            outputView.printHint(strike, ball);
            if (strike == 3) {
                return;
            }
        }
    }

    private GuessNumber initGuessNumber() {
        return GuessNumber.create(inputNumbers());
    }

    private List<Integer> initAnswer() {
        AnswerGenerator answerGenerator = new RandomNumberGenerator();
        List<Integer> answer = answerGenerator.pickThreeNumbers();
        return answer;
    }

    private List<Number> inputNumbers() {
        String inputNumbers = inputView.inputNumbers();
        InputValidator.validateInputNumbers(inputNumbers);
        return InputConverter.stringToGuessNumberList(inputNumbers);
    }
}
