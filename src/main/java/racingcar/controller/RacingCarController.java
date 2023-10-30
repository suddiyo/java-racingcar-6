package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runRacingGame() {
        RacingGame racingGame = setupRacingGame();
        playRacingGame(racingGame);
        displayWinners(racingGame);
    }

    private RacingGame setupRacingGame() {
        List<String> carNames = inputView.readCarNames();
        return new RacingGame(carNames);
    }

    private void playRacingGame(RacingGame racingGame) {
        int totalRounds = inputView.readNumberOfAttempts();
        outputView.printResultHeader();

        for (int i = 0; i < totalRounds; i++) {
            racingGame.moveCars();
            outputView.printCars(racingGame.getRacingCars());
        }
    }

    private void displayWinners(RacingGame racingGame) {
        List<RacingCar> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }

}
