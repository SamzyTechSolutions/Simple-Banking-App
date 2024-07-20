import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Rich Adiela
 */
public class CommercialAccountTest {
    private CommercialAccount commercialAccount;
    private Company company;
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        company = new Company("Samzy-Tech Solutions", 123456);
        commercialAccount = new CommercialAccount(company, 1L, 1234, 1000.0);
        person2 = new Person("Samuel", "Adiela", 10101);
        person1 = new Person("Blessing", "Adiela", 10001);
    }

    @Test
    public void testAddAuthorizedUser() {
        commercialAccount.addAuthorizedUser(person1);
        assertTrue(commercialAccount.isAuthorizedUser(person1));
    }

    @Test
    public void testIsAuthorizedUser() {
        commercialAccount.addAuthorizedUser(person1);
        assertTrue(commercialAccount.isAuthorizedUser(person1));
        assertFalse(commercialAccount.isAuthorizedUser(person2));
    }
}
