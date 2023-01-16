package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Player;

import java.util.List;

public class OutputView {

    public static void printInfo(Player player){
        System.out.println(player.getInfo());
    }

    public static void printGameResult(Dealer dealer, List<Player> players){
        System.out.println(dealer.getInfo() + " - 결과: " + dealer.getPoint() );
        for (Player player : players) {
            System.out.println(player.getInfo() + " - 결과: " + player.getPoint() );
        }
    }

    public static void printDealerHit(Dealer dealer){
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        System.out.println(dealer.getInfo());
    }

}
