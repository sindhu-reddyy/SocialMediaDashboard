// Sidebar.java
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sidebar extends VBox {
    public Sidebar(ContentArea contentArea, Stage stage) {
        setSpacing(15);
        setPadding(new Insets(20));
        setStyle("-fx-background-color: #2C3E50;");
        setPrefWidth(200);

        Button homeBtn = new Button("Home");
        Button messagesBtn = new Button("Messages");
        Button profileBtn = new Button("Profile");
        Button analyticsBtn = new Button("Analytics");
        Button settingsBtn = new Button("Settings");
        Button logoutBtn = new Button("Logout");

        homeBtn.setMaxWidth(Double.MAX_VALUE);
        messagesBtn.setMaxWidth(Double.MAX_VALUE);
        profileBtn.setMaxWidth(Double.MAX_VALUE);
        analyticsBtn.setMaxWidth(Double.MAX_VALUE);
        settingsBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setMaxWidth(Double.MAX_VALUE);

        getChildren().addAll(homeBtn, messagesBtn, profileBtn, analyticsBtn, settingsBtn, logoutBtn);

        // --- Updated Home Page Content ---
        homeBtn.setOnAction(e -> {
            VBox homePage = new VBox(15);
            homePage.setPadding(new Insets(20));
            homePage.setStyle("-fx-background-color: #ffffff;");

            Label title = new Label("\uD83C\uDFE0 Welcome to the Home Page!");
            title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333333;");

            Label welcomeMsg = new Label("\u2728 Explore new posts, follow your friends, and enjoy your feed.");
            welcomeMsg.setStyle("-fx-font-size: 16px; -fx-text-fill: #555555;");

            Button exploreBtn = new Button("\uD83D\uDD0D Explore Feed");
            exploreBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

            homePage.getChildren().addAll(title, welcomeMsg, exploreBtn);
            contentArea.setContent(homePage);
        });

        // --- Updated Messages Page Content ---
        messagesBtn.setOnAction(e -> {
            VBox messagesPage = new VBox(15);
            messagesPage.setPadding(new Insets(20));
            messagesPage.setStyle("-fx-background-color: #ffffff;");

            Label title = new Label("\uD83D\uDCAC Messages");
            title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333333;");

            Label msg1 = new Label("\uD83D\uDC64 Alice: Hey there! \uD83D\uDC4B");
            Label msg2 = new Label("\uD83D\uDC64 Bob: Let’s meet up tomorrow.");
            Label msg3 = new Label("\uD83D\uDC64 Charlie: Just posted a new pic!");

            for (Label msg : new Label[]{msg1, msg2, msg3}) {
                msg.setStyle("-fx-font-size: 16px; -fx-text-fill: #444;");
            }

            Button newMessageBtn = new Button("➕ New Message");
            newMessageBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");

            messagesPage.getChildren().addAll(title, msg1, msg2, msg3, newMessageBtn);
            contentArea.setContent(messagesPage);
        });

        profileBtn.setOnAction(e -> contentArea.setContent(new ProfilePage("TestUser")));
        analyticsBtn.setOnAction(e -> contentArea.setContent(new AnalyticsPage()));
        settingsBtn.setOnAction(e -> contentArea.setContent(new SettingsPage(stage)));
        logoutBtn.setOnAction(e -> Main.showLoginPage(stage));
    }
}
