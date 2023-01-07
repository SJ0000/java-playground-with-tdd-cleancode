package racingcar;

import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RandomMovingStrategy;

import java.util.Random;

public class Game {

    public static void main(String[] args) {
        RacingView view = new RacingView();

        Cars cars = CarFactory.createCars(view.inputCarNames());
        int tryCount = view.askTryCount();

        view.printResult();

        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        for(int i=0;i<tryCount;i++){
            cars.move(randomMovingStrategy);
            view.printCars(cars.toDto());
        }

        view.printWinners(cars.getWinners().toDto());
    }
}
