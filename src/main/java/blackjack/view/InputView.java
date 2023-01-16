package blackjack.view;

import blackjack.domain.enums.Action;

import java.util.Scanner;

public class InputView {

    public static Scanner sc = new Scanner(System.in);

    public static String[] getPlayerNames(){
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return sc.nextLine().split(",");
    }

    public static int askBettingAmount(String playerName){
        System.out.println(playerName + "의 베팅 금액은?");
        return Integer.parseInt(sc.nextLine());
    }

    public static Action askAction(String playerName){
        System.out.println(playerName+"은(는) 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String input = sc.nextLine();
        System.out.println("input = " + input);
        if(input.equals("y"))
            return Action.HIT;
        if(input.equals("n"))
            return Action.STAY;

        throw new RuntimeException("입력은 \"y\"와 \"n\" 만 허용합니다.");
    }
}
