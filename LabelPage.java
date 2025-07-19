import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelPage extends StackPane {

    public LabelPage(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setStyle("-fx-text-fill: white;");

        setStyle("-fx-background-color: #2A2A3D;");
        setAlignment(Pos.CENTER);
        getChildren().add(label);
    }
}

