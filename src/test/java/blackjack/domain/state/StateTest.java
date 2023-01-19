package blackjack.domain.state;

import blackjack.domain.Card;
import blackjack.domain.Cards;
import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    @DisplayName("첫 2장 점수가 21인 경우, 블랙잭이다.")
    void state_blackjack(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.ACE));
        cards.add(new Card(Suit.CLOVER, Denomination.TEN));
        State state = State.of(cards);
        assertThat(state instanceof Blackjack).isTrue();
    }

    @Test
    @DisplayName("첫 2장 점수가 21보다 작은 경우, 히트 이다.")
    void state_hit(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.ACE));
        cards.add(new Card(Suit.CLOVER, Denomination.NINE));
        State state = State.of(cards);
        assertThat(state instanceof Hit).isTrue();
    }

    @Test
    @DisplayName("hit 후 점수가 21을 초과한 경우 bust 이다.")
    void state_bust(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards.add(new Card(Suit.CLOVER, Denomination.NINE));
        State hit = State.of(cards);
        State bust = hit.draw(new Card(Suit.CLOVER, Denomination.FIVE));

        assertThat(bust instanceof Bust).isTrue();
    }

    @Test
    @DisplayName("stay 이후에는 카드를 더 뽑을 수 없다.")
    void stay_exception(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards.add(new Card(Suit.CLOVER, Denomination.NINE));
        State stay = State.of(cards).stay();

        assertThatThrownBy(()-> stay.draw(new Card(Suit.CLOVER, Denomination.ACE)))
                .isInstanceOf(RuntimeException.class);
    }
}