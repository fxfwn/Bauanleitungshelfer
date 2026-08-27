package main.logic;

import main.entities.Rezeptposition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static main.dao.DBConnection.disconnect;
import static main.dao.DBConnection.getConnection;

public class MaterialBerechnenImpl implements MaterialBerechnen {

    public List<Rezeptposition> getDB_construction_manual() {
        return DB_construction_manual;
    }
    public LinkedHashMap<String, Integer> getMaterial_List() {
        return material_List;
    }
    private void setRecipeList_construction_manual(List<Rezeptposition> recipeList_construction_manual) {
        this.recipeList_construction_manual = recipeList_construction_manual;
    }
    public List<Rezeptposition> getRecipeList_construction_manual() {
        return recipeList_construction_manual;
    }
    private void setRecipeList_following_items_part_of_set(List<Rezeptposition> recipeList_following_items_part_of_set) {
        this.recipeList_following_items_part_of_set = recipeList_following_items_part_of_set;
    }
    public List<Rezeptposition> getRecipeList_following_items_part_of_set() {
        return recipeList_following_items_part_of_set;
    }

    private final List<Rezeptposition> DB_construction_manual = new ArrayList<>();

    private final LinkedHashMap<String, Integer> material_List = new LinkedHashMap<>();
    private List<Rezeptposition> recipeList_construction_manual = new ArrayList<>();
    private List<Rezeptposition> recipeList_following_items_part_of_set = new ArrayList<>();

    @Override
    public LinkedHashMap<String, Integer> materialBerechnen(String construction_manual)
    {
        setRecipeList_construction_manual(
                sucheMaterial(construction_manual)
        );

        int check_RecipePosition;
        for (check_RecipePosition = 0; check_RecipePosition < getRecipeList_construction_manual().size(); check_RecipePosition++)
        {
            Rezeptposition recipePosition_item = getRecipeList_construction_manual().get(check_RecipePosition);

            if (!recipePosition_item.getKom_kategorie().equals("Set"))
            {
                material_List.merge(
                        recipePosition_item.getKom_name(),
                        recipePosition_item.getRez_menge(),
                        Integer::sum
                );
                continue;
            }

            recipeList_following_items_part_of_set.add(recipePosition_item);
        }

        if (!getRecipeList_following_items_part_of_set().isEmpty())
        {
            for (int check_RecipePosition_Set = 0; check_RecipePosition_Set < getRecipeList_following_items_part_of_set().size(); check_RecipePosition_Set++)
            {
                setRecipeList_construction_manual(
                        sucheMaterial(getRecipeList_following_items_part_of_set().get(check_RecipePosition_Set).getKom_name())
                );

                for (check_RecipePosition = 0; check_RecipePosition < getRecipeList_construction_manual().size(); check_RecipePosition++)
                {
                    Rezeptposition recipePosition_item = getRecipeList_construction_manual().get(check_RecipePosition);

                    material_List.merge(
                            recipePosition_item.getKom_name(),
                            recipePosition_item.getRez_menge() *
                                    getRecipeList_following_items_part_of_set().get(check_RecipePosition_Set).getRez_menge(),
                            Integer::sum
                    );
                }
            }
        }

        return getMaterial_List();
    }

    @Override
    public List<Rezeptposition> sucheMaterial(String construction_manual) {
        String sql = "SELECT kom.id, kom.name, kom.kategorie, rez.menge " +
                    "FROM Rezeptposition rez " +
                    "INNER JOIN Bauanleitung bau " +
                    "ON rez.bauanleitung_id = bau.id " +
                    "INNER JOIN Komponent kom " +
                    "ON rez.komponente_id = kom.id " +
                    "WHERE bau.name LIKE ?";

        try {
            PreparedStatement preparedStmt = Objects.requireNonNull(getConnection()).prepareStatement(sql);
            preparedStmt.setString(1, construction_manual);

            ResultSet rs = preparedStmt.executeQuery();

            DB_construction_manual.clear();
            while (rs.next()) {
                DB_construction_manual.add(new Rezeptposition(construction_manual,
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4))
                );
            }
            return getDB_construction_manual();

        } catch (SQLException e) {
            System.out.println("Etwas hat nicht funktioniert: " + e.getMessage());
        } finally {
            disconnect(getConnection());
        }

        return null;
    }
}
