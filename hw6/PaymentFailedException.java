/**
 * Creates PaymentFailedException
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public class PaymentFailedException extends Exception {
    private String message;
    /**
     * Creates PaymentFailedException object
     *
     */
    public PaymentFailedException() {
        super();
    }
    /**
     * Creates PaymentFailedException object
     * @param message message of error
     */
    public PaymentFailedException(String message) {
        super(message);
    }
}
