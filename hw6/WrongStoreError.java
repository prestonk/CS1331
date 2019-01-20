/**
 * Creates WrongStoreError
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public class WrongStoreError extends RuntimeException {
    private String message;
    /**
     * Creates WrongStoreError object
     * @param message error message
     */
    public WrongStoreError(String message) {
        super(message);
    }
}
