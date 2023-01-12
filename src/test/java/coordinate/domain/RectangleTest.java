package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("직사각형 생성 실패")
    void create_fail(){
        List<Point> points = List.of(
                new Point(1, 1),
                new Point(1, 7),
                new Point(10, 1),
                new Point(9, 3)
        );
        assertThatThrownBy(()->{
            Rectangle rectangle = new Rectangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직사각형 넓이")
    void create(){
        List<Point> points = List.of(
                new Point(1, 1),
                new Point(1, 10),
                new Point(10, 1),
                new Point(10, 10)
        );
        Rectangle rectangle = new Rectangle(points);
        assertThat(rectangle.getArea()).isEqualTo(81);
    }
}