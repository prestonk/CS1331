import java.util.HashSet;
import java.util.Set;

/**
*  Mailbox, holds mail
*  @author Preston Knibbe
*  @version 1
*/
public class Mailbox {
    private String name;
    private Set<Message> box;
    /**
    *  Contructs a mailbox
    *  @param name the title of the mailbox
    */
    public Mailbox(String name) {
        this.name = name;
        this.box = new HashSet<>();
    }
    /**
    *  @return box returns mail in mailbox
    */
    public Set<Message> getBox() {
        return box;
    }
    /**
    *  Adds message to box
    *  @param item message that will be added to box
    */
    public void add(Message item) {
        box.add(item);
    }
    /**
    *  Removes message from box
    *  @param item message that will be removed from box
    */
    public void remove(Message item) {
        box.remove(item);
    }
}
