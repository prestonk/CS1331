/**
 * Creates cash object
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public class Cash implements PaymentMethod {
    private double cashOnHand;
    /**
     * Creates cash object
     *
     * @param cashOnHand amount that total is subracted from
     */
    public Cash(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }
    /**
     * Pays using cash
     *
     * @param storeName the store name
     */
    @Override
    public void pay(double amount) throws NotEnoughFundsException {
        if (!(cashOnHand - amount > 0.00 || cashOnHand - amount == 0.00)) {
            throw new NotEnoughFundsException();
        } else {
            cashOnHand -= amount;
        }
    }
    /**
     * Returns cash on hand
     *
     * @param cashOnHand cash
     */
    public double getChange() {
        return cashOnHand;
    }


}
