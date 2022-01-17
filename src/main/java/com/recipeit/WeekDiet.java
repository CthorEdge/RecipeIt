package com.recipeit;

import java.util.ArrayList;

public class WeekDiet {
    ArrayList<Recipe> recipeList = new ArrayList<>();
    ArrayList<Ingredient> reqIng = new ArrayList<>();

    public void addRecipe(String name, int portion, ArrayList<Recipe> recipeDB){
        for (Recipe r : recipeDB){
            if (r.getName().equals(name)){
                recipeList.add(r);
                r.setPortion(portion);
            }
        }
    }
    public void editRecipeQuantity(String recipeName, int sum){
        for (Recipe recipe : recipeList){
            if (recipe.getName().equals(recipeName)){
                recipe.setPortion(sum);
            }
        }
    }
    public void removeRecipe(String recipeName){
        for (Recipe recipe : recipeList){
            if (recipe.getName().equals(recipeName)){
                recipeList.remove(recipe);
            }
        }
    }
    public ArrayList<Ingredient> getReqIng (){
        boolean checkList;
        for (Recipe r : recipeList){
            for (int i=0; i<r.getPortion(); i++){
                for (Ingredient ing : r.getIngList()){
                    checkList = false;
                    for (Ingredient ingredient : reqIng) {
                        if (ingredient.getName().equals(ing.getName()) && ingredient.getType().equals(ing.getType())){
                            ingredient.addAmount(ing.getAmount());
                            checkList = true;
                        }
                    }
                    if (!checkList){
                        reqIng.add(new Ingredient(ing.getName(), ing.getAmount(), ing.getType()));
                    }
                }
            }
        }
        return reqIng;
    }
    public void clearWeekDiet (){
        recipeList.clear();
        reqIng.clear();
    }
}
