package interfaces;

/**
 * @author Samuel Rich Adiela
 */
public interface AccountInterface {
    double getBalance();

    boolean validatePin(int attemptedPin);

    Long getAccountNumber();

    boolean creditAccount(double amount);

    boolean debitAccount(double amount);
}
