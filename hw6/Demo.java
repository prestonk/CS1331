/**
 * This tests the code and allows users to interface with the store.
 *
 * @author Preston Knibbe
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Demo {
  /**
   * This runs the store code.
   *
   *
   */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to CheckoutMachine!");
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("Enter Store Name:");
        String storeName = input.nextLine();
        CheckoutMachine store = new CheckoutMachine(storeName);
        System.out.println("");
        System.out.println("Welcome to " + storeName + "!");
        System.out.println("");
        System.out.println("What would you like to buy?");
        System.out.println("");
        try {
            ArrayList<Item> inStock = Server.getValidItems();
            for (int i = 0; i < 5; i++) {
                System.out.println(inStock.get(i).getName()
                    + " $" + inStock.get(i).getPrice());
            }
            boolean check = true;
            while (check) {
                System.out.println("");
                System.out.println("Type name of item to add to cart.");
                System.out.println("Or type CHECKOUT to checkout");
                System.out.println("");
                String toBeAdded = input.nextLine();
                if (toBeAdded.equals("CHECKOUT")) {
                    System.out.println("");
                    System.out.println("Your total is: $"
                        + store.getTotalPrice() + ".");
                    System.out.println("");
                    boolean checker = true;
                    while (checker) {
                        System.out.println("How would you like to pay?");
                        System.out.println("(Cash, CreditCard, or BuzzCard)");
                        String payment = input.nextLine();
                        if (payment.equals("Cash")) {
                            System.out.println("How much do you want to pay?");
                            System.out.println("(include .00 if no change)");
                            Double mula = input.nextDouble();
                            Cash cash = new Cash(mula);
                            store.payForCart(cash);
                            checker = false;
                        }
                        if (payment.equals("CreditCard")) {
                            System.out.println("Enter the name on Card");
                            String name = input.nextLine();
                            System.out.println("Balance on card?");
                            Double mula = input.nextDouble();
                            System.out.println("Expiration month #");
                            int month = input.nextInt();
                            System.out.println("Expiration day");
                            int day = input.nextInt();
                            System.out.println("Expiration year");
                            int year = input.nextInt();
                            LocalDate date = LocalDate.of(year, month, day);
                            CreditCard cash = new CreditCard(name, mula, date);
                            store.payForCart(cash);
                            checker = false;
                        }
                        if (payment.equals("BuzzCard")) {
                            System.out.println("Enter the name on Card");
                            String name = input.nextLine();
                            System.out.println("Balance on card?");
                            Double mula = input.nextDouble();
                            BuzzCard cash = new BuzzCard(name, mula);
                            store.payForCart(cash);
                            checker = false;
                        }
                    }
                    System.out.println("Thank you come again!");
                    check = false;
                } else {
                    for (Item option : inStock) {
                        if (toBeAdded.equals(option.getName())) {
                            store.scan(option);
                        }
                    }
                }
            }
        } catch (CardExpiredException e) {
            System.out.print("");
        } catch (NotEnoughFundsException e) {
            System.out.print("Not enough Cash to pay for total amount.");
        } catch (InvalidItemException e) {
            System.out.print("Invalid item.");
        } catch (ServerException e) {
            System.out.print("Server Error");
        } catch (PaymentFailedException e) {
            System.out.print("Payment failed.");
        }

    }

}
