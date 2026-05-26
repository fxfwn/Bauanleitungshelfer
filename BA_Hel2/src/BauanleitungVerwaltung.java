import Logisch.*;
import sqlTabellenErstellen.*;

import java.sql.*;


public class BauanleitungVerwaltung implements UserService
{
    public static void connect() {
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
                /*
                Statement stmt = conn.createStatement();
                for (TabelleErstellen te : TabelleErstellen.values())
                {
                    stmt.execute(te.sql);
                }

                System.out.println("Tabelle wurde erfolgreich erstellt.");*/
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

    public static void main(String[] args) {
        connect();
    }

    // Interface
    @Override
    public void bauanleitungSuchen(Bauanleitung ba)
    {
        /*
        User: Eingabe: Bauanleitung Name
        System: Suchanfrage senden
        DB: Datenbank durchsuchen
        DB: Bauanleitung liefern
        System: Bauanleitung anzeigen
        */
    }
}