package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void strike(){
        Ball ball = new Ball(1, 1);
        Ball ball2 = new Ball(1, 1);
        PitchResult result = ball.pitch(ball2);
        assertThat(result).isEqualTo(PitchResult.STRIKE);
    }

    @Test
    void ball(){
        Ball ball = new Ball(1, 1);
        Ball ball2 = new Ball(3, 1);
        PitchResult result = ball.pitch(ball2);
        assertThat(result).isEqualTo(PitchResult.BALL);
    }

    @Test
    void nothing(){
        Ball ball = new Ball(1, 1);
        Ball ball2 = new Ball(2, 4);
        PitchResult result = ball.pitch(ball2);
        assertThat(result).isEqualTo(PitchResult.NOTHING);
    }
}
