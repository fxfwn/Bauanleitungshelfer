package main.logic;

import main.dao.BauanleitungSuchenInDB;

import java.util.List;

public class BauanleitungSuchenImpl implements BauanleitungSuchen
{
    private static BauanleitungSuchenInDB dao = new BauanleitungSuchenInDB();

    @Override
    public List<String> bauanleitungSuchen(String begriff)
    {
        List<String> ListBa = dao.sucheBauanleitungInDB(begriff);

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
