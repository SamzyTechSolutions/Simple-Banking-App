import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Rich Adiela
 */
public class BankTest {
    private Bank bank;
    private Person person;
    private Company company;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        person = new Person("Samuel", "Adiela", 10101);
        company = new Company("Samzy-Tech Solutions", 123456);
    }

    @Test
    public void testOpenConsumerAccount() {
        Long accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        assertNotNull(accountNumber);
        assertEquals(500.0, bank.getBalance(accountNumber));
    }

    @Test
    public void testOpenCommercialAccount() {
        Long accountNumber = bank.openCommercialAccount(company, 5678, 1000.0);
        assertNotNull(accountNumber);
        assertEquals(1000.0, bank.getBalance(accountNumber));
    }

    @Test
    public void testAuthenticateUser() {
        Long accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        assertTrue(bank.authenticateUser(accountNumber, 1234));
        assertFalse(bank.authenticateUser(accountNumber, 5678));
    }

    @Test
    public void testCreditAccount() {
        Long accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        assertTrue(bank.credit(accountNumber, 200.0));
        assertEquals(700.0, bank.getBalance(accountNumber));
    }

    @Test
    public void testDebitAccount() {
        Long accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        assertTrue(bank.debit(accountNumber, 200.0));
        assertEquals(300.0, bank.getBalance(accountNumber));
    }

    @Test
    public void testDebitAccountInsufficientFunds() {
        Long accountNumber = bank.openConsumerAccount(person, 1234, 500.0);
        assertFalse(bank.debit(accountNumber, 600.0));
        assertEquals(500.0, bank.getBalance(accountNumber));
    }
}