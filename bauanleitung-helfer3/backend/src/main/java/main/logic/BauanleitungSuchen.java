package main.logic;

import java.util.List;

public interface BauanleitungSuchen {
    List<String> suchanfrageStellen(String GUI_input_user);
    List<String> bauanleitungFiltern(List<String> searchResult, String GUI_input_user);
    List<String> bauanleitungGefunden(List<String> searchResult);
}
