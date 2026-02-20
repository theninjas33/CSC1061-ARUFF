public class testBank {

    public static void main(String[] args) {

        CheckingAccount account =
                new CheckingAccount("George", 2222, 1000, 200);

        account.setAnnualInterestRate(1.5);

        account.deposit(30);
        account.deposit(40);
        account.deposit(50);

        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println(account);
    }
}