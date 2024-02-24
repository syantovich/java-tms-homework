public class RunTask {
    public static void main(String[] args) {
        Cat myCat = new Cat("Том", 24);
        myCat.printAllCatInfo();

        myCat.changeName("Симба");
        myCat.printAllCatInfo();

        CreditCard card1 = new CreditCard(10.36, 1);
        CreditCard card2 = new CreditCard(100,2);
        CreditCard card3 = new CreditCard(1000,3);

        card1.addToBalance(100);
        card2.addToBalance(100);
        card3.withdrawMoney(10001);
        card3.withdrawMoney(1000);
        card1.addToBalance(1);
        card1.withdrawMoney(1000000);
        card1.withdrawMoney(10.1);
    }
}
