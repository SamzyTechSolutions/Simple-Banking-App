import interfaces.AccountInterface;

/**
 * @author Samuel Rich Adiela
 */
public abstract class Account implements AccountInterface {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    /**
     * @param accountHolder
     * @param accountNumber
     * @param pin
     * @param startingDeposit
     */
    public Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = startingDeposit;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean validatePin(int attemptedPin) {
        return this.pin == attemptedPin;
    }

    @Override
    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean creditAccount(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean debitAccount(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public abstract String getAccountInfo();
}