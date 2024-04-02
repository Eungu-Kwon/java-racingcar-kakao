package org.example.racinggame;

import org.example.racinggame.controller.RacingCarController;
import org.example.racinggame.model.Cars;
import org.example.racinggame.view.InputView;
import org.example.racinggame.view.OutputView;

public class CarGameMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNamesFromUserInput();
        int tryCount = InputView.getTryCountFromUserInput();

        RacingCarController racingCarController = new RacingCarController(carNames, tryCount);

        OutputView.printResult();
        while (!racingCarController.isEnd()) {
            racingCarController.play();
            OutputView.printCarPositions(racingCarController.getCars());
        }

        OutputView.printCarPositions(racingCarController.getCars());
        OutputView.printWinners(racingCarController.getWinners());
    }
}
