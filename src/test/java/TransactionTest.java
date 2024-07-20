import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Rich Adiela
 */
public class TransactionTest {
    private Bank bank;
    private Transaction transaction;
    private Long accountNumber;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        Person person = new Person("Samuel", "Adiela", 10101);
        accountNumber = bank.openConsumerAccount(person, 1234, 1000.0);
        transaction = new Transaction(bank, accountNumber, 100.0);
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, transaction.getBalance());
    }

    @Test
    public void testCredit() {
        assertTrue(transaction.credit(200.0));
        assertEquals(1200.0, transaction.getBalance());
    }

    @Test
    public void testDebit() {
        assertTrue(transaction.debit(200.0));
        assertEquals(800.0, transaction.getBalance());
    }

    @Test
    public void testDebitInsufficientFunds() {
        assertFalse(transaction.debit(1200.0));
        assertEquals(1000.0, transaction.getBalance());
    }
}