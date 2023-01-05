package racingcar;

import com.sun.source.tree.AssertTree;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
