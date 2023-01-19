package blackjack.domain;


import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;
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

    @Test
    @DisplayName("승리")
    void match_win(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards1.add(new Card(Suit.CLOVER, Denomination.SEVEN));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.TWO));
        cards2.add(new Card(Suit.CLOVER, Denomination.SEVEN));

        Cards bust = new Cards();
        bust.add(new Card(Suit.CLOVER, Denomination.TEN));
        bust.add(new Card(Suit.CLOVER, Denomination.TEN));
        bust.add(new Card(Suit.CLOVER, Denomination.TEN));

        assertThat(cards1.getMatchResult(cards2).isWin()).isTrue();
        assertThat(cards1.getMatchResult(bust).isWin()).isTrue();
    }

    @Test
    @DisplayName("동점")
    void match_draw(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards1.add(new Card(Suit.CLOVER, Denomination.SEVEN));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.THREE));
        cards2.add(new Card(Suit.CLOVER, Denomination.SEVEN));

        assertThat(cards1.getMatchResult(cards2).isDraw()).isTrue();
    }
    @Test
    @DisplayName("동점_bust")
    void match_draw_bust(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards2.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards2.add(new Card(Suit.CLOVER, Denomination.EIGHT));

        assertThat(cards1.getMatchResult(cards2).isDraw()).isTrue();
    }

    @Test
    @DisplayName("동점_blackjack")
    void match_draw_blackjack(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards1.add(new Card(Suit.CLOVER, Denomination.ACE));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.ACE));
        cards2.add(new Card(Suit.CLOVER, Denomination.TEN));

        assertThat(cards1.getMatchResult(cards2).isDraw()).isTrue();
    }

    @Test
    @DisplayName("패배_point")
    void match_lose_point(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.TWO));
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.NINE));
        cards2.add(new Card(Suit.CLOVER, Denomination.TEN));

        assertThat(cards1.getMatchResult(cards2).isLose()).isTrue();
    }

    @Test
    @DisplayName("패배_bust")
    void match_lose_bust(){
        Cards cards1 = new Cards();
        cards1.add(new Card(Suit.CLOVER, Denomination.TWO));
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));
        cards1.add(new Card(Suit.CLOVER, Denomination.TEN));

        Cards cards2 = new Cards();
        cards2.add(new Card(Suit.CLOVER, Denomination.NINE));
        cards2.add(new Card(Suit.CLOVER, Denomination.TEN));

        assertThat(cards1.getMatchResult(cards2)).isEqualTo(MatchResult.LOSE);
    }
}