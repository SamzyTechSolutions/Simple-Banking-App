/**
 * @author Samuel Rich Adiela
 */
public interface TransactionInterface {
    double getBalance();

    boolean credit(double amount);

    boolean debit(double amount);
}
