package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    private List<Ball> ballList;

    public Balls(List<Integer> nums) {
        ballList = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            ballList.add(new Ball(i+1,nums.get(i)));
        }
    }

    public PlayResult play(Balls other){
        int strikeCount = count(other, PitchResult.STRIKE);
        int ballCount = count(other, PitchResult.BALL);
        return new PlayResult(ballCount,strikeCount);
    }

    private int count(Balls other, PitchResult result) {
        return (int) other.ballList.stream()
                .map(ball -> pitch(ball))
                .filter(r -> result == r)
                .count();
    }

    private PitchResult pitch(Ball other){
        Set<PitchResult> resultSet = ballList.stream()
                .map(ball -> ball.pitch(other))
                .collect(Collectors.toSet());

        if(resultSet.contains(PitchResult.STRIKE))
            return PitchResult.STRIKE;

        if(resultSet.contains(PitchResult.BALL))
            return PitchResult.BALL;

        return PitchResult.NOTHING;
    }
}
