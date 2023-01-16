package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.domain.enums.Action;
import blackjack.dto.Report;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackGame {

    Deck deck;
    Dealer dealer;
    List<Player> players;

    public BlackjackGame() {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.players = new ArrayList<>();
    }

    public void run() {
        addPlayers(InputView.getPlayerNames());
        betPlayers();
        init();
        players.forEach(this::play);
        playDealer();
        OutputView.printGameResult(dealer, players);
        OutputView.printProfitReport(getProfitReport());
    }

    private void addPlayers(String[] names) {
        Arrays.stream(names)
                .forEach(name -> players.add(new Player(name)));
    }

    private void betPlayers() {
        for (Player player : players) {
            int amount = InputView.askBettingAmount(player.getName());
            player.bet(amount);
        }
    }

    private void init() {
        dealer.init(deck);
        for (Player player : players) {
            player.init(deck);
        }
        OutputView.printInitInfo(dealer, players);
    }


    private void play(Player player) {
        Action action = InputView.askAction(player.getName());
        if (action.isHit()) {
            player.hit(deck.draw());
            OutputView.printInfo(player);
            play(player);
            return;
        }
        OutputView.printInfo(player);
    }

    private void playDealer() {
        while (dealer.canHit()) {
            dealer.hit(deck.draw());
            OutputView.printDealerHit(dealer);
        }
    }

    private List<Report> getProfitReport() {
        int dealerProfit = 0;
        List<Report> reports = new ArrayList<>();
        for (Player player : players) {
            int profit = (int) (player.getBetAmount() * dealer.getProfitRatio(player.getCards()));
            reports.add(new Report(player.getName(), profit));
            dealerProfit += (-1) * profit;
        }
        reports.add(0,new Report(dealer.getName(), dealerProfit));
        return reports;
    }
}
