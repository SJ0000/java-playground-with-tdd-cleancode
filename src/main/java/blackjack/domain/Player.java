package blackjack.domain;

public class Player extends  AbstractParticipant{

    private int betAmount;

    public Player(String name) {
        super(name);
    }

    public void bet(int amount){
        betAmount = amount;
    }

}
