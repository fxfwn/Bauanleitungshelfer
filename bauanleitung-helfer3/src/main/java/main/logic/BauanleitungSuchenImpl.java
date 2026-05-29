package main.logic;

import main.entities.Bauanleitung;
import main.dao.BauanleitungSuchenInDB;

import java.util.List;

public class BauanleitungSuchenImpl implements BauanleitungSuchen
{
    private static BauanleitungSuchenInDB dao = new BauanleitungSuchenInDB();

    @Override
    public List<Bauanleitung> bauanleitungSuchen(String name)
    {
        List<Bauanleitung> ListBa = dao.sucheBauanleitungInDB(name);

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
