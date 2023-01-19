package blackjack.domain;

public class Player extends AbstractParticipant {

    private final String name;
    private int betAmount;

    public Player(Cards cards, String name) {
        super(cards);
        this.name = name;
    }

    public void bet(int amount){
        this.betAmount = amount;
    }

    public int getBetAmount() {
        return betAmount;
    }

    @Override
    public String getName() {
        return name;
    }
}
