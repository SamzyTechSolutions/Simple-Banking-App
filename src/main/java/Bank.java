import interfaces.BankInterface;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Samuel Rich Adiela
 */
public class Bank implements BankInterface {
    private Map<Long, Account> accounts = new LinkedHashMap<>();

    public Account getAccount(long accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accountNumber = generateAccountNumber();
        CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    @Override
    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accountNumber = generateAccountNumber();
        ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    @Override
    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        return account != null && account.validatePin(pin);
    }

    @Override
    public double getBalance(Long accountNumber) {
        Account account = accounts.get(accountNumber);
        return account != null ? account.getBalance() : 0;
    }

    @Override
    public boolean credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        return account != null && account.creditAccount(amount);
    }

    @Override
    public boolean debit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        return account != null && account.debitAccount(amount);
    }

    private Long generateAccountNumber() {
        return (long) (Math.random() * 1000000000L);
    }
}
