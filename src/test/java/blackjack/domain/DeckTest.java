package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @DisplayName("덱에서 2장의 카드를 뽑는다.")
    void initialDealingTest(){
        Deck deck = new Deck();
        Cards cards = deck.drawTwoCards();
        assertThat(cards.size()).isEqualTo(2);
    }

}