package org.example.services;

import org.example.Game;
import org.example.Player;
import org.example.RidePair;
import org.example.interfaces.UserConnectorService;

import java.util.Optional;

public class BetInfoService {
    private final Player player;
    private final UserConnectorService userConnector;
    private final Game game;

    public BetInfoService(Player player, UserConnectorService userConnector, Game game) {
        this.player = player;
        this.userConnector = userConnector;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public UserConnectorService getUserConnector() {
        return userConnector;
    }

    public boolean makeBet() {
        if (player.getBalance() == 0) {
            userConnector.sendMessage("You don't have enough money to make a bet");
            return false;
        }
        RidePair chosenPair = userConnector.chooseRidePair(game.getRidePairs());
        int betAmount = 0;

        do {
            userConnector.showBalance(player.getBalance());
            betAmount = userConnector.getBetAmount();
        } while (betAmount > player.getBalance());

        Optional<RidePair> winPair = game.play();
        if (winPair.isPresent()) {
            RidePair winner = winPair.get();
            if (winner.equals(chosenPair)) {
                player.deposit(betAmount);
                userConnector.sendMessage("You have been WIN!!!!");
            } else {
                player.withdraw(betAmount);
                userConnector.sendMessage("You have been LOST!!! Win pair is " + winner);
            }
            userConnector.showBalance(player.getBalance());
        }
        return true;
    }

    public void startGame() {
        boolean isContinueGame = false;
        do {
            isContinueGame = makeBet();
        } while (isContinueGame);
    }
}
