import java.sql.DriverManager;
import java.sql.SQLException;

public class BauanleitungVerwaltung {
    public static void connect() {
        String url = "jdbc:sqlite:database/Bauanleitung.db";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Verbindung zur SQLite-Datenbank war erfolgreich.");
            }

        } catch (SQLException e) {
            System.out.println("Verbindung fehlgeschlagen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}