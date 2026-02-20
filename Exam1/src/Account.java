import java.time.LocalDate;
import java.util.ArrayList;

public class Account {

    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private LocalDate dateCreated = LocalDate.now();
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    public String getName() { return name; }
    public LocalDate getDateCreated() { return dateCreated; }

    public void setId(int id) { this.id = id; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setAnnualInterestRate(double rate) { this.annualInterestRate = rate; }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction('D', amount, balance));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance));
        }
    }
}