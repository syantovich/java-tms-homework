package org.syantovich.main;

import org.syantovich.enums.Currency;
import org.syantovich.enums.Profession;

public class User {
    String name;
    Profession profession;
    int experience;
    Currency currency;

    public User(String name, Profession profession, int experience, Currency currency) {
        this.name = name;
        this.profession = profession;
        this.experience = experience;
        this.currency = currency;
    }

    public User(String name, Profession profession, int experience) {
        this(name, profession, experience, Currency.BYN);
    }

    public User(String name, Profession profession) {
        this(name, profession, 1);
    }

    public User(String name) {
        this(name, Profession.WORKER);
    }

    public double getSalaryPerMonth() {
        double salary = this.currency.multiplier * profession.salaryRate * experience;
        System.out.println(name + " salary = " + salary);
        return salary;
    }

    public double getSalaryWithBonus(double bonus) {
        double salaryWithBonus = this.getSalaryPerMonth() + bonus;
        System.out.println(name + " salary with bonus = " + salaryWithBonus);
        System.out.println();

        return salaryWithBonus;
    }
}
