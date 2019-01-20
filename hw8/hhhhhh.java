import javafx.application.Application;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Comparator;
/**
* Application used to check emails being sent by a Backend.
* @author Jason Kolbush
* @version 1
*/
public class MailReader extends Application implements Comparator<Message> {
    private Stage window;
    private Person me = new Person("Preston", "Jason", "jpkolbush2@gmail.com");
    private Mailbox inbox = new Mailbox("Inbox");
    private Mailbox important = new Mailbox("Important");
    private Mailbox trash = new Mailbox("Trash");
    private ListView<Message> previewList = new ListView<Message>();
    private ObservableList<Message> previewArray;
    private ObservableList<Message> importantArray;
    private ObservableList<Message> trashArray;
    private BorderPane border = new BorderPane();
    private Backend b = new Backend();
    private ToggleButton timeSortButton;
    private ToggleButton senderSortButton;
    private ToggleButton subjectSortButton;
    /**
    * Overrides the Compare method of Comparable
    * (It is required by the constructor for this to be Overriden)
    * (The proper compare methods are defined in annonamous inner classes)
    * @param m1 the first Message being compared
    * @param m2 the second Message being compared
    * @return 0
    */
    @Override
    public int compare(Message m1, Message m2) {
        return 0;
    }
    //Refreshes the inbox
    //sotrs it according to the specified sorter button
    private void refreshInbox() {
        previewArray = FXCollections.observableArrayList();
        for (Message m : inbox.getSet()) {
            previewArray.add(m);
        }
        if (timeSortButton.isSelected()) {
            Collections.sort(previewArray);
        } else if (senderSortButton.isSelected()) {
            Collections.sort(previewArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(previewArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        previewList.setItems(previewArray);
        border.setLeft(previewList);
    }
    //Refreshes the important mailbox
    //sotrs it according to the specified sorter button
    private void refreshImportant() {
        importantArray = FXCollections.observableArrayList();
        for (Message m : important.getSet()) {
            importantArray.add(m);
        }
        if (timeSortButton.isSelected()) {
            Collections.sort(importantArray);
        } else if (senderSortButton.isSelected()) {
            Collections.sort(importantArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(importantArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        previewList.setItems(importantArray);
        border.setLeft(previewList);
    }
    //Refreshes the trash mailbox
    //sotrs it according to the specified sorter button
    private void refreshTrash() {
        trashArray = FXCollections.observableArrayList();
        for (Message m : trash.getSet()) {
            trashArray.add(m);
        }
        if (timeSortButton.isSelected()) {
            Collections.sort(trashArray);
        } else if (senderSortButton.isSelected()) {
            Collections.sort(trashArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(trashArray, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        previewList.setItems(trashArray);
        border.setLeft(previewList);
    }
    //Gets a new random message from the Server
    //If Jason Kolbush is one of the recipients, it gets added to the inbox
    private void send() {
        Message m = b.send();
        if (m.getRecipients().contains(me)) {
            inbox.getSet().add(m);
        }
    }
    /**
    * Launches the application when MailReader is ran
    * Speciic details about the application are commented out throughout
    * @param primaryStage the Stage the application is run on.
    */
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Mail Reader");
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(5);
        VBox body = new VBox();
        body.setPadding(new Insets(10));

        //Section devoted to Defining the buttons
        Button b1 = new Button("Send Email");
        Button b2 = new Button("Refresh Inbox");
        Button b3 = new Button("Flag");
        Button b4 = new Button("Delete");
        final ToggleGroup mailboxes = new ToggleGroup();
        ToggleButton tb1 = new ToggleButton("Inbox");
        tb1.setToggleGroup(mailboxes);
        tb1.setSelected(true);
        ToggleButton tb2 = new ToggleButton("Important");
        tb2.setToggleGroup(mailboxes);
        ToggleButton tb3 = new ToggleButton("Trash");
        tb3.setToggleGroup(mailboxes);
        final ToggleGroup sorting = new ToggleGroup();
        timeSortButton = new ToggleButton("Time Sent");
        timeSortButton.setToggleGroup(sorting);
        timeSortButton.setSelected(true);
        senderSortButton = new ToggleButton("Sender");
        senderSortButton.setToggleGroup(sorting);
        subjectSortButton = new ToggleButton("Subject");
        subjectSortButton.setToggleGroup(sorting);
        topBox.getChildren().addAll(b2, b3, b4, new Text("Mailbox:"), tb1,
             tb2, tb3, new Text("Sort By:"), timeSortButton, senderSortButton,
            subjectSortButton);

        //Sets the action for the "Refresh Inbox button"
        //Everytime it is pressed, the inbox receives 0 to 5 new messages
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tb1.setSelected(true);
                send();
                send();
                send();
                send();
                send();
                refreshInbox();
            }
        });
        //Sets the action for the "Flag" button
        //Sends the sepcified email to Important
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Message m = previewList.getSelectionModel().getSelectedItem();
                important.add(m);
            }
        });
        //Sets the action for the "Delete" button
        //Sends the specified email to the Trash
        //Removes it from inbox and important (if in important)
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Message m = previewList.getSelectionModel().getSelectedItem();
                trash.add(m);
                if (tb1.isSelected()) {
                    inbox.remove(m);
                    refreshInbox();
                }
                if (tb2.isSelected()) {
                    inbox.remove(m);
                    important.remove(m);
                    refreshImportant();
                }
            }
        });
        //Sets the action for the "Inbox" Toggle button
        //Switches the the Inbox list
        tb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                refreshInbox();
            }
        });
        //Sets the action for the "Important" Toggle Button
        //Switches to the important list
        tb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                refreshImportant();
            }
        });
        //Sets the action of the "Trash" Toggle Button
        //Switches to the trash list
        tb3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                refreshTrash();
            }
        });
        //Refreshes the current mailbox to be sorted by time
        timeSortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refreshInbox();
                } else if (tb2.isSelected()) {
                    refreshImportant();
                } else {
                    refreshTrash();
                }
            }
        });
        //refreshes the current mailbox to be sorted by Sender
        senderSortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refreshInbox();
                } else if (tb2.isSelected()) {
                    refreshImportant();
                } else {
                    refreshTrash();
                }
            }
        });
        //Refreshes the Current Mailbox to be sorted by Subject
        subjectSortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refreshInbox();
                } else if (tb2.isSelected()) {
                    refreshImportant();
                } else {
                    refreshTrash();
                }
            }
        });
        //Gets the body of the email when an element in the list is clicked on
        previewList.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Message>() {
                public void changed(ObservableValue<? extends Message> ov,
                    Message oldM, Message m) {
                        body.getChildren().clear();
                        body.getChildren().add(new Text(m.toString()));
                        body.getChildren().add(new Text(m.getBody()));
                }
            }
        );
        border.setTop(topBox);
        border.setLeft(previewList);
        border.setCenter(body);
        Scene scene = new Scene(border, 700, 400);
        window.setScene(scene);
        window.show();
    }
}
