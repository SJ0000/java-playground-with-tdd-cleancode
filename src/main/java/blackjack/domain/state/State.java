package blackjack.domain.state;

import blackjack.domain.Card;
import blackjack.domain.Cards;

public interface State {

    State draw(Card card);

    State stay();
    Cards cards();

    int point();

    boolean isFinished();

    static State of(Cards cards){
        if(cards.isBlackJack())
            return new Blackjack(cards);

        return new Hit(cards);
    }
}
