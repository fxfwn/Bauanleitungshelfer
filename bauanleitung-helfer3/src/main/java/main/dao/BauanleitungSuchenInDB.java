package main.dao;

import main.entities.Bauanleitung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BauanleitungSuchenInDB
{

    private final ArrayList<String> gefundeneBauanleitungNamen = new ArrayList<>();

    public ArrayList<String> sucheBauanleitungInDB(String name)
    {
        String sql = "SELECT name FROM Bauanleitung WHERE name LIKE ?";

        try (Connection conn = DBConnection.getConnection())
        {

            PreparedStatement preparedStmt = Objects.requireNonNull(conn).prepareStatement(sql);
            preparedStmt.setString(1, name);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next())
            {
                gefundeneBauanleitungNamen.add(rs.getString("name"));
            }
            
            DBConnection.disconnect();
            return gefundeneBauanleitungNamen;
        }
        catch (SQLException e)
        {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        }

        DBConnection.disconnect();
        return null;
    }
}
