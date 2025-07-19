import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBTest {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/SocialMediaDashboard/user.db");
            System.out.println("✅ Connected to SQLite!");

            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT)");
            stmt.execute("INSERT INTO users VALUES ('testuser', 'testpass')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username") + ", Password: " + rs.getString("password"));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
