
import Logisch.BauanleitungSuchenImpl;

public class BauanleitungVerwaltung
{
    public static void main(String[] args) {

        BauanleitungSuchenImpl dasKannNichtRichtigSein = new BauanleitungSuchenImpl();
        System.out.println(dasKannNichtRichtigSein.bauanleitungSuchen("Ba%"));

    }
}