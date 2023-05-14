package Attribute;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private boolean isActive;

    public BankAccount(String accountNumber, String accountHolderName, double balance, boolean isActive) {
        setAccountNumber(accountNumber);
        setAccountHolderName(accountHolderName);
        setBalance(balance);
        setActive(isActive);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        String regex = "^[0-9]{9,18}$";
        if (accountNumber == null || !accountNumber.matches(regex))
            throw new IllegalArgumentException("Account number must be a 9-18 digit number");
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        String regex = "^[a-zA-Z\\s]*$";
        if (accountHolderName == null || !accountHolderName.matches(regex))
            throw new IllegalArgumentException("Account holder name must contain letters and spaces only");
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
