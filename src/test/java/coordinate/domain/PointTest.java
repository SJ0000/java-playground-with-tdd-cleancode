package coordinate.domain;

import coordinate.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("좌표가 범위를 벗어난 경우 IllegalArgumentException 발생")
    void invalid(){
        assertThatThrownBy(()->{
            Point p = new Point(0,25);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}