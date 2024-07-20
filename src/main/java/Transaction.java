import interfaces.TransactionInterface;

/**
 * @author Samuel Rich Adiela
 */
public class Transaction implements TransactionInterface {
    private Long accountNumber;
    private Bank bank;
    private double amount;

    public Transaction(Bank bank, Long accountNumber, double amount) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public double getBalance() {
        return bank.getBalance(accountNumber);
    }

    @Override
    public boolean credit(double amount) {
        return bank.credit(accountNumber, amount);
    }

    @Override
    public boolean debit(double amount) {
        return bank.debit(accountNumber, amount);
    }
}
