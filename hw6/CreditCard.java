/**
 * Creates CreditCard object
 *
 * @author Preston Knibbe
 * @version 1.0
 */
import java.time.LocalDate;
public class CreditCard extends Card {
    private LocalDate expirationDate;
    /**
     * Creates card object
     *
     * @param ownerName card owner name
     * @param balance amount on card
     * @param expirationDate date of card expiration
     */
    public CreditCard(String ownerName, double balance,
        LocalDate expirationDate) {
        super(ownerName, balance);
        this.expirationDate = expirationDate;
    }
    /**
     * Pays via card
     *
     * @param amount price to be paid
     */
    @Override
    public void pay(double amount) throws CardExpiredException,
        NotEnoughFundsException {
        if (expirationDate.isAfter(LocalDate.now())) {
            if (balance - amount > 0 || balance - amount == 0) {
                balance -= amount;
            } else {
                throw new NotEnoughFundsException();
            }
        } else if (expirationDate.isBefore(LocalDate.now())) {
            throw new CardExpiredException("Card expired on "
                + expirationDate);
        }
    }

}
