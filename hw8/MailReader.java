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
*  Email Reader Application
*  @author Preston Knibbe
*/
public class MailReader extends Application implements Comparator<Message> {
    private Stage window;
    private Person me = new Person("Preston", "preston@gmail.com");
    private Mailbox inbox = new Mailbox("Inbox");
    private Mailbox important = new Mailbox("Important");
    private Mailbox trash = new Mailbox("Trash");
    private ListView<Message> mainList;
    private ObservableList<Message> mainBox;
    private ObservableList<Message> importantBox;
    private ObservableList<Message> trashBox;
    private BorderPane border = new BorderPane();
    private ToggleButton sortTime;
    private ToggleButton sortSender;
    private ToggleButton sortSubject;
    private Server serv = new Server();

    public MailReader() {
        this.mainList =  new ListView<Message>();
    }

    public void refresh() {
        mainBox = FXCollections.observableArrayList();
        for (Message m : inbox.getBox()) {
            mainBox.add(m);
        }
        if (sortTime.isSelected()) {
            Collections.sort(mainBox);
        } else if (sortSender.isSelected()) {
            Collections.sort(mainBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(mainBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        mainList.setItems(mainBox);
        border.setLeft(mainList);
    }
    public void flag() {
        importantBox = FXCollections.observableArrayList();
        for (Message m : important.getBox()) {
            importantBox.add(m);
        }
        if (sortTime.isSelected()) {
            Collections.sort(importantBox);
        } else if (sortSender.isSelected()) {
            Collections.sort(importantBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(importantBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        mainList.setItems(importantBox);
        border.setLeft(mainList);
    }
    public void trash() {
        trashBox = FXCollections.observableArrayList();
        for (Message m : trash.getBox()) {
            trashBox.add(m);
        }
        if (sortTime.isSelected()) {
            Collections.sort(trashBox);
        } else if (sortSender.isSelected()) {
            Collections.sort(trashBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSender().compareTo(m2.getSender());
                }
            });
        } else {
            Collections.sort(trashBox, new Comparator<Message>() {
                @Override
                public int compare(Message m1, Message m2) {
                    return m1.getSubject().compareTo(m2.getSubject());
                }
            });
        }
        mainList.setItems(trashBox);
        border.setLeft(mainList);
    }
    @Override
    public int compare(Message m1, Message m2) {
        return 0;
    }
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
        sortTime = new ToggleButton("Time Sent");
        sortTime.setToggleGroup(sorting);
        sortTime.setSelected(true);
        sortSender = new ToggleButton("Sender");
        sortSender.setToggleGroup(sorting);
        sortSubject = new ToggleButton("Subject");
        sortSubject.setToggleGroup(sorting);
        topBox.getChildren().addAll(b2, b3, b4, new Text("Mailbox:"), tb1,
             tb2, tb3, new Text("Sort By:"), sortTime, sortSender,
            sortSubject);


        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tb1.setSelected(true);
                Message newMes = serv.getMessage();
                inbox.add(newMes);
                refresh();
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Message m = mainList.getSelectionModel().getSelectedItem();
                important.add(m);
            }
        });

        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Message m = mainList.getSelectionModel().getSelectedItem();
                trash.add(m);
                if (tb1.isSelected()) {
                    inbox.remove(m);
                    refresh();
                }
                if (tb2.isSelected()) {
                    inbox.remove(m);
                    important.remove(m);
                    flag();
                }
            }
        });

        tb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                refresh();
            }
        });

        tb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                flag();
            }
        });

        tb3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                trash();
            }
        });
        sortTime.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refresh();
                } else if (tb2.isSelected()) {
                    flag();
                } else {
                    trash();
                }
            }
        });
        sortSender.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refresh();
                } else if (tb2.isSelected()) {
                    flag();
                } else {
                    trash();
                }
            }
        });
        sortSubject.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (tb1.isSelected()) {
                    refresh();
                } else if (tb2.isSelected()) {
                    flag();
                } else {
                    trash();
                }
            }
        });
        mainList.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Message>() {
                public void changed(ObservableValue<? extends Message> ov,
                    Message oldM, Message m) {
                        body.getChildren().clear();
                        body.getChildren().add(new Text(m.toString()
                        ));
                        body.getChildren().add(new Text(m.getMessage()));
                }
            }
        );
        border.setTop(topBox);
        border.setLeft(mainList);
        border.setCenter(body);
        Scene scene = new Scene(border, 700, 400);
        window.setScene(scene);
        window.show();
}




}
