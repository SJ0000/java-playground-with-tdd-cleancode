package blackjack.domain;

import java.util.ArrayList;

abstract class AbstractParticipant implements Participant{

    protected Cards cards;
    protected String name;

    public AbstractParticipant(String name) {
        this.cards = new Cards();
        this.name = name;
    }

    @Override
    public void init(Deck deck) {
        for(int i=0;i<2;i++){
            Card card = deck.draw();
            cards.add(card);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return name + " 카드:" + cards;
    }

    @Override
    public int getPoint() {
        return cards.calculatePoint();
    }

    @Override
    public void hit(Card card) {
        cards.add(card);
    }
}
