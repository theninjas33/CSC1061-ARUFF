import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private char type;
    private double amount;
    private double balance;

    public Transaction(char type, double amount, double balance) {
        this.date = LocalDate.now();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public String toString() {
        return date +
               " | Type: " + type +
               " | Amount: $" + amount +
               " | Balance: $" + balance;
    }
}