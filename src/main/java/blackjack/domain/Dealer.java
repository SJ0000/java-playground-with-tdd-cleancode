package blackjack.domain;

import blackjack.domain.enums.MatchResult;

public class Dealer extends AbstractParticipant {

    private static final int CAN_HIT_POINT = 16;

    public Dealer() {
        super("딜러");
    }

    public boolean canHit(){
        return getPoint() <= CAN_HIT_POINT;
    }

    public double getProfitRatio(Cards playerCards){
        MatchResult result = cards.getMatchResult(playerCards);
        if(result.isWin())
            return -1;
        if(result.isDraw() && !cards.isBust())
            return 0;
        if(result.isLose() && playerCards.isBlackJack())
            return 1.5;
        return 1;
    }
}
