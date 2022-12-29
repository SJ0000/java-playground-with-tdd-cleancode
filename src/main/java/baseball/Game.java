package baseball;

import java.util.Random;

public class Game {

    private String number;

    public void start(){
        number = generateNumber();
        System.out.println(number);
    }

    private String generateNumber(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            sb.append(createRandomInt(1,9));
        }
        return sb.toString();
    }

    private int createRandomInt(int min, int max){
        return (int)(Math.random()*(max-min+1) + min);
    }
}
