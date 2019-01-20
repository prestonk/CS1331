/**
*  Defines aspects of a card
*  @author Preston Knibbe
*  @version 1
*/
public abstract class Card {
    private String name;
    private String description;
    private String flavorText;
    private boolean gnome;
    private int keebCost;
    /**
    *  Constructs card object
    *  @param name Card name
    *  @param description describes card
    *  @param flavorText cards Flavor text
    *  @param gnome whether or not card is a gnome
    *  @param keebCost the keeble cost of a card
    */
    public Card(String name, String description, String flavorText,
        boolean gnome, int keebCost) {
        this.name = name;
        this.description = description;
        this.flavorText = flavorText;
        this.gnome = gnome;
        this.keebCost = keebCost;
    }
    /**
    *  Gets name
    *  @return name returns card name
    */
    public String getName() {
        return name;
    }
    /**
    *  Gets description
    *  @return description returns card description
    */
    public String getDescription() {
        return description;
    }
    /**
    *  Gets flavor text
    *  @return flavorText returns card flavor text
    */
    public String getText() {
        return flavorText;
    }
    /**
    *  Gets gnome type
    *  @return gnome returns whether or not card is a gnome
    */
    public boolean isScorable() {
        return gnome;
    }
    /**
    *  Gets the cards keeble cost
    *  @return keebCost returns cards keeble cost
    */
    public int getCost() {
        return keebCost;
    }
    /**
    *  plays a card in the game
    *  @param p the game to play the card in
    */
    public void play(PlasterClash p) {
        p.currentPlayer().getHand().remove(this);
    }
    /**
    *  Moves card into the "play" zone
    *  @param PlasterClash game to be used
    */
    public void playToPlayZone(PlasterClash p) {
        p.getPlayZone().add(this);
    }
    /**
    *  Maps card to correct list
    * @return hashcode for name of object
    */
    public int hashCode() {
        return name.hashCode();
    }
    /**
    * Lists out the details about the card
    * @return the details of the card
    */
    @Override
    public String toString() {
        return (this.getName() + " Cost: " + this.getCost());
    }

    /**
    *  Overwrites default equals function and tests if card names are
    *  equal.
    *  @param other the card object to be tested
    */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Card)) return false;
        return ((Card) other).name.equals(this.name);
    }
}
