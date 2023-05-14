package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() throws Exception {
        bankAccount = new BankAccount("3216549871", "Prashant Sharma", 4500, true);
    }

    @Test
    public void setAccountNumber() {
        bankAccount.setAccountNumber("1223654987123");
        assertEquals("1223654987123", bankAccount.getAccountNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidAccountNumber() {
        bankAccount.setAccountNumber("12300");
    }

    @Test
    public void setAccountHolderName() {
        bankAccount.setAccountHolderName("qwer qwer");
        assertEquals("qwer qwer", bankAccount.getAccountHolderName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidAccountHolderName() {
        bankAccount.setAccountHolderName("qwe@#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidBalance() {
        bankAccount.setBalance(-200.33);
    }
}