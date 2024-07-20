/**
 * @author Samuel Rich Adiela
 */
public class ConsumerAccount extends Account {
    private Person person;

    public ConsumerAccount(Person person, Long accountNumber, int pin, double startingDeposit) {
        super(person, accountNumber, pin, startingDeposit);
        this.person = person;
    }

    @Override
    public String getAccountInfo() {
        return "Consumer Account - Person: " + person.getFirstName() + " " + person.getLastName();
    }

    public Person getPerson() {
        return person;
    }
}