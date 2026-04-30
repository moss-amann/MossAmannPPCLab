import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest2 {

    private bankaccount.BankAccount account;

    @BeforeEach
    void setUp() {
        // Starts each test with a fresh account of 100.0
        account = new bankaccount.BankAccount(100.0);
    }

    /** 1. Add an @AfterEach annotation and method to delete the
     * current bank account to make it available for garbage collection */
    @AfterEach
    void deleteCurrent(){
        account = null;
        System.gc();
    }


    @Test
    void testDeposit() {
        /** 2. Adeposit $50 and check that the balance is 150 */
        account.deposit(50.00);
        assertEquals(150.00, account.getBalance());
    }

    @Test
    void testWithdraw() {
        /** 3. withdraw $40 and check that the balance is $60; remember that each
         * test is done on a fresh instance of bank account */
        account.withdraw(40);
        assertEquals(60.00, account.getBalance());
    }

    @Test
    void testInvalidDeposit() {
        /** 4. Deposit a negative amount and check if an exception is thrown */
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.00);
        });
        String expectedMessage = "Deposit amount must be greater than zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void testOverdraft() {
        /** 5. Verify that Withdrawing more than the current balance
         throws an exception */
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(110.00);
        });
        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void testInvalidConstructor() {
        /** 6. Add a test to check that an Exception is thrown when
         trying to create a new bankaccout with a negaive initial balance */
        /**assertThrows(IllegalArgumentException.class, () -> {
         BankAccount invalidAccount = new BankAccount(-100.00);
         });
        BankAccount invalidAccount = new BankAccount(-100.00);**/
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankaccount.BankAccount invalidAccount = new bankaccount.BankAccount(-100.00);
        });
        String expectedMessage = "Initial balance cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testTransferAmountLessThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.transfer(-10.00);
        });
        String expectedMessage = "Transfer amount must be greater than zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInsufficientFundsForTransfer() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.transfer(110.00);
        });
        String expectedMessage = "Insufficient Funds";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}




