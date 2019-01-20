/**
 * Item class represents an item, having name, weight, price, and barcode.
 * @author Alex Epifano & Thomas Shields
 * @version 1.0
 */
public class Item {

    private String name;
    private double weight;
    private double price;
    private long barcode;

    /**
     * Creates a new item with the specified weight and barcode. Initializes
     * name as null and price as 0.0.
     * @param  weight  The weight in grams of the item.
     * @param  barcode The barcode of the item.
     */
    public Item(double weight, long barcode) {
        this(null, weight, 0.0, barcode);
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  weight  The weight of the item in grams.
     * @param  price   The price of the item in USD.
     * @param  barcode The barcode of the item.
     */
    public Item(String name, double weight, double price, long barcode) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.barcode = barcode;
    }
    /**
     * Returns name
     *
     * @return name name of item
     */
    public String getName() {
        return name;
    }
    /**
     * Returns price
     *
     * @return price the price of item
     */
    public double getPrice() {
        return price;
    }
    /**
     * checks if objects are equivalent
     *
     * @param other object to be tested
     */
    @Override
    public boolean equals(Object other) {
        return ((Item) other).weight == this.weight
            && ((Item) other).barcode == this.barcode;
    }
}
