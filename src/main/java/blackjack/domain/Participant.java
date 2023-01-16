package blackjack.domain;

public interface Participant {
    String getName();

    String getInfo();

    int getPoint();

    void init(Deck deck);

    void hit(Card card);
}