import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;


/**
*  Server that provides a random email
*  @author Preston Knibbe
*  @version 1
*/
public class Server {
    private Person[] people;
    private String[] subjList = {"Food delivery conformation",
        "Can I borrow your car?", "Party at my place tonight!"};
    private ArrayList<Person> recipList;

    public Message getMessage() {
        String body = "a;flkj;df;lj;hfoiwehnfdojvbnfuvjoivninvin\n"
                    + "a;flkj;df;lj;hfoiwehnfdojvbnfuvjoivninvin";
        LocalDateTime ldt = LocalDateTime.now();
        Random rand2 = new Random();
        int randInt2 = rand2.nextInt(3);
        String sub = subjList[randInt2];
        Person sender = this.randomPerson();
        recipList.remove(sender);
        return new Message(sender, recipList, sub, ldt, body);
    }
    public ArrayList<Person> getRecip() {
        recipList = new ArrayList<Person>(4);
        for (int i = 0; i < 3; i++) {
            recipList.add(people[i]);
        }
        return recipList;
    }
    public Person randomPerson() {
        Random rand1 = new Random();
        int randInt = rand1.nextInt(3);
        return people[randInt];
    }
    public Person[] makePeople() {
        people = new Person[4];
        people[0] = new Person("Bob", "bob@gmail.com");
        people[1] = new Person("Tim", "tim@gmail.com");
        people[2] = new Person("Jeff", "jeff@gmail.com");
        people[3] = new Person("Rick", "rick@gmail.com");
        return people;
    }
    public Server() {
        this.people = this.makePeople();
        this.recipList = this.getRecip();
    }
}
