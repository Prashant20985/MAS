package Abstract_Polymorphic;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];
        accounts[0] = new SavingsAccount("12345", 10000, 2.5);
        accounts[1] = new CheckingAccount("67890", 5000, 10);

        for (Account a : accounts) {
            System.out.println("Account " + a.getAccountNumber() + " has a balance of " + a.getBalance());
            System.out.println("Interest earned on account " + a.getAccountNumber() + " is " + a.calcInterest());

            if (a instanceof CheckingAccount) {
                ((CheckingAccount) a).deductFee();
                System.out.println("Fee deducted from account " + a.getAccountNumber() + ". New balance is " + a.getBalance());
            }
            System.out.println();
        }
    }
}
