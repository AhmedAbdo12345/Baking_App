package com.example.baking4.Model;

import java.util.ArrayList;

public class IngredientModel {

    private ArrayList<String> quantity;
    private ArrayList<String> measure;
    private ArrayList<String> ingredient ;

    public IngredientModel(){


    }

    public IngredientModel(ArrayList<String> quantity, ArrayList<String> measure, ArrayList<String> ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<String> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getMeasure() {
        return measure;
    }

    public void setMeasure(ArrayList<String> measure) {
        this.measure = measure;
    }

    public ArrayList<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(ArrayList<String> ingredient) {
        this.ingredient = ingredient;
    }
}
