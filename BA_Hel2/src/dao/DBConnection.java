package dao;

import java.sql.*;

public class DBConnection
{
    public static Connection connect()
    {
        try
        {
            Connection conn = DriverManager.getConnection(
                    BauanleitungSuchenInDB.getUrl());

            System.out.println("Verbindung zur SQLite DB wurde hergestellt.");
            return conn;
        }
        catch (SQLException e) {
            System.out.println("Fehler bei der DB-Verbindung wurde entdeckt: " + e.getMessage());
            return null;
        }
    }

    // Nur zum Testen
    public static void testConnection()
    {
        try (Connection conn = connect())
        {
            if (conn != null)
            {
                System.out.println("Test erfolgreich.");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
