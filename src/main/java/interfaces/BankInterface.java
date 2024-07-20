package interfaces;

/**
 * @author Samuel Rich Adiela
 */
public interface BankInterface {
    Long openCommercialAccount(Company company, int pin, double startingDeposit);

    Long openConsumerAccount(Person person, int pin, double startingDeposit);

    boolean authenticateUser(Long accountNumber, int pin);

    double getBalance(Long accountNumber);

    boolean credit(Long accountNumber, double amount);

    boolean debit(Long accountNumber, double amount);
}
