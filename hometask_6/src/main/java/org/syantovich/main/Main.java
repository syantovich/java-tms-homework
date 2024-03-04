package org.syantovich.main;

import org.syantovich.enums.Currency;
import org.syantovich.enums.Profession;

public class Main {
    public static void main(String[] args) {
        /* user1 - 3000 */
        User user1 = new User("Anton");

        // user2 - 6000
        User user2 = new User("Dima", Profession.HR, 4);

        // user3 - 100 000
        User user3 = new User("Aleksey", Profession.DIRECTOR, 10);

        // user4 - 4 598,7
        User user4 = new User("Inna", Profession.WORKER, 5, Currency.USD);

        // user5 - 10 000
        User user5 = new User("Alexander", Profession.DIRECTOR);


        user1.getSalaryWithBonus(1000);
        user2.getSalaryWithBonus(1000);
        user3.getSalaryWithBonus(1000);
        user4.getSalaryWithBonus(1000);
        user5.getSalaryWithBonus(1000);

    }
}
