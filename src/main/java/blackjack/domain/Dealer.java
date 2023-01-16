package blackjack.domain;

public class Dealer extends AbstractParticipant {

    private static final int CAN_HIT_POINT = 16;

    public Dealer() {
        super("딜러");
    }

    public boolean canHit(){
        return getPoint() <= CAN_HIT_POINT;
    }
}
