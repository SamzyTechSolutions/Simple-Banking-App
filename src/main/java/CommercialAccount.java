import java.util.HashSet;
import java.util.Set;

/**
 * @author Samuel Rich Adiela
 */
public class CommercialAccount extends Account {
    private Company company;
    private Set<Person> authorizedUsers;

    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
        super(company, accountNumber, pin, startingDeposit);
        this.company = company;
        this.authorizedUsers = new HashSet<>();
    }

    public void addAuthorizedUser(Person person) {
        authorizedUsers.add(person);
    }

    public boolean isAuthorizedUser(Person person) {
        return authorizedUsers.contains(person);
    }

    @Override
    public String getAccountInfo() {
        return "Commercial Account - Company: " + company.getCompanyName();
    }

    public Company getCompany() {
        return company;
    }
}