package blackjack.domain.state;

import blackjack.domain.Card;
import blackjack.domain.Cards;

public interface State {

    State draw(Card card);

    State stay();
    Cards cards();

    boolean isFinished();

    double profit();

}
