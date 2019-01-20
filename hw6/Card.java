/**
 * Creates card object
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public abstract class Card implements PaymentMethod {
    protected String ownerName;
    protected double balance;
    /**
     * Creates card object
     *
     * @param ownerName card owner name
     * @param balance amount on card
     */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }
    /**
     * Pays via card
     *
     * @param amount price to be paid
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (balance - amount > 0 || balance - amount == 0) {
            balance -= amount;
        } else {
            throw new NotEnoughFundsException();
        }
    }
    /**
     * Returns balance
     *
     * @return balance amount on card
     */
    public double getBalance() {
        return balance;
    }
}
