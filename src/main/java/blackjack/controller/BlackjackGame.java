package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Participant;
import blackjack.domain.Player;
import blackjack.domain.enums.Action;
import blackjack.dto.ParticipantDto;
import blackjack.dto.Report;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackjackGame {
//
//    public void run() {
//        Participant dealer = new Dealer();
//        List<Player> players = createPlayers(InputView.getPlayerNames());
//        bet(players);
//        init(dealer, players);
//        players.forEach(this::play);
//        playDealer();
//        List<ParticipantDto> participants = Stream.concat(Stream.of(dealer), players.stream())
//                .map(ParticipantDto::new)
//                .collect(Collectors.toList());
//        OutputView.printGameResult(participants);
//        OutputView.printProfitReport(getProfitReport());
//    }
//
//    private List<Player> createPlayers(String[] playerNames) {
//        return Arrays.stream(playerNames)
//                .map(Player::new)
//                .collect(Collectors.toList());
//    }
//
//    private void bet(List<Player> players) {
//        players.forEach(player->{
//            int amount = InputView.askBettingAmount(player.getName());
//            player.bet(amount);
//        });
//    }
//
//    private void init(Participant dealer, List<Participant> players) {
//        dealer.drawDefaultCards(deck);
//        for (Player player : players) {
//            player.drawDefaultCards(deck);
//        }
//        OutputView.printInitInfo(dealer, players);
//    }
//
//
//    private void play(Player player) {
//        Action action = InputView.askAction(player.getName());
//        if (action.isHit()) {
//            player.hit(deck.draw());
//            OutputView.printInfo(player);
//            play(player);
//            return;
//        }
//        OutputView.printInfo(player);
//    }
//
//    private void playDealer() {
//        while (dealer.canHit()) {
//            dealer.hit(deck.draw());
//            OutputView.printDealerHit(dealer);
//        }
//    }
//
//    private List<Report> getProfitReport() {
//        int dealerProfit = 0;
//        List<Report> reports = new ArrayList<>();
//        for (Player player : players) {
//            int profit = (int) (player.getBetAmount() * dealer.getProfitRatio(player.getCards()));
//            reports.add(new Report(player.getName(), profit));
//            dealerProfit += (-1) * profit;
//        }
//        reports.add(0,new Report(dealer.getName(), dealerProfit));
//        return reports;
//    }
}
