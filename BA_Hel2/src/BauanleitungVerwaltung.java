import Entities.Bauanleitung;
import Logisch.UserService;
import dao.BauanleitungDAO;


public class BauanleitungVerwaltung implements UserService
{
    public static void main(String[] args) {
        //DBConnection.connect();
        //CheckTables.afterConnectCheckTables();

        //BauanleitungVerwaltung.bauanleitungSuchen("Baum");

    }

    private static BauanleitungDAO dao = new BauanleitungDAO();

    @Override
    public Bauanleitung bauanleitungSuchen(String name)
    {
        Bauanleitung ba = dao.sucheBauanleitungInDB(name);

        if (ba != null)
        {
            System.out.println("Bauanleitung gefunden: ");
            System.out.println(ba);
        }
        else
        {
            System.out.println("Keine Bauannleitung gefunden.");
        }
        return ba;
    }
}