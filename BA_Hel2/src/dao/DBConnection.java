package dao;

import java.sql.*;

public class DBConnection
{
    public static Connection connect()
    {
        String url = "jdbc:sqlite:database/Bauanleitung.db";

        try (Connection conn = DriverManager.getConnection(url))
        {
            if (conn != null)
            {
                System.out.println("Verbindung zur SQLite DB wurde hergestellt.");
            }
        }
        catch (SQLException e) {
            System.out.println("Fehler bei der DB-Verbindung wurde entdeckt: " + e.getMessage());
        }
        return null;
    }
}
