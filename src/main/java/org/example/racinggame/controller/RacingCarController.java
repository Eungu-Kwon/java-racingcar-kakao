package org.example.racinggame.controller;

import java.util.List;

import org.example.racinggame.model.Cars;
import org.example.racinggame.view.InputView;
import org.example.racinggame.view.OutputView;

public class RacingCarController {
    private final Cars cars;
    private final String carNames;
    private final int tryCount;
    private int currentCount = 0;

    public RacingCarController(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        cars = new Cars(carNames);
    }

    public void play() {
        cars.move();
        currentCount++;
    }

    public boolean isEnd() {
        if (currentCount >= tryCount) {
            return true;
        }
        return false;
    }

    public List<String> getWinners() {
        return cars.selectWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
