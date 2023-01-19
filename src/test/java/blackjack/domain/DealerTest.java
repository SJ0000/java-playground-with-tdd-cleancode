package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {


    @Test
    @DisplayName("딜러의 이름은 '딜러' 로 고정되어 있다.")
    void dealer_name(){
        Participant dealer = new Dealer(null);
        Assertions.assertThat(dealer.getName())
                .isEqualTo("딜러");
    }

}