import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends VBox {

    public LoginPage(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40));
        setStyle("-fx-background-color: #f2f2f2;");

        Label title = new Label("Login");
        title.setFont(new Font("Arial", 28));
        title.setTextFill(Color.DARKSLATEGRAY);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        TextField showPasswordField = new TextField();
        showPasswordField.setManaged(false);
        showPasswordField.setVisible(false);
        showPasswordField.managedProperty().bind(showPasswordField.visibleProperty());
        showPasswordField.visibleProperty().bind(passwordField.visibleProperty().not());

        showPasswordField.textProperty().bindBidirectional(passwordField.textProperty());

        CheckBox showPasswordCheckbox = new CheckBox("Show Password");
        showPasswordCheckbox.setOnAction(e -> {
            boolean show = showPasswordCheckbox.isSelected();
            passwordField.setVisible(!show);
            showPasswordField.setVisible(show);
        });

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(200);
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        Button signupButton = new Button("Don't have an account? Sign up");
        signupButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0000EE;");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String hashedPassword = hashPassword(password);

            try (Connection conn = DBUtil.getConnection()) {
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, hashedPassword);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    messageLabel.setTextFill(Color.GREEN);
                    messageLabel.setText("Login successful!");
                    Main.showDashboard(stage,username);
                } else {
                    messageLabel.setText("Incorrect username or password.");
                }

            } catch (Exception ex) {
                messageLabel.setText("Database error: " + ex.getMessage());
            }
        });

        signupButton.setOnAction(e -> Main.showSignupPage(stage));

        getChildren().addAll(title, usernameField, passwordField, showPasswordField, showPasswordCheckbox,
                loginButton, messageLabel, signupButton);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = sha.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return password; // fallback (not secure)
        }
    }
}
