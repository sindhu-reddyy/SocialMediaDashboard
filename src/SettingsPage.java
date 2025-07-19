import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsPage extends VBox {

    public SettingsPage(Stage stage) {
        setSpacing(15);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #f9f9f9;");

        Label title = new Label("⚙️ Settings Page");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label themeOption = new Label("Theme: Light 🌞 / Dark 🌙");
        Label notifications = new Label("Notifications: On 🔔 / Off 🔕");

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> Main.showLoginPage(stage));

        getChildren().addAll(title, themeOption, notifications, logoutButton);
    }
}
