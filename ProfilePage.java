import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProfilePage extends VBox {

    private String username;

    public ProfilePage(String username) {
        this.username = username;
        setPadding(new Insets(20));
        setSpacing(10);

        Label heading = new Label("User Profile");
        heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label userLabel = new Label("Username:");
        TextField userField = new TextField(username);
        userField.setEditable(false);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField("user@example.com");

        Label bioLabel = new Label("Bio:");
        TextField bioField = new TextField("A brief bio...");

        getChildren().addAll(heading, userLabel, userField, emailLabel, emailField, bioLabel, bioField);
    }
}
