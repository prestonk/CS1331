/**
* Tree object
* @author Preston Knibbe
* @version 1
*/
public class Tree extends Zone {
    /**
    * Constructs tree object, has 9 keebles and 1 gnome
    */
    public Tree() {
        super();
        for (int i = 0; i < 9; i++) {
            Keeble keeb = new Keeble();
            this.add(keeb);
        }
        this.add(new Gnome());
    }
}
