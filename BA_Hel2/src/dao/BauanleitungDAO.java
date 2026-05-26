package dao;

import Entities.Bauanleitung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class BauanleitungDAO
{
    public Bauanleitung sucheBauanleitungInDB(String name)
    {
        String sql = "SELECT * FROM Bauanleitung WHERE name = ?";

        try (Connection conn = DBConnection.connect();
            PreparedStatement preparedStmt = Objects.requireNonNull(conn).prepareStatement(sql))
        {

            preparedStmt.setString(1, name);

            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next())
            {
                return new Bauanleitung(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        }
        catch (SQLException e)
        {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        }
        return null;
    }
}
