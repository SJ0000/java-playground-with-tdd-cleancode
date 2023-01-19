package blackjack.domain;

import blackjack.domain.state.State;

abstract class AbstractParticipant implements Participant{

    protected State state;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void hit(Card card) {
        state = state.draw(card);
    }

    @Override
    public void stay() {
        state = state.stay();
    }
}
