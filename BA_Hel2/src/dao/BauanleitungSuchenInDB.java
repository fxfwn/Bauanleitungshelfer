package dao;

import Entities.Bauanleitung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BauanleitungSuchenInDB
{
    private static final String url = "jdbc:sqlite:database/Bauanleitung.db";

    public static String getUrl() {
        return url;
    }

    private List<Bauanleitung> gefundeneBauanleitungen = new ArrayList<>();

    public List<Bauanleitung> sucheBauanleitungInDB(String name)
    {
        String sql = "SELECT id, name FROM Bauanleitung WHERE name = ?";

        try (Connection conn = DBConnection.connect())
        {
            if (conn == null) {
                return null;
            }

            PreparedStatement preparedStmt = Objects.requireNonNull(conn).prepareStatement(sql);
            preparedStmt.setString(1, name);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next())
            {
                gefundeneBauanleitungen.add(new Bauanleitung(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
            return gefundeneBauanleitungen;
        }
        catch (SQLException e)
        {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        }
        return null;
    }
}
