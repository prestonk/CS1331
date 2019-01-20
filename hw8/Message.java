import java.util.ArrayList;
import java.time.LocalDateTime;

/**
* a Message class
* @author Preston Knibbe
* @version 1
*/
public class Message implements Comparable<Message> {
    private Person sender;
    private ArrayList<Person> recipients;
    private String subject;
    private LocalDateTime date;
    private String message;
    /**
    * Constructs message
    * @param sender sender of email
    * @param recipients recievers of the email
    * @param date the date and time of email
    * @param subject subject of email
    * @param message the main text of the email
    */
    public Message(Person sender, ArrayList<Person> recipients,
        String subject, LocalDateTime date, String message) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.date = date;
        this.message = message;
    }
    /**
    *  @return sender returns sender of email
    */
    public Person getSender() {
        return sender;
    }
    /**
    *  @return recipients returns recipient list
    */
    public ArrayList<Person> getRecipients() {
        return recipients;
    }
    /**
    *  @return subject returns subject of email
    */
    public String getSubject() {
        return subject;
    }
    /**
    *  @return date returns date property of email
    */
    public LocalDateTime getDate() {
        return date;
    }
    /**
    *  @return message returns text of email
    */
    public String getMessage() {
        return message;
    }
    /**
    *  Compares messages by date
    *  @param mes the message to be compared with
    *  @return int that tells which should be sorted first
    */
    @Override
    public int compareTo(Message mes) {
        return -(this.date.compareTo(mes.date));
    }
    /**
    *  Compares messages on all of its elements to determine equality
    *  @param mes object to be compared with
    *  @return boolean of whether elements are equal or not
    */
    @Override
    public boolean equals(Object mes) {
        if (this == mes) {
            return true;
        } else if (mes == null || !(mes instanceof Message)) {
            return false;
        }
        Message that = (Message) mes;
        return this.sender.equals(that.sender)
            && this.recipients.equals(that.recipients)
            && this.subject.equals(that.subject)
            && this.date.equals(that.date)
            && this.message.equals(that.message);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + sender.hashCode();
        result = 31 * result + recipients.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return subject + " : " + sender.toString();
    }
}
