package org.example.racinggame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int CAR_RANDOM_NUMBER_START = 0;
    private static final int CAR_RANDOM_NUMBER_END = 9;

    private final List<Car> cars;

    public Cars(String inputString) {
        this.cars = Arrays.stream(inputString.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getCarSize() {
        return cars.size();
    }

    public Car getCarFromName(String carName) {
        return cars.stream()
                .filter(car -> car.isSameCarName(carName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 차량이 없습니다."));
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isCarInMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car ->
                car.forward(RandomIntegerGenerator.generateEndInclusive(CAR_RANDOM_NUMBER_START, CAR_RANDOM_NUMBER_END))
        );
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }
}
