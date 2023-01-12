package coordinate.domain;

import coordinate.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("좌표가 범위를 벗어난 경우 IllegalArgumentException 발생")
    void invalid() {
        assertThatThrownBy(() -> {
            Point p = new Point(0, 25);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두 점 사이의 길이를 계산한다.")
    void distance() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(14, 15);

        assertThat(p1.distance(p2))
                .isEqualTo(6.403, offset(0.00099));
    }

    @Test
    @DisplayName("두 점을 이은 선이 수직선인지 판단")
    void vertical() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(14, 1);
        assertThat(p1.isHorizontal(p2))
                .isTrue();

        Point p3 = new Point(1, 14);
        assertThat(p1.isHorizontal(p3))
                .isFalse();
    }

    @Test
    @DisplayName("두 점을 이은 선이 수직선인지 판단")
    void horizontal() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 14);
        assertThat(p1.isVertical(p2))
                .isTrue();

        Point p3 = new Point(14, 1);
        assertThat(p1.isVertical(p3))
                .isFalse();
    }
}