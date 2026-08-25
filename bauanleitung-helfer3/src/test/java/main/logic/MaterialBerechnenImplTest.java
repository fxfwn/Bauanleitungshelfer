package main.logic;

import main.entities.Rezeptposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaterialBerechnenImplTest {
    MaterialBerechnenImpl currectMaterial = new MaterialBerechnenImpl();

    //HashMap<String, Integer> none_categorySet = new HashMap<>();

    Rezeptposition input_Not_0 = new Rezeptposition("Not%", 116, "Feuerwehrauto", "Set", 2);
    Rezeptposition input_Not_1 = new Rezeptposition("Not%", 117, "Polizeiauto", "Set", 2);
    Rezeptposition input_Not_2 = new Rezeptposition("Not%", 106, "Garage", "Set", 1);
    Rezeptposition input_Not_3 = new Rezeptposition("Not%", 124, "Minifigur", "Set", 6);

    @Test
    void input_none_Set() {
        /*
        none_categorySet.put("Dunkelblau", 24);
        none_categorySet.put("Schwarz", 28);
        none_categorySet.put("Weiß", 31);
        currectMaterial.setEach_recipe_list_categorySet(input_No);
        Assertions.assertEquals(none_categorySet, currectMaterial.materialBerechnen("Not%"));*/

    }

    @Test
    void input_Not_compareContents() {
        List<Rezeptposition> objArr = currectMaterial.sucheMaterial("Not%");
        Assertions.assertEquals(input_Not_3.toString(), objArr.getLast().toString());
    }
}