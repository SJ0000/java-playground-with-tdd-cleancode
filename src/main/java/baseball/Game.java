package baseball;

import java.util.Random;

public class Game {

    public void start() {
        String number = generateNumber();
        System.out.println(number);
    }

    private String generateNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(createRandomInt(1, 9));
        }
        return sb.toString();
    }

    private int createRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private Judgment judge(String input, String answer) {
        Judgment judgment = new Judgment(answer);

        for(int i=0;i<3;i++){
            judgment.pitch(i, input.charAt(i));
        }

        return judgment;
    }

    static class Judgment {
        private final String answer;
        private int strike;
        private int ball;

        public Judgment(String answer) {
            this.answer = answer;
            this.strike = 0;
            this.ball = 0;
        }

        public void pitch(int index, char num){
            if(isStrike(index,num)){
                strike++;
                return;
            }

            if(answer.contains(num + "")){
                ball++;
                return;
            }
        }

        private boolean isStrike(int index, char num) {
            return answer.charAt(index) == num;
        }

        private boolean isBall(char num){
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
}
