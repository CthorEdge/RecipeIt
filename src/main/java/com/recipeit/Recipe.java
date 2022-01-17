package com.recipeit;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingList = new ArrayList<>();
    private int portion;

    public Recipe (String name){
        this.name = name;
    }

    public void addIngredient (String name, float amount, Ingredient.Type substance){
        ingList.add(new Ingredient(name, amount, substance));
    }

    public void setPortion (int portion){
        this.portion = portion;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Ingredient> getIngList(){
        return ingList;
    }
    public int getPortion() {
        return portion;
    }
}
