package blackjack.domain;

import blackjack.domain.state.State;

abstract class AbstractParticipant implements Participant{

    protected State state;

    public AbstractParticipant(Cards cards) {
        this.state = State.of(cards);
    }


    @Override
    public State getState() {
        return state;
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
