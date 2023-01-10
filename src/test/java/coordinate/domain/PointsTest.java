package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @Test
    void equals(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        assertThat(p1).isEqualTo(p2);
    }
}