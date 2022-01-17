package com.recipeit;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Postgres {
    private Connection connection;

    public Postgres(){
        try {
            final String jdbcURL = "jdbc:postgresql://localhost:5432/recipeit";
            final String username = "postgres";
            final String password = "";
            this.connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Successfully Connected to 'recipeit' Database\n");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed on Postgres!");
        }
    }

    public ArrayList<Recipe> reloadRecipe(){
        ArrayList<Recipe> recipeList = new ArrayList<>();
        String sql1 = "SELECT DISTINCT recipe_name FROM recipe";
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            while (rs1.next()) {
                String recipeName = rs1.getString("recipe_name");
                recipeList.add(new Recipe(recipeName));
            }

            String sql2 = "SELECT * FROM recipe";
            try{
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                while (rs2.next()){
                    String name = rs2.getString("ingredient");
                    float amount = rs2.getFloat("ingredient_amount");
                    for (Recipe recipe : recipeList){
                        if (rs2.getString("recipe_name").equals(recipe.getName())){
                            if (rs2.getString("units").equals("gr")){
                                recipe.addIngredient(name, amount, Ingredient.Type.GR);
                            }
                            else if (rs2.getString("units").equals("ml")){
                                recipe.addIngredient(name, amount, Ingredient.Type.ML);
                            }
                            else if (rs2.getString("units").equals("sdt")){
                                recipe.addIngredient(name, amount, Ingredient.Type.SDT);
                            }
                            else if (rs2.getString("units").equals("sdm")){
                                recipe.addIngredient(name, amount, Ingredient.Type.SDM);
                            }
                            else {
                                recipe.addIngredient(name, amount, Ingredient.Type.O);
                            }
                        }
                    }
                }
                return recipeList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void uploadRecipeIng(String recipeName, String ingName, float ingAmount, String type){
        String sql = "INSERT INTO recipe VALUES (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, recipeName);
            st.setString(2, ingName);
            st.setFloat(3, ingAmount);
            st.setString(4, type);
            int row = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<String> getRecipesName (ArrayList<Recipe> recipeDB){
        ArrayList<String> recipesName = new ArrayList<>();

        for (Recipe r : recipeDB){
            recipesName.add(r.getName());
        }
        return recipesName;
    }
}
