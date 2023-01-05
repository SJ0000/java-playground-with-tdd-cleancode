package racingcar;

import com.sun.source.tree.AssertTree;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가질 수 있다.")
    void name(){
        String name = "12345";
        Car car = Car.create(name);
        assertThat(name).isEqualTo(car.getName());
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void nameLengthError(){
        assertThatThrownBy(()->Car.create("123456"))
                .isInstanceOf(RuntimeException.class);
    }

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
    @DisplayName("자동차는 4 이상의 값을 받은 경우 전진한다")
    void move(){
        Car car = Car.create("a");
        int prevMoveCount = car.getMoveCount();
        car.move(4);
        assertThat(car.getMoveCount()).isEqualTo(prevMoveCount+1);
    }
}
