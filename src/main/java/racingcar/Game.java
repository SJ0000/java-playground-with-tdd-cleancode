package racingcar;

import java.util.List;

public class Game {

    public static void main(String[] args) {


    }

    private void move(List<Car> cars){
        for (Car car : cars) {
            int value = RandomUtils.createRandomInt(0, 9);
            car.move(value);
        }
    }
}
