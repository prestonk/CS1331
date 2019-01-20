/**
 * Creates CardExpiredException
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public class CardExpiredException extends PaymentFailedException {
    private String message;
    /**
     * Creates CardExpiredException object
     * @param message message of error
     */
    public CardExpiredException(String message)  {
        super(message);
        System.out.print(message);
    }
}
