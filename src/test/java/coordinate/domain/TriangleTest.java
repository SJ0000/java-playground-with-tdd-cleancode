package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("삼각형 넓이 계산")
    void area(){
        List<Point> points = List.of(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );
        Triangle tri = new Triangle(points);

        assertThat(tri.getArea()).isEqualTo(29.0, Offset.offset(0.00099));
    }
}