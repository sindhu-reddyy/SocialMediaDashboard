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

public class SignupPage extends VBox {

    public SignupPage(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40));
        setStyle("-fx-background-color: #f0f0f0;");

        Label title = new Label("Sign Up");
        title.setFont(new Font("Arial", 28));
        title.setTextFill(Color.DARKSLATEBLUE);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Choose a username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Create a password");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm password");

        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        Button signupButton = new Button("Register");
        signupButton.setPrefWidth(200);
        signupButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        Button backToLoginButton = new Button("Back to Login");
        backToLoginButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0000EE;");

        signupButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Please fill all fields.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                messageLabel.setText("Passwords do not match.");
                return;
            }

            String hashedPassword = hashPassword(password);

            try (Connection conn = DBUtil.getConnection()) {
                String checkSql = "SELECT * FROM users WHERE username = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    messageLabel.setText("Username already exists.");
                    return;
                }

                String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, username);
                insertStmt.setString(2, hashedPassword);
                insertStmt.executeUpdate();

                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Account created successfully!");
                Main.showLoginPage(stage);

            } catch (Exception ex) {
                messageLabel.setText("Database error: " + ex.getMessage());
            }
        });

        backToLoginButton.setOnAction(e -> Main.showLoginPage(stage));

        getChildren().addAll(title, usernameField, passwordField, confirmPasswordField,
                signupButton, messageLabel, backToLoginButton);
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
            return password; // fallback
        }
    }
}
