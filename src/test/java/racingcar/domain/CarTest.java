package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @Test
    @DisplayName("입력된 문자열을 쉼표로 구분하여 각 자동차를 생성한다")
    void createCars(){
        String input = "alpha,beta,gamma";
        Cars cars = CarFactory.createCars("alpha,beta,gamma");
        String[] names = input.split(",");

        for (String name : names) {
            assertThat(cars.containsByName(name)).isTrue();
        }
    }

    @Test
    @DisplayName("자동차 전진")
    void move(){
        Car car = new Car("a");
        int prevMoveCount = car.getPosition();
        car.move(()-> true);
        assertThat(car.getPosition()).isEqualTo(prevMoveCount+1);
    }

    @Test
    @DisplayName("자동차 전진 안함")
    void cannot_move(){
        Car car = new Car("a");
        int prevMoveCount = car.getPosition();
        car.move(()-> false);
        assertThat(car.getPosition()).isEqualTo(prevMoveCount);
    }
}
