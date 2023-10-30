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

    public void start() {
        List<String> carNames = inputView.readCarNames();
        int totalRounds = inputView.readNumberOfAttempts();
        RacingGame racingGame = new RacingGame(carNames, totalRounds);

        playRacingGame(totalRounds, racingGame);

        List<RacingCar> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }

    private void playRacingGame(int totalRounds, RacingGame racingGame) {
        outputView.printResultHeader();
        for (int i = 0; i < totalRounds; i++) {
            racingGame.moveCars();
            List<RacingCar> racingCars = racingGame.getRacingCars();
            outputView.printCars(racingCars);
        }
    }
}
