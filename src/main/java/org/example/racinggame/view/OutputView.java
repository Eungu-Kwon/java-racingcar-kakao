package org.example.racinggame.view;

import java.util.List;

import org.example.racinggame.model.Cars;

public class OutputView {

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void printCarPosition(String name, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" : ")
                .append("-".repeat(position));
        System.out.println(sb);
    }

    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printCarPositions(Cars cars) {
        cars.getCars()
            .forEach(car -> printCarPosition(car.getName(), car.getPosition()));
        newLine();
    }
}
