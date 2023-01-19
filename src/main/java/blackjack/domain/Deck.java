package blackjack.domain;

import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;

import java.util.*;

public class Deck {
    private final Queue<Card> cards;

    public Deck() {
        this.cards = createCards();
    }

    public Cards drawTwoCards(){
        Cards cards =new Cards();
        for(int i=0;i<2;i++){
            cards.add(draw());
        }
        return cards;
    }

    public Card draw(){
        return cards.poll();
    }

    private Queue<Card> createCards(){
        List<Card> list = new ArrayList<>();
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                list.add(new Card(suit,denomination));
            }
        }
        Collections.shuffle(list);
        return new LinkedList<>(list);
    }
}
