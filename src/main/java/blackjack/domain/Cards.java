package blackjack.domain;

import blackjack.domain.enums.Denomination;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private List<Card> cards;

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
        System.out.println("current = " + current);
        int point = current;
        for (int i = 0; i < aceCount; i++) {
            point = add10IfLOE21(point);
        }
        System.out.println("best = " + point);
        return point;
    }

    private int add10IfLOE21(int point) {
        if (point + 10 <= 21)
            return point + 10;
        return point;
    }
}
