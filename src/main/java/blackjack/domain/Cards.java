package blackjack.domain;

import blackjack.domain.enums.Denomination;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int BLACKJACK_POINT = 21;

    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card){
        cards.add(card);
    }

    public int calculatePoint() {
        int point = getTotalPoint();
        int aceCount = getAceCount();
        return calculateBestPoint(point,aceCount);
    }

    public boolean isBlackJack(){
        return calculatePoint() == BLACKJACK_POINT;
    }

    private int getTotalPoint() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    private int getAceCount() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }

    private int calculateBestPoint(int current, int aceCount) {
        int point = current;
        for (int i = 0; i < aceCount; i++) {
            point = add10IfLOE21(point);
        }
        return point;
    }

    private int add10IfLOE21(int point) {
        if (point + 10 <= 21)
            return point + 10;
        return point;
    }

    public int size(){
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
