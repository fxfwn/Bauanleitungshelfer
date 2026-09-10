package main.logic;

import main.dao.BauanleitungSuchenInDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BauanleitungSuchenImpl implements BauanleitungSuchen
{
    private static final BauanleitungSuchenInDB dbSearch = new BauanleitungSuchenInDB();

    private final List<String> limitSearchResult = new ArrayList<>();

    @Override
    public List<String> suchanfrageStellen(String GUI_input_user)
    {
        return bauanleitungGefunden(dbSearch.sucheBauanleitungNameInDB(GUI_input_user + "%"));
    }

    @Override
    public List<String> bauanleitungFiltern(List<String> searchResult, String GUI_input_user)
    {
        limitSearchResult.clear();

        if (searchResult.size() != 1)
        {
            for (String recipe : searchResult)
            {
                if (recipe.contains(GUI_input_user))
                {
                    Objects.requireNonNull(limitSearchResult).add(recipe);
                }
            }
        }

        return bauanleitungGefunden(limitSearchResult);
    }

    @Override
    public List<String> bauanleitungGefunden(List<String> searchResult)
    {
        if (searchResult == null)
        {
            System.out.println("Keine Bauannleitung gefunden.");
            return null;
        }
        return searchResult;
    }
}
