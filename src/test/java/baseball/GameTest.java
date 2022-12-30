package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    Game game = new Game();


    @Test
    @DisplayName("게임 실행시 정답 숫자를 생성한다.")
    void start(){
        game.start();
    }


    @Test
    @DisplayName("첫 번째 숫자 strike 인 경우 judgment의 strike가 1어야 한다.")
    void strike(){
        Game.Judgment judgment = new Game.Judgment("425");
        judgment.pitch(0,'4');
        Assertions.assertThat(judgment.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("첫 번째 숫자 ball인 경우 judgment의 strike가 1어야 한다.")
    void ball(){
        Game.Judgment judgment = new Game.Judgment("425");
        judgment.pitch(0,'2');
        Assertions.assertThat(judgment.getBall()).isEqualTo(1);
    }

}