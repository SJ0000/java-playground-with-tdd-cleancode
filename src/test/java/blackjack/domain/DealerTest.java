package blackjack.domain;

import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {


    @Test
    @DisplayName("딜러는 16점 이하일 때 히트 할 수 있다.")
    void canHit(){
        Dealer dealer = new Dealer();
        dealer.hit(new Card(Suit.CLOVER, Denomination.TEN));
        dealer.hit(new Card(Suit.CLOVER, Denomination.SIX));
        assertThat(dealer.canHit()).isTrue();
    }

    @Test
    @DisplayName("딜러는 17점 이상일 때 히트 할 수 없다.")
    void cannotHit(){
        Dealer dealer = new Dealer();
        dealer.hit(new Card(Suit.CLOVER, Denomination.TEN));
        dealer.hit(new Card(Suit.CLOVER, Denomination.SEVEN));
        assertThat(dealer.canHit()).isFalse();
    }
}