/**
 * Creates BuzzCard object
 *
 * @author Preston Knibbe
 * @version 1.0
 */
public class BuzzCard extends Card {
    private String ownerName;
    private double balance;
    /**
     * Creates buzzcard object
     *
     * @param ownerName card owner name
     * @param balance amount on card
     */
    public BuzzCard(String ownerName, double balance) {
       super(ownerName, balance);
    }
}
