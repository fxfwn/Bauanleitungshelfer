package main.dao;

import java.sql.*;

public class CheckTables {
    public static void afterConnectCheckTables() {
        String url = "jdbc:sqlite:database/Bauanleitung.db";

        try (Connection conn = DriverManager.getConnection(url))
        {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                String[] types = {"TABLE"};
                ResultSet rs = meta.getTables(null, null, "%", types);

                System.out.println("Erstellte Tabelle:");
                while (rs.next())
                {
                    System.out.println(rs.getString("TABLE_NAME"));
                }
            }
            else
            {
                System.out.println("Tabelle existiert bereits oder ist nicht vorhanden.");
            }

        }
        catch (SQLException e)
        {
            System.out.println("Verbindung fehlgeschlagen: " + e.getMessage());
        }
    }
}