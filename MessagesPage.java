import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MessagesPage extends VBox {

    public MessagesPage() {
        setPadding(new Insets(20));
        setSpacing(10);

        Label heading = new Label("Messages");
        heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label msg1 = new Label("📨 Alice: Hey! How's your project going?");
        Label msg2 = new Label("📨 Bob: Are you free for a quick call?");
        Label msg3 = new Label("📨 Carol: Let's meet tomorrow for the review.");

        getChildren().addAll(heading, msg1, msg2, msg3);
    }
}
