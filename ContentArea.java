import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class ContentArea extends StackPane {
    public ContentArea() {
        setStyle("-fx-background-color: #ecf0f1;");
    }

    public void setContent(Node node) {
        getChildren().clear();
        getChildren().add(node);
    }
}
