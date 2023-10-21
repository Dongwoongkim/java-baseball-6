package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Score;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SUGGEST_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final Integer EXIT = 2;

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private Score score = new Score(0, 0);
    private final OutputView outputView = new OutputView();

    public void start() {
        printStartMessage();
        while (player.getRestartOrExit() != EXIT) {
            playOneRound(computer.getGeneratedNumbers());
            player.inputRestartOrExit();
        }
    }

    private void playOneRound(List<Integer> answer) {
        while (true) {
            printSuggestNumberMessage();
            player.inputNumbers();
            score = computer.calculateScore(player.getNumbers(), answer);
            outputView.printResult(score);
            if (score.isAllStrike()) {
                printRestartOrExitMessage();
                break;
            }
        }
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }

    public void printSuggestNumberMessage() {
        System.out.print(SUGGEST_NUMBER_MSG);
    }

    public void printRestartOrExitMessage() {
        System.out.print(RESTART_OR_EXIT);
    }
}
