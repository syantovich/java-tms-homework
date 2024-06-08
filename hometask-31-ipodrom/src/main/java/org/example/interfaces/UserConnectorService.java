package org.example.interfaces;

import org.example.RidePair;

import java.util.List;

public interface UserConnectorService {
    public int getDeposit();
    public int getBetAmount();
    public void showBalance(int balance);
    public int getPairNumber();
    public void sendMessage(String message);
    public RidePair chooseRidePair(List<RidePair> pairs);
}
