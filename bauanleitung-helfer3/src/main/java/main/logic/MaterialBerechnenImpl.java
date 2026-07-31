package main.logic;

import main.entities.Rezeptposition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static main.dao.DBConnection.disconnect;
import static main.dao.DBConnection.getConnection;

public class MaterialBerechnenImpl implements MaterialBerechnen {

    private HashMap<String, Integer> getTotal_material_list() {
        return total_material_list;
    }
    private void setTotal_material_list(HashMap<String, Integer> total_material_list) {
        this.total_material_list = total_material_list;
    }
    private HashMap<String, Integer> getCurrent_material_list() {
        return current_material_list;
    }
    public void setEach_recipe_list_categorySet(List<Rezeptposition> each_recipe_list_categorySet) {
        this.each_recipe_list_categorySet = each_recipe_list_categorySet;
    }
    private List<Rezeptposition> getEach_recipe_list_categorySet() {
        return each_recipe_list_categorySet;
    }
    private void setEach_recipe_list_none_categorySet(List<Rezeptposition> each_recipe_list_none_categorySet) {
        this.each_recipe_list_none_categorySet = each_recipe_list_none_categorySet;
    }
    private List<Rezeptposition> getEach_recipe_list_none_categorySet() {
        return each_recipe_list_none_categorySet;
    }

    private HashMap<String, Integer> total_material_list;
    private final HashMap<String, Integer> current_material_list = new HashMap<>();

    private List<Rezeptposition> each_recipe_list_categorySet = new ArrayList<>();
    private List<Rezeptposition> each_recipe_list_none_categorySet = new ArrayList<>();

    @Override
    public HashMap<String, Integer> materialBerechnen(String getBauanleitung_name) {
        setEach_recipe_list_none_categorySet(getEach_recipe_list_categorySet());

        System.out.println(getEach_recipe_list_none_categorySet().get(2).getKom_name());
        System.out.println(getEach_recipe_list_none_categorySet().get(2).getRez_menge());
        for (var check_category = 0; check_category < getEach_recipe_list_none_categorySet().size(); check_category++) {

            // category not equal to Set
            if (!getEach_recipe_list_none_categorySet().get(check_category).getKom_kategorie().equals("Set")) {
                current_material_list.put(getEach_recipe_list_none_categorySet().get(check_category).getKom_name(),
                        getEach_recipe_list_none_categorySet().get(check_category).getRez_menge());
                continue;
            }

            // category equals Set
            sucheMaterial(getEach_recipe_list_none_categorySet().get(check_category).getKom_name());

            for (var check_category_of_set = 0; check_category_of_set < getEach_recipe_list_categorySet().size(); check_category++) {
                current_material_list.put(getEach_recipe_list_categorySet().get(check_category_of_set).getKom_name(),
                        getEach_recipe_list_categorySet().get(check_category_of_set).getRez_menge());
            }
        }

        setTotal_material_list(current_material_list);
        return getTotal_material_list();
    }

    @Override
    public List<Rezeptposition> sucheMaterial(String getBauanleitung_name) {
        String sql = "SELECT kom.id, kom.name, kom.kategorie, rez.menge " +
                    "FROM Rezeptposition rez " +
                    "INNER JOIN Bauanleitung bau " +
                    "ON rez.bauanleitung_id = bau.id " +
                    "INNER JOIN Komponent kom " +
                    "ON rez.komponente_id = kom.id " +
                    "WHERE bau.name LIKE ?";

        try {
            PreparedStatement preparedStmt = Objects.requireNonNull(getConnection()).prepareStatement(sql);
            preparedStmt.setString(1, getBauanleitung_name);

            ResultSet rs = preparedStmt.executeQuery();

            each_recipe_list_categorySet.clear();
            while (rs.next()) {
                each_recipe_list_categorySet.add(new Rezeptposition(getBauanleitung_name,
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4))
                );
            }
            return each_recipe_list_categorySet;

        } catch (SQLException e) {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        } finally {
            disconnect(getConnection());
        }

        return null;
    }
}
