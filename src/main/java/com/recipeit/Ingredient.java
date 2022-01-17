package com.recipeit;

public class Ingredient{
    private String name;
    private float amount;
    private Type type;

    public enum Type {
        GR, ML, O, SDT, SDM
    }

    public Ingredient (String name, float amount, Type type){
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public void addAmount(float additionalAmount){
        this.amount += additionalAmount;
    }

    public String getName (){
        return this.name;
    }
    public float getAmount() {
        return amount;
    }
    public Type getType(){
        return type;
    }

}
