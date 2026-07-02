package main.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.dao.DBConnection.getConnection;
import static main.dao.DBConnection.disconnect;


public class BauanleitungSuchenInDB
{

    private final ArrayList<String> gefundeneBauanleitungNamen = new ArrayList<>();

    public ArrayList<String> sucheBauanleitungInDB(String begriff)
    {
        String sql = "SELECT name FROM Bauanleitung WHERE name LIKE ?";

        try
        {
            PreparedStatement preparedStmt = Objects.requireNonNull(getConnection()).prepareStatement(sql);
            preparedStmt.setString(1, begriff);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next())
            {
                gefundeneBauanleitungNamen.add(rs.getString("name"));
            }

            disconnect(getConnection());
            return gefundeneBauanleitungNamen;
        }
        catch (SQLException e)
        {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        }

        return null;
    }
}
