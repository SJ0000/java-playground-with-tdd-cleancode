package blackjack.domain;

import blackjack.domain.state.State;

public interface Participant {
    String getName();

    State getState();

    void hit(Card card);

    void stay();
}
