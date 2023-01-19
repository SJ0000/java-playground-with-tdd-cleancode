package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Participant;
import blackjack.domain.Player;
import blackjack.dto.ParticipantDto;
import blackjack.dto.Report;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printInfo(ParticipantDto dto){
        System.out.println(dto.getInfo());
    }

    public static void printGameResult(List<ParticipantDto> dtos){
        dtos.forEach(dto -> {
            System.out.println(dto.getInfo() + " - 결과: " + dto.getPoint());
        });
    }

    public static void printDealerHit(ParticipantDto dealer){
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        printInfo(dealer);
    }

    public static void printProfitReport(List<Report> profitReport) {
        System.out.println("### 최종 수익");
        profitReport.forEach(System.out::println);
    }

    public static void printInitInfo(ParticipantDto dealer, List<ParticipantDto> players) {
        List<String> names = players.stream()
                .map(ParticipantDto::getName)
                .collect(Collectors.toList());
        System.out.println("딜러와 " + names + "에게 각각 2장의 카드를 나누었습니다.");
        printInfo(dealer);
        players.forEach(OutputView::printInfo);
    }
}
