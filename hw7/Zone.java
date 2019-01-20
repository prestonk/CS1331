import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;


/**
*  A zone
*  @author Preston Knibbe
*  @version 1
*/

public class Zone implements Iterable<Card> {
    private ArrayList<Card> zone;
    /**
    *  Constructs a zone
    */
    public Zone() {
        zone = new ArrayList<Card>();
    }
    /**
    *  adds card to zone
    *  @param c card to add
    */
    public void add(Card c) {
        zone.add(c);
    }
    /**
    *  Removes card from zone
    *  @param c card to be removed
    *  @return c returns card
    */
    public Card remove(Card c) {
        if (zone.contains(c)) {
            zone.remove(c);
        }
        return c;
    }
    /**
    *  Removes card from zone based on index
    *  @param idx index of card
    *  @return tempCard returns card
    */
    public Card remove(int idx) {
        Card tempCard = zone.get(idx);
        zone.remove(idx);
        return tempCard;
    }
    /**
    *  Gets string info from cards
    *  @return info string from cards
    */
    public String toString() {
        String info = "";
        for (int i = 0; i < zone.size(); i++) {
            info = info + i + " " + zone.get(i).toString() + "\n";
        }
        return info;
    }
    /**
    *  Shuffles cards
    */
    public void shuffle() {
        Collections.shuffle(zone);
    }
    /**
    *  Iterates through cards in zone
    *  @return iterator returns iterator
    */
    public Iterator<Card> iterator() {
        return zone.iterator();
    }
    /**
    *  Moves cards to zone
    *  @param z zone for cards to be moved to
    */
    public void moveCardsTo(Zone z) {
        for (int i = 0; i < zone.size(); i++) {
            Card c = zone.get(i);
            z.add(c);
            this.remove(c);
        }
    }
    /**
    *  Checks if list contains a certain card
    *  @param c card to be checked
    *  @return true or false based on if card is in list
    */
    public boolean contains(Card c) {
        return zone.contains(c);
    }
    /**
    *  @return the size of the list
    */
    public int size() {
        return zone.size();
    }
    /**
    *  @return card at the provided index
    *  @param idx the index where the card is located
    */
    public Card get(int idx) {
        return zone.get(idx);
    }
    /**
    *  @return counter number of Gnomes
    */
    public int numGnomes() {
        int counter = 0;
        for (int i = 0; i < zone.size(); i++) {
            if (zone.get(i) instanceof Card) {
                counter++;
            }
        }
        return counter;
    }
    /**
    *  dumps the cards in the zone
    *  @return tempCard the original list
    */
    public ArrayList<Card> discardAll() {
        ArrayList<Card> tempCard = zone;
        zone.clear();
        return tempCard;
    }



}
