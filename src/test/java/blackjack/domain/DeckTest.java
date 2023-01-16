package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @DisplayName("deck에서 카드를 한장 뽑는다.")
    void draw(){
        Deck deck = new Deck();
        Card card = deck.draw();
        System.out.println(card);
    }
}