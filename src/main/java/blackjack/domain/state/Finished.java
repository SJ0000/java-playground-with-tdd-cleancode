package blackjack.domain.state;

import blackjack.domain.Card;
import blackjack.domain.Cards;

public abstract class Finished extends Started {
    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public State draw(Card card) {
        throw new RuntimeException("Finished 인 경우 카드를 더 뽑을 수 없습니다.");
    }

    @Override
    public State stay() {
        return this;
    }

    public abstract double earningRate();
}
