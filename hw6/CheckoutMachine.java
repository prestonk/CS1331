/**
 * Processes items and runs the main functionality of the store
 *
 * @author Preston Knibbe
 * @version 1.0
 */
import java.util.ArrayList;

public class CheckoutMachine {
    private String storeName;
    public ArrayList<Item> cart = new ArrayList<Item>();
    public ArrayList<Item> validItems;
    /**
     * Creates CheckoutMachine object
     *
     * @param storeName the store name
     */
    public CheckoutMachine(String storeName) {
        boolean check = false;
        while (!check) {
            try {
                if (!(Server.isStoreNameValid(storeName))) {
                    throw new WrongStoreError("Not a valid store name.");
                } else {
                    this.storeName = storeName;
                    check = true;
                }
            } catch (ServerException e) {
                System.out.println("Server Error - Please Try Again");
            }
        }
    }
    /**
     * Checks validity of item and adds to cart
     *
     * @param item item to be checked
     */
    public void scan(Item item) throws InvalidItemException {
        boolean check = true;
        int counter = 0;
        try {
            while (check) {
                validItems = Server.getValidItems();
                for (Item valid : validItems) {
                    if (valid.equals(item)) {
                        cart.add(valid);
                        System.out.println("Added to cart : "
                            + valid.getName() + " $" + valid.getPrice());
                        check = false;
                        counter += 1;
                    }
                }
            }
            if (counter == 0) {
                throw new InvalidItemException();
            }
        } catch (ServerException e) {
            System.out.print("");
        }

    }
    /**
     * Creates CheckoutMachine object
     *
     * @return total total price of cart
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (Item item: cart) {
            total += item.getPrice();
        }
        return total;
    }
    /**
     * Uses the paymentmethod to pay for items in cart
     *
     * @param method the method of payment
     */
    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        method.pay(getTotalPrice());
        cart.clear();
    }

}
