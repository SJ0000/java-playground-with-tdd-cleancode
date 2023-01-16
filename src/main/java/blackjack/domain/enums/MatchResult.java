package blackjack.domain.enums;

public enum MatchResult {
    WIN,
    LOSE,
    DRAW;

    public boolean isWin(){
        return this == MatchResult.WIN;
    }

    public boolean isDraw(){
        return this == MatchResult.DRAW;
    }

    public boolean isLose(){
        return this == MatchResult.LOSE;
    }
}
