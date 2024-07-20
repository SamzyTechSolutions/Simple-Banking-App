import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author samuel
 */
public class ConsumerAccountTest {

    private Bank bank;
    private Person person;
    private Long accountNumber;
    private ConsumerAccount consumerAccount;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        person = new Person("Samuel", "Adiela", 1);
        accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        consumerAccount = (ConsumerAccount) bank.getAccount(accountNumber);
    }

    @Test
    public void testCreateConsumerAccount() {
        assertNotNull(consumerAccount);
        assertEquals(person, consumerAccount.getAccountHolder());
        assertEquals(accountNumber, consumerAccount.getAccountNumber());
        assertEquals(500.0, consumerAccount.getBalance(), 0.01);
    }

    @Test
    public void testCreditAccount() {
        consumerAccount.creditAccount(200.0);
        assertEquals(700.0, consumerAccount.getBalance(), 0.01);
    }

    @Test
    public void testDebitAccount() {
        boolean success = consumerAccount.debitAccount(150.0);
        assertTrue(success);
        assertEquals(350.0, consumerAccount.getBalance(), 0.01);
    }

    @Test
    public void testDebitAccountInsufficientFunds() {
        boolean success = consumerAccount.debitAccount(600.0);
        assertFalse(success);
        assertEquals(500.0, consumerAccount.getBalance(), 0.01);
    }

    @Test
    public void testValidatePin() {
        assertTrue(consumerAccount.validatePin(1234));
        assertFalse(consumerAccount.validatePin(4321));
    }
}

