package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.dto.Report;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void printProfitReport(List<Report> profitReport) {
        System.out.println("### 최종 수익");
        profitReport.forEach(System.out::println);
    }

    public static void printInitInfo(Dealer dealer, List<Player> players) {
        List<String> names = players.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());
        System.out.println("딜러와 " + names + "에게 각각 2장의 카드를 나누었습니다.");
        System.out.println(dealer.getInfo());
        players.forEach(p -> System.out.println(p.getInfo()));
    }
}
