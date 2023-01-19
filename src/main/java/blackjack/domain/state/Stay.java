package blackjack.domain.state;

import blackjack.domain.Cards;

public class Stay extends Finished{

    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1;
    }
}
