package baseball;

import java.util.Scanner;

public class View {

    Scanner sc = new Scanner(System.in);

    public String inputNumber(){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    public void printResult(PlayResult result){
        System.out.println("결과 : " + result);
    }

    public void printComplete(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = sc.nextInt();
        return input == 1;
    }
}
