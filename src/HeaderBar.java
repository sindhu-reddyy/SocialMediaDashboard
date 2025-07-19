import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HeaderBar extends HBox {

    public HeaderBar(String username) {
        setPadding(new Insets(10));
        setSpacing(10);
        setStyle("-fx-background-color: #34495e; -fx-alignment: center-left;");

        Label title = new Label("Welcome, " + username);
        title.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");

        getChildren().add(title);
    }
}
