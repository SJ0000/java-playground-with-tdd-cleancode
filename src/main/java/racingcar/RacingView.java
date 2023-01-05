package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingView {

    Scanner sc = new Scanner(System.in);

    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public int askTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printCars(List<CarDto> cars){
        for (CarDto car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<CarDto> winners){
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0).getName());
        for(int i=1;i<winners.size();i++){
            sb.append(", ").append(winners.get(i).getName());
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
