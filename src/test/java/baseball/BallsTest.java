package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.openmbean.CompositeType;
import java.util.List;

public class BallsTest {

    @Test
    @DisplayName("상대방의 수가 425일 때 123을 제시한 경우 : 1스트라이크")
    void strike_1(){
        Balls computer = new Balls(List.of(4,2,5));
        Balls playerBalls = new Balls(List.of(1,2,3));

        PlayResult result = computer.play(playerBalls);

        Assertions.assertThat(result.ball).isEqualTo(0);
        Assertions.assertThat(result.strike).isEqualTo(1);
    }

    @Test
    @DisplayName("상대방의 수가 425일 때 456 제시한 경우 : 1볼 1스트라이크")
    void ball_1_strike_1(){
        Balls computer = new Balls(List.of(4,2,5));
        Balls playerBalls = new Balls(List.of(4,5,6));

        PlayResult result = computer.play(playerBalls);

        Assertions.assertThat(result.ball).isEqualTo(1);
        Assertions.assertThat(result.strike).isEqualTo(1);
    }

    @Test
    @DisplayName("상대방의 수가 425일 때 789 제시한 경우 : 낫싱")
    void nothing(){
        Balls computer = new Balls(List.of(4,2,5));
        Balls playerBalls = new Balls(List.of(7,8,9));

        PlayResult result = computer.play(playerBalls);

        Assertions.assertThat(result.ball).isEqualTo(0);
        Assertions.assertThat(result.strike).isEqualTo(0);
    }
}
