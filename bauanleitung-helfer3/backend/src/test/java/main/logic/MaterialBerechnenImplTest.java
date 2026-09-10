package main.logic;

import main.entities.Rezeptposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

class MaterialBerechnenImplTest {
    MaterialBerechnenImpl material_obj = new MaterialBerechnenImpl();

    LinkedHashMap<String, Integer> expect_material_List_Not = new LinkedHashMap<>() {{
        put("2x4 Stein Rot", 45); put("2x2 Stein Rot", 16); put("Rad Gross Schwarz", 20); put("Achse 4 Noppen", 10);
        put("Scheinwerfer 1x1 Gelb", 4); put("2x4 Stein Blau", 24); put("2x2 Stein Blau", 12);
        put("Rundstein 1x1 Transparent", 4); put("1x4 Stein Grau", 10); put("Tuer 1x4x6 Weiss", 1);
        put("Dachstein 2x2 Grau", 6); put("Minifigur Torso", 6); put("Minifigur Beine", 6); put("1x1 Stein Rot", 6);
    }};
    LinkedHashMap<String, Integer> expect_material_List_Not0 = new LinkedHashMap<>() {{
        put("2x4 Stein Rot", 15); put("2x2 Stein Rot", 8); put("Rad Gross Schwarz", 6); put("Achse 4 Noppen", 3);
        put("Scheinwerfer 1x1 Gelb", 2);
    }};
    LinkedHashMap<String, Integer> expect_material_List_Not1 = new LinkedHashMap<>() {{
        put("2x4 Stein Blau", 12); put("2x2 Stein Blau", 6); put("Rad Gross Schwarz", 4); put("Achse 4 Noppen", 2);
        put("Rundstein 1x1 Transparent", 2);
    }};
    LinkedHashMap<String, Integer> expect_material_List_Not2 = new LinkedHashMap<>() {{
        put("2x4 Stein Rot", 15); put("1x4 Stein Grau", 10); put("Tuer 1x4x6 Weiss", 1); put("Dachstein 2x2 Grau", 6);
    }};
    LinkedHashMap<String, Integer> expect_material_List_Not3 = new LinkedHashMap<>() {{
        put("Minifigur Torso", 1); put("Minifigur Beine", 1); put("1x1 Stein Rot", 1);
    }};

    Rezeptposition input_Not_0 = new Rezeptposition("Not%", 116, "Feuerwehrauto", "Set", 2);
    Rezeptposition input_Not_1 = new Rezeptposition("Not%", 117, "Polizeiauto", "Set", 2);
    Rezeptposition input_Not_2 = new Rezeptposition("Not%", 106, "Garage", "Set", 1);
    Rezeptposition input_Not_3 = new Rezeptposition("Not%", 124, "Minifigur", "Set", 6);
    List<Rezeptposition> input_Not = List.of(input_Not_0, input_Not_1, input_Not_2, input_Not_3);

    @Test
    void addAllMaterials_Single_construction_manual() {
        LinkedHashMap<String, Integer> actual_material_List = material_obj.materialBerechnen(input_Not.get(1).getKom_name());
        Assertions.assertEquals(expect_material_List_Not1, actual_material_List);
    }

    @Test
    void addAllMaterials_Multiple_construction_manual() {
        LinkedHashMap<String, Integer> actual_material_List = material_obj.materialBerechnen("Notd%");
        Assertions.assertEquals(expect_material_List_Not, actual_material_List);
    }

    @Test
    void compareContents() {
        List<Rezeptposition> objArr = material_obj.sucheMaterial("Not%");
        Assertions.assertEquals(input_Not_3.toString(), objArr.getLast().toString());
    }
}