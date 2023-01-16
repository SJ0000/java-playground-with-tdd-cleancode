package blackjack.domain;


import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CardsTest {


    @Test
    @DisplayName("카드의 점수를 계산한다.")
    void calculate(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards.add(new Card(Suit.CLOVER, Denomination.TEN));

        assertThat(cards.calculatePoint()).isEqualTo(13);
    }

    @Test
    @DisplayName("에이스를 포함한 카드의 최적 점수를 계산한다.")
    void calculateWithAce(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards.add(new Card(Suit.CLOVER, Denomination.SEVEN));
        cards.add(new Card(Suit.CLOVER, Denomination.ACE));
        assertThat(cards.calculatePoint()).isEqualTo(21);

        cards.add(new Card(Suit.CLOVER, Denomination.ACE));
        assertThat(cards.calculatePoint()).isEqualTo(12);
    }

    @Test
    @DisplayName("카드의 합이 21, 블랙잭")
    void blackjack(){
        Cards cards = new Cards();
        cards.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards.add(new Card(Suit.CLOVER, Denomination.SEVEN));
        cards.add(new Card(Suit.CLOVER, Denomination.ACE));
        assertThat(cards.isBlackJack()).isTrue();
    }
}