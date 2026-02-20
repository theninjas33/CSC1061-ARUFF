public class SavingsAccount extends Account {

    private double minimumBalance;

    public SavingsAccount(String name, int id, double balance, double minimumBalance) {
        super(name, id, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= minimumBalance) {
            setBalance(getBalance() - amount);
            getTransactions().add(new Transaction('W', amount, getBalance()));
        }
    }

    public String toString() {
        return "Savings Account\n" +
               "Name: " + getName() +
               "\nID: " + getId() +
               "\nBalance: $" + getBalance() +
               "\nMonthly Interest: $" + getMonthlyInterest();
    }
}