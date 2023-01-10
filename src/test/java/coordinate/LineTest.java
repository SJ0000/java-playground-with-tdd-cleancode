package coordinate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LineTest {

    @Test
    @DisplayName("직선의 길이를 계산한다.")
    void length(){
        Point p1 = new Point(10,10);
        Point p2 = new Point(14,15);
        Line line = new Line(p1,p2);

        assertThat(line.getLength())
                .isEqualTo(6.403,offset(0.00099));
    }
}