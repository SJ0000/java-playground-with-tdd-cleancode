package baseball;

public class Judgment {

    private final String answer;
    private int strike;
    private int ball;

    private final int[][] ballTarget = new int[][]{{1,2},{0,2},{0,1}};

    public Judgment(String answer) {
        this.answer = answer;
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void pitch(int index, char num){
        if(isStrike(index,num)){
            strike++;
            return;
        }

        if(isBall(index,num)){
            ball++;
            return;
        }
    }

    public boolean isCompleted(){
        return strike==3;
    }

    private boolean isStrike(int index, char num) {
        return answer.charAt(index) == num;
    }

    private boolean isBall(int index, char num){
        // todo
        for(int i : ballTarget[index]){
            answer.charAt(i);
        }
        return answer.contains(num + "");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }
}
