import Entities.Bauanleitung;
import Logisch.UserService;
import dao.BauanleitungSuchenInDB;

import java.util.List;

public class BauanleitungVerwaltung implements UserService
{
    public static void main(String[] args) {
        //DBConnection.connect();
        //CheckTables.afterConnectCheckTables();

        UserService us = new BauanleitungVerwaltung();
        System.out.println(us.bauanleitungSuchen("Baum"));

    }

    private static BauanleitungSuchenInDB dao = new BauanleitungSuchenInDB();

    @Override
    public List<Bauanleitung> bauanleitungSuchen(String name)
    {
        List<Bauanleitung> ListBa = dao.sucheBauanleitungInDB(name);

        if (ListBa != null)
        {
            System.out.println("Bauanleitung gefunden: ");
            System.out.println(ListBa);
            return ListBa;
        }
        else
        {
            System.out.println("Keine Bauannleitung gefunden.");
            return null;
        }
    }
}