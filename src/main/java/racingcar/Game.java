package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public static void main(String[] args) {
        RacingView view = new RacingView();

        Cars cars = CarFactory.createCars(view.inputCarNames());
        int tryCount = view.askTryCount();

        view.printResult();
        for(int i=0;i<tryCount;i++){
            cars.move();
            view.printCars(cars.toDto());
        }

        view.printWinners(cars.getWinners().toDto());
    }
}
