package blackjack.domain.enums;

public enum Suit {
    SPADE("스페이드"),
    DIAMOND("다이아몬드"),
    HEART("하트"),
    CLOVER("클로버");

    final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
