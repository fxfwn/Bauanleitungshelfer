package main.dao;

import java.sql.*;

public class DBConnection
{
    private static final String URL = "jdbc:sqlite:database/Bauanleitung.db";
    private static Connection connection;

    // Verbindung aufbauen und in Variable speichern
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
                System.out.println("Verbindung erfolgreich aufgebaut!");
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Verbindungsaufbau: " + e.getMessage());
        }
        return connection;
    }

    // Verbindung schließen
    public static void disconnect(Connection currentConnection) {
        try {
            if (currentConnection != null && !currentConnection.isClosed()) {
                currentConnection.close();
                System.out.println("Verbindung geschlossen.");
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Schließen: " + e.getMessage());
        }
    }
}
