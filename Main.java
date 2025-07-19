import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showLoginPage(stage);
    }

    public static void showLoginPage(Stage stage) {
        Scene loginScene = new Scene(new LoginPage(stage), 400, 400);
        stage.setTitle("Login");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void showSignupPage(Stage stage) {
        Scene signupScene = new Scene(new SignupPage(stage), 400, 500);
        stage.setTitle("Sign Up");
        stage.setScene(signupScene);
        stage.show();
    }

    public static void showDashboard(Stage stage, String username) {
        BorderPane root = new BorderPane();
        ContentArea content = new ContentArea();
        Sidebar sidebar = new Sidebar(content, stage);
        HeaderBar headerBar = new HeaderBar(username);

        root.setTop(headerBar);
        root.setLeft(sidebar);
        root.setCenter(content);

        Scene dashboardScene = new Scene(root, 900, 600);
        stage.setTitle("Social Media Dashboard");
        stage.setScene(dashboardScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
