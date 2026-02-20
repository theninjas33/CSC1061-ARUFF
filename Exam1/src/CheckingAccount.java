public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String name, int id, double balance, double overdraftLimit) {
        super(name, id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            setBalance(getBalance() - amount);
            getTransactions().add(new Transaction('W', amount, getBalance()));
        }
    }

    public String toString() {
        String summary =
            "Account Summary\n" +
            "Name: " + getName() +
            "\nID: " + getId() +
            "\nAnnual Interest Rate: " + getAnnualInterestRate() + "%" +
            "\nBalance: $" + getBalance() +
            "\nMonthly Interest: $" + getMonthlyInterest() +
            "\nTransactions:\n";

        for (Transaction t : getTransactions()) {
            summary += t + "\n";
        }

        return summary;
    }
}