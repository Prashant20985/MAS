package Abstract_Polymorphic;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(double interestRate) {
        if(interestRate < 0)
            throw new IllegalArgumentException("Interest Rate cannot be less than zero");

        this.interestRate = interestRate;
    }

    @Override
    public double calcInterest() {
        return getBalance() * (interestRate / 100);
    }
}
