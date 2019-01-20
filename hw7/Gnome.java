/**
*  Creates Gnome card
*  @author Preston Knibbe
*  @version 1
*/
public class Gnome extends Card {
    private int Points;
    /**
    *  Constructs gnome object
    */
    public Gnome() {
        super("Gnome", "Adds a gnome to the count", "Worth 2 points",
            true, 2);

    }
    /**
    *  Gnomes version of the play method
    *  @param p game to be affected
    */
    public void play(PlasterClash p) {
        super.play(p);
        for (Player op: p.ops()) {
            op.discardRandom();
        }
    }
}
