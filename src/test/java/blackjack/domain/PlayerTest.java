package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("init시 덱에서 카드 2장을 꺼낸다.")
    void init(){
        Deck deck = new Deck();
        Player player = new Player("test");
        player.init(deck);
        assertThat(player.cards.size()).isEqualTo(2);
    }
}