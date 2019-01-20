/**
* Makes an undergraduate Student
* @author Preston Knibbe
* @version 1
*/
public class UndergradStudent extends Student {
    public int hope = 100;
    public int pizza = 0;

    public UndergradStudent(String fname, String lname, String username) {
        super(fname, lname, username);
    }
    public int getHope() {
        return hope;
    }
    public void loseHope(int hopeLoss) {
        if (hopeLoss <= 0) {
            hope -= hopeLoss;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getPizza() {
        return pizza;
    }
    public void eatPizza(int pizzas) {
        if (pizzas >= 0) {
            pizza += pizzas;
        }
    }
}
