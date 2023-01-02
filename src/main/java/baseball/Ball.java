package baseball;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public PitchResult pitch(Ball other){
        if(isStrike(other))
            return PitchResult.STRIKE;
        if(isBall(other))
            return PitchResult.BALL;

        return PitchResult.NOTHING;
    }

    private boolean isStrike(Ball other) {
        return this.position == other.position && this.number == other.number;
    }

    private boolean isBall(Ball other) {
        return this.position != other.position && this.number == other.number;
    }
}
