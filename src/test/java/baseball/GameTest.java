package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    Game game = new Game();


    @Test
    @DisplayName("게임 실행시 정답 숫자를 생성한다.")
    void start(){
        game.start();
    }
}