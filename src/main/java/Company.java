/**
 * @author Samuel Rich Adiela
 */
public class Company extends AccountHolder {
    private String companyName;
    private int taxId;

    public Company(String companyName, int taxId) {
        super(taxId);
        this.companyName = companyName;
        this.taxId = taxId;
    }

    @Override
    public String getHolderInfo() {
        return companyName + " (Tax ID: " + taxId + ")";
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTaxId() {
        return taxId;
    }
}