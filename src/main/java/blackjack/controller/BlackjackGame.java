package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Participant;
import blackjack.domain.Player;
import blackjack.domain.enums.Action;
import blackjack.domain.state.Finished;
import blackjack.dto.ParticipantDto;
import blackjack.dto.Report;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGame {

    public void run() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck.drawTwoCards());
        List<Player> players = createPlayers(InputView.getPlayerNames(), deck);
        bet(players);
        showInitDealingInfo(dealer, players);
        players.forEach(player -> playManual(player, deck));
        playAuto(dealer, deck);
        showGameResult(dealer, players);
        OutputView.printProfitReport(getProfitReport(dealer, players));
    }

    private void showGameResult(Dealer dealer, List<Player> players) {
        OutputView.printGameResult(new ParticipantDto(dealer));
        players.forEach(player -> {
            OutputView.printGameResult(new ParticipantDto(player));
        });
    }

    private void showInitDealingInfo(Participant dealer, List<Player> players) {
        ParticipantDto dealerDto = new ParticipantDto(dealer);
        List<ParticipantDto> playerDtos = players.stream()
                .map(ParticipantDto::new)
                .collect(Collectors.toList());
        OutputView.printInitInfo(dealerDto, playerDtos);
    }

    private List<Player> createPlayers(String[] playerNames, Deck deck) {
        return Arrays.stream(playerNames)
                .map(name -> new Player(deck.drawTwoCards(), name))
                .collect(Collectors.toList());
    }

    private void bet(List<Player> players) {
        players.forEach(player -> {
            int amount = InputView.askBettingAmount(player.getName());
            player.bet(amount);
        });
    }

    private void playManual(Player player, Deck deck) {
        Action action = InputView.askAction(player.getName());
        if(!action.isHit()){
            player.stay();
            OutputView.printInfo(new ParticipantDto(player));
            return;
        }
        player.hit(deck.draw());
        OutputView.printInfo(new ParticipantDto(player));
        playManual(player, deck);
    }

    private void playAuto(Dealer dealer, Deck deck) {
        while (dealer.mustHit()) {
            dealer.hit(deck.draw());
            OutputView.printDealerHit(new ParticipantDto(dealer));
        }
        dealer.stay();
    }

    private List<Report> getProfitReport(Dealer dealer, List<Player> players) {
        int dealerProfit = 0;
        List<Report> reports = new ArrayList<>();
        for (Player player : players) {
            int profit = (int) (player.getBetAmount() * dealer.getEarningRate((Finished) player.getState()));
            reports.add(new Report(player.getName(), profit));
            dealerProfit += (-1) * profit;
        }
        reports.add(0, new Report(dealer.getName(), dealerProfit));
        return reports;
    }
}
