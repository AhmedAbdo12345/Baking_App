package com.example.baking4.Widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

public class MyWidgetRemoteViewsService extends RemoteViewsService {
    SharedPreferences sharedPreferences;

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
//        SharedPreferences sharedPreferences = getSharedPreferences("saveIngredints", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        String Quantity = sharedPreferences.getString("QuantityWidget", "");
//        String Measure = sharedPreferences.getString("MeasureWidget", "");
//        String Ingredient = sharedPreferences.getString("IngredientWidget", "");
//
//        String[] itemQuantity = Quantity.split(",");
//        String[] itemMeasure = Measure.split(",");
//        String[] itemIngredient = Ingredient.split(",");
//
//     ArrayList<String> arrayListQuantity = new ArrayList<>();
//        for (int i = 0; i < itemQuantity.length; i++) {
//            arrayListQuantity.add(itemQuantity[i]);
//        }
//        ArrayList<String>   arrayListMeasure = new ArrayList<>();
//        for (int i = 0; i < itemMeasure.length; i++) {
//            arrayListMeasure.add(itemMeasure[i]);
//        }
//        ArrayList<String>    arrayListIngredient = new ArrayList<>();
//        for (int i = 0; i < itemIngredient.length; i++) {
//            arrayListIngredient.add(itemIngredient[i]);
//        }
//        return  new RemoteListViewService(arrayListQuantity,arrayListMeasure,arrayListIngredient,getApplicationContext());
        return  new RemoteListViewService(getApplicationContext());
    }
}