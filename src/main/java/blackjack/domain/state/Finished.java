package blackjack.domain.state;

import blackjack.domain.Card;
import blackjack.domain.Cards;

public abstract class Finished extends Started{
    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public State draw(Card card) {
        return this;
    }

    @Override
    public State stay() {
        return this;
    }

    @Override
    public double profit() {
        return 0;
    }

    public abstract double earningRate();
}
