/**
 * @author Samuel Rich Adiela
 */
public abstract class AccountHolder {
    private int idNumber;

    /**
     * @param idNumber
     */
    public AccountHolder(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public abstract String getHolderInfo();
}