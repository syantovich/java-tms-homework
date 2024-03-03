import java.awt.*;

public class CreditCard {

    double balance;
    int cardNumber;
    String currency;

    public CreditCard (double defaultAmount, int cardNumber, String currency){
        this.cardNumber = cardNumber;
        this.balance = defaultAmount;
        this.currency = currency;
    }

    public CreditCard(double defaultAmount, int cardNumber){
        this(defaultAmount,cardNumber,"$");
    }

    public void addToBalance(double amount){
        this.balance = this.processBalance(this.balance + amount);
        this.printBalance();
    }

    public void withdrawMoney(double amount){
        if(amount <= this.balance){
            this.balance = this.processBalance(this.balance - amount);
        }
        this.printBalance();
    }

    public double getBalance(){
        return this.processBalance(this.balance);
    }

    public void printBalance(){
        System.out.println("Остаток карты - " + this.cardNumber + " - " + String.format("%.2f",this.getBalance()) + " " + this.currency);
    }
    public double processBalance(double amount){
        return (double) Math.round(amount * 100) / 100;
    }
}
