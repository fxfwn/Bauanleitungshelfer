package main.logic;

import main.entities.Rezeptposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MaterialBerechnenImplTest {
    MaterialBerechnenImpl currectMaterial = new MaterialBerechnenImpl();

    HashMap<String, Integer> none_categorySet = new HashMap<>();

    Rezeptposition input_Not_0 = new Rezeptposition("bau", 116, "Feuerwehrauto", "Set", 2);
    Rezeptposition input_Not_1 = new Rezeptposition("bau", 117, "Polizeiauto", "Set", 2);
    Rezeptposition input_Not_2 = new Rezeptposition("bau", 106, "Garage", "Set", 1);
    Rezeptposition input_Not_3 = new Rezeptposition("bau", 124, "Minifigur", "Set", 6);

    List<Rezeptposition> input_Not = List.of(input_Not_0,input_Not_1, input_Not_2,input_Not_3);
    List<Rezeptposition> input_No = List.of(input_Not_0,input_Not_1, input_Not_2,input_Not_3);


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
    void inputNot_goodCase() {
        /* This method must be solved first
        *  List<Rezeptpos> != objArr */
        Object[] objArr = currectMaterial.sucheMaterial("Not%").toArray();
        Assertions.assertEquals(input_Not, objArr);
    }
}