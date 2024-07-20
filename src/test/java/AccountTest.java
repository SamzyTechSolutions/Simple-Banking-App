import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Rich Adiela
 */
public class AccountTest {
    private Account account;
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("Samuel", "Adiela", 10101);
        account = new ConsumerAccount(person, 1L, 1234, 1000.0);
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void testValidatePin() {
        assertTrue(account.validatePin(1234));
        assertFalse(account.validatePin(5678));
    }

    @Test
    public void testCreditAccount() {
        assertTrue(account.creditAccount(200.0));
        assertEquals(1200.0, account.getBalance());
    }

    @Test
    public void testDebitAccount() {
        assertTrue(account.debitAccount(200.0));
        assertEquals(800.0, account.getBalance());
    }

    @Test
    public void testDebitAccountInsufficientFunds() {
        assertFalse(account.debitAccount(1200.0));
        assertEquals(1000.0, account.getBalance());
    }
}