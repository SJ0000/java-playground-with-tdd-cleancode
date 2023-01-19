package blackjack.domain.state;

import blackjack.domain.Cards;

public abstract class Started implements State{

    protected Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
