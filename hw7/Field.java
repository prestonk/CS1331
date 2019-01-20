import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
* Field object
* @author Preston Knibbe
* @version 1
*/
public class Field {
    private final Map<Card, Integer> map;
    private Gnome gnome = new Gnome();
    private GardenBread bread = new GardenBread();
    /**
    * Constructs field object and establishes 10 gnomes and 1 garden bread
    */
    public Field() {
        map = new HashMap<Card, Integer>(2);
        map.put(gnome, 10);
        map.put(bread, 1);
    }
    /**
    * Subtracts a gnome if the card is a gnome
    * @param c The card to be bought
    */
    public void buyCard(Card c) {
        if (c instanceof Gnome) {
            int i = map.get(gnome);
            if (i > 0) {
                map.put(gnome, i - 1);
            }
        }
    }
    /**
    *  Makes a list of remaining cards
    * @return cards the list of remaining cards
    */
    public ArrayList<Card> cards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(bread);
        if (map.get(gnome) > 0) {
            cards.add(gnome);
        }
        return cards;
    }
}
