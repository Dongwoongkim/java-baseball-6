package baseball.view;

import baseball.model.Result;

public class OutputView {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_REQUEST_MSG = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE = "3스트라이크";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_MSG);
    }

    public void printInputRequestMessage() {
        System.out.print(INPUT_REQUEST_MSG);
    }

    public void printRestartOrExitMessage() {
        System.out.print(RESTART_OR_EXIT);
    }

    public void printResult(Result result) {
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println(NOTHING);
            return;
        } else if (result.getStrike() == 3) {
            System.out.println(THREE_STRIKE);
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(result.getBall() + BALL + result.getStrike() + STRIKE);
    }
}
