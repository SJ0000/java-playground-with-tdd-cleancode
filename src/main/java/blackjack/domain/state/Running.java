package blackjack.domain.state;

import blackjack.domain.Cards;

public abstract class Running extends Started{

    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public double profit() {
        return 1;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
