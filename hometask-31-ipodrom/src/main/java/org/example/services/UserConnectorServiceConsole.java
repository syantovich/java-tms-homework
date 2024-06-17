package org.example.services;

import org.example.RidePair;
import org.example.interfaces.UserConnectorService;

import java.util.List;
import java.util.Scanner;

public class UserConnectorServiceConsole implements UserConnectorService {
    @Override
    public int getDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        return scanner.nextInt();
    }

    @Override
    public int getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bet amount: ");
        return scanner.nextInt();
    }

    @Override
    public void showBalance(int balance) {
        System.out.println("Balance: " + balance);
    }

    @Override
    public int getPairNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pair number: ");
        return scanner.nextInt();
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("\n" + message + "\n");
    }

    @Override
    public RidePair chooseRidePair(List<RidePair> pairs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play pairs: ");
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(i + 1 + ") " + pairs.get(i));
        }
        int pairNumber = 0;
        do {
            System.out.println("Enter pair number: ");
            pairNumber = scanner.nextInt();
        } while (pairNumber > pairs.size());

        return pairs.get(pairNumber - 1);

    }
}
