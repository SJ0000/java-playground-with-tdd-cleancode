package blackjack.domain;


import blackjack.domain.enums.Denomination;
import blackjack.domain.enums.Suit;

public class Card {
    private final Suit suit;
    private final Denomination denomination;

    public Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public int getValue(){
        return denomination.getValue();
    }

    public boolean isAce(){
        return denomination == Denomination.ACE;
    }

    @Override
    public String toString() {
        return denomination.getName()+suit.getName();
    }
}
