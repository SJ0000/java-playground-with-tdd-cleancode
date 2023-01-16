package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.domain.enums.Action;
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
        for (Player player : players) {
            play(player);
        }

        playDealer(dealer);
        OutputView.printGameResult(dealer,players);
    }

    private void addPlayers(String[] names){
        Arrays.stream(names)
                .forEach(name -> players.add(new Player(name)));
    }

    private void betPlayers() {
        for (Player player : players) {
            int amount = InputView.askBettingAmount(player.getName());
            player.bet(amount);
        }
    }

    private void init(){
        dealer.init(deck);
        for (Player player : players) {
            player.init(deck);
        }
    }


    private void play(Player player){
        Action action = InputView.askAction(player.getName());
        if(action.isHit()){
            player.hit(deck.draw());
            OutputView.printInfo(player);
            play(player);
            return;
        }
        OutputView.printInfo(player);
    }

    private void playDealer(Dealer dealer){
        while(dealer.canHit()){
            dealer.hit(deck.draw());
            OutputView.printDealerHit(dealer);
        }
    }
}
