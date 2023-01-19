package blackjack.domain;

import blackjack.domain.state.Blackjack;
import blackjack.domain.state.Bust;
import blackjack.domain.state.Finished;

public class Dealer extends AbstractParticipant {

    private static final String DEALER_NAME = "딜러";
    public static final int MUST_HIT_POINT = 16;

    public Dealer(Cards cards) {
        super(cards);
    }

    public boolean mustHit(){
        return state.cards().calculatePoint() <= MUST_HIT_POINT;
    }

    public double getEarningRate(Finished other) {
        // 딜러 패배
        if(state instanceof Bust || state.point() < other.point())
            return other.earningRate();

        // 딜러 승리
        if(other instanceof Bust || state.point() > other.point())
            return -1;

        return 0;
    }

    @Override
    public String getName() {
        return DEALER_NAME;
    }
}
