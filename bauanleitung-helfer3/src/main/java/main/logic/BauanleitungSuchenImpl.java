package main.logic;

import main.entities.Bauanleitung;
import main.dao.BauanleitungSuchenInDB;

import java.util.ArrayList;
import java.util.List;

public class BauanleitungSuchenImpl implements BauanleitungSuchen
{
    private static BauanleitungSuchenInDB dao = new BauanleitungSuchenInDB();

    @Override
    public ArrayList<String> bauanleitungSuchen(String name)
    {
        ArrayList<String> ListBa = dao.sucheBauanleitungInDB(name);

        if (ListBa != null)
        {
            System.out.println("Bauanleitung gefunden: ");
            return ListBa;
        }
        else
        {
            System.out.println("Keine Bauannleitung gefunden.");
            return null;
        }
    }
}
