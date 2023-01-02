package baseball;

public class PlayResult {
    public final int ball;
    public final int strike;

    public PlayResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isCompleted(){
        return this.strike == 3;
    }


    @Override
    public String toString() {
        return "PlayResult{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }
}
