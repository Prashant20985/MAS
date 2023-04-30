package Abstract_Polymorphic;

public class CheckingAccount extends Account{

    private double fee;

    public CheckingAccount(String accountNumber, double balance, double fee) {
        super(accountNumber, balance);
        setFee(fee);
    }

    public void deductFee() {
        withdraw(fee);
    }

    public double getFee() {
        return fee;
    }

    private void setFee(double fee) {
        if(fee < 0)
            throw new IllegalArgumentException("Fee cannot be less than zero");
        this.fee = fee;
    }

    @Override
    public double calcInterest() {
        return getBalance() * 0.01;
    }
}
