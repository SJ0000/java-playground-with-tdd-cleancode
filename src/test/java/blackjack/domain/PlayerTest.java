package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("플레이어는 이름을 갖는다.")
    void player_name(){
        String name = "테스트";
        Participant player = new Player(name);
        assertThat(player.getName()).isEqualTo(name);
    }
}