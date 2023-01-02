package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @Test
    @DisplayName("0 ~ 9의 임의의 수를 생성한다. (100회 반복)")
    void oneToNine(){
        for(int i=0;i<100;i++){
            int num = RandomUtils.createRandomInt(1, 9);
            Assertions.assertThat(num).isLessThan(10).isGreaterThan(0);
        }
    }
}