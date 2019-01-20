/**
*  Custom lottery card that awards players 10 keebles
*  @author Preston Knibbe
*  @version 1
*/
public class Lottery extends Card {
    /**
    *  Constructs Lottery object
    */
    public Lottery() {
        super("Lottery", "Adds 10 Keebles", "You won the lottery!", false, 10);
    }
    /**
    *  Awards player with 10 keebles
    *  @param p current game
    */
    public void play(PlasterClash p) {
        super.play(p);
        playToPlayZone(p);
        p.addKeebles(10);
    }
}
