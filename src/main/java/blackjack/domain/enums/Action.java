package blackjack.domain.enums;

public enum Action {
    HIT,
    STAY;

    public boolean isHit(){
        return this == Action.HIT;
    }
}
