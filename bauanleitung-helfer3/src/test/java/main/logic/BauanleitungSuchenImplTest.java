package main.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BauanleitungSuchenImplTest {

    BauanleitungSuchenImpl testC = new BauanleitungSuchenImpl();

    List<String> db_Bauanleitung = List.of("Kleines Haus", "Baum", "Zaun", "Auto", "Turm", "Bruecke",
            "Garage", "Blumenbeet", "Laterne", "Bus", "Laden", "Bank", "Brunnen", "Strassenschild", "Fahrrad",
            "Parkbank", "Feuerwehrauto", "Polizeiauto", "Schule", "Rathaus", "Apartment", "Cafe", "Park Tor",
            "Bushaltestelle", "Minifigur", "Stadtszene", "Park Szene", "Notdienst Szene", "Wohnviertel Szene",
            "Stadtzentrum Szene");
    List<String> GUI_input_S = List.of("Strassenschild", "Schule", "Stadtszene", "Park Szene", "Notdienst Szene",
            "Wohnviertel Szene", "Stadtzentrum Szene");
    List<String> GUI_input_L = List.of("Laterne", "Laden");
    List<String> GUI_input_B = List.of("Baum", "Bruecke", "Blumenbeet", "Bus", "Bank",
            "Brunnen", "Bushaltestelle");
    List<String> result_filter_Bru = List.of("Bruecke", "Brunnen");

    List<String> result_filter_au_good = List.of("Kleines Haus", "Baum", "Zaun", "Feuerwehrauto",
            "Polizeiauto", "Rathaus");
    List<String> result_filter_au_bad = List.of("Kleines Haus", "Baum", "Zaun", "Auto", "Feuerwehrauto",
            "Polizeiauto", "Rathaus");
    List<String> result_filter_er = List.of("Laterne", "Feuerwehrauto", "Wohnviertel Szene");

    @Test
    void suchanfrage_WorstCase_Anfangbuchstaben()
    {
        List<String> input_user = testC.suchanfrageStellen("S");

        Assertions.assertEquals(GUI_input_S, input_user);
    }


    @Test
    void suchanfrage_GoodCase()
    {
        List<String> input_user = testC.suchanfrageStellen("L");

        Assertions.assertEquals(GUI_input_L, input_user);
    }

    @Test
    void filtern_Bru_Goodcase()
    {
        List<String> input_user = testC.bauanleitungFiltern(GUI_input_B,"Bru");

        Assertions.assertEquals(result_filter_Bru, input_user);
    }

    @Test
    void filtern_au_good()
    {
        List<String> input_user = testC.bauanleitungFiltern(db_Bauanleitung,"au");

        Assertions.assertEquals(result_filter_au_good, input_user);
    }

    @Test
    void filtern_au_wrongCase()
    {
        List<String> input_user = testC.bauanleitungFiltern(db_Bauanleitung,"au");

        Assertions.assertEquals(result_filter_au_bad, input_user);
    }


    @Test
    void filtern_er_goodCase()
    {
        List<String> input_user = testC.bauanleitungFiltern(db_Bauanleitung,"er");

        Assertions.assertEquals(result_filter_er, input_user);
    }
}