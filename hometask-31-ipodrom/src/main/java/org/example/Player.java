package org.example;

import com.github.javafaker.Faker;

import javax.annotation.PostConstruct;

public class Player {
    private String name;
    private int balance;

    @PostConstruct
    public void postInit(){
        Faker faker = new Faker();
        name = faker.name().firstName();

        balance = 1000;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return  name + ", balance=" + balance + "]";
    }
}
