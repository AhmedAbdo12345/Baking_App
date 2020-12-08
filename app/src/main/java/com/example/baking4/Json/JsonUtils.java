package com.example.baking4.Json;

import android.util.Log;

import com.example.baking4.Model.BakingModel;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
public static String tag="namek";
    public static JSONArray parseJson(String json) throws Exception {

        JSONArray baking_json;

        int id=0;
        String name = null;

        try {

            baking_json = new JSONArray(json);

        } catch (Exception ex) {

            throw ex;
        }

        return baking_json;

    }
    /*------------------read json----------------------*/
    public static BakingModel parseBakingModelJson(JSONArray baking) throws Exception {

        BakingModel s=null;


        ArrayList<Integer> id=new ArrayList<Integer>();
        ArrayList<String> name = new ArrayList<String>();

        try {

            for (int i = 0; i < baking.length(); i++) {
                JSONObject j = (JSONObject) baking.get(i);
                id.add(j.getInt("id"));
                name.add(j.getString("name"));

            }

            s = new BakingModel(id, name);


        } catch (Exception ex) {

            throw ex;
        }

        BakingModel Bake = new BakingModel();

        Bake.setBaking_id(id);
        Bake.setName(name);
        return Bake;
    }

    /*-------------Ingradint---------------*/
    public static IngredientModel parseIngredientModelJson(JSONArray baking,int Baking_ID) throws Exception {
        IngredientModel s=null;

        ArrayList<String> quantity1 = new ArrayList<>();
        ArrayList<String> measure1 = new ArrayList<>();
        ArrayList<String> ingredient1 = new ArrayList<>();


        try {


                JSONObject j = (JSONObject) baking.get(Baking_ID);
                JSONArray ingredients_JSONArray = j.getJSONArray("ingredients");
                for (int t = 0; t < ingredients_JSONArray.length(); t++) {
                    JSONObject jj = (JSONObject) ingredients_JSONArray.get(t);

                    quantity1.add(jj.getString("quantity"));
                    measure1.add(jj.getString("measure"));
                    ingredient1.add(jj.getString("ingredient"));
                }

//                JSONObject j = (JSONObject) baking.get(Baking_ID);
////
////                JSONArray ingredients_JSONArray = j.getJSONArray("ingredients");
////                for (int t = 0; t < ingredients_JSONArray.length(); t++) {
////                    JSONObject jj = (JSONObject) ingredients_JSONArray.get(t);
////
////                    quantity1.add(jj.getString("quantity"));
////                    measure1.add(jj.getString("measure"));
////                    ingredient1.add(jj.getString("ingredient"));


            s = new IngredientModel(quantity1, measure1, ingredient1);


        } catch (Exception ex) {

            throw ex;
        }

        IngredientModel ingredientModel = new IngredientModel();
        ingredientModel.setIngredient(ingredient1);
        ingredientModel.setMeasure(measure1);
        ingredientModel.setQuantity(quantity1);


        return ingredientModel;

    }
    /*----------------------steps--------------*/

    public static StepsModel parseStepsModelJson(JSONArray baking,int Baking_ID) throws Exception {
        StepsModel s=null;


        ArrayList<String> steps_id = new ArrayList<>();
        ArrayList<String> shortDescription1 = new ArrayList<>();
        ArrayList<String> description1 = new ArrayList<>();
        ArrayList<String> videoURL1 = new ArrayList<>();
        ArrayList<String> thumbnailURL1 = new ArrayList<>();

        try {

           // for (int i = 0; i < baking.length(); i++) {
                JSONObject j = (JSONObject) baking.get(Baking_ID);
            JSONArray steps_JSONArray = j.getJSONArray("steps");
            for (int t = 0; t < steps_JSONArray.length(); t++) {
                JSONObject jj = (JSONObject) steps_JSONArray.get(t);

                steps_id.add(jj.getString("id"));
                shortDescription1.add(jj.getString("shortDescription"));
                description1.add(jj.getString("description"));
                videoURL1.add(jj.getString("videoURL"));
                thumbnailURL1.add(jj.getString("thumbnailURL"));
         //   }

//                JSONObject j = (JSONObject) baking.get(Baking_ID);
//
//
//                JSONArray steps_JSONArray = j.getJSONArray("steps");
//                for (int t = 0; t < steps_JSONArray.length(); t++) {
//                    JSONObject jj = (JSONObject) steps_JSONArray.get(t);
//
//                    steps_id.add(jj.getString("id"));
//                    shortDescription1.add(jj.getString("shortDescription"));
//                    description1.add(jj.getString("description"));
//                    videoURL1.add(jj.getString("videoURL"));
//                    thumbnailURL1.add(jj.getString("thumbnailURL"));
                }





            s = new StepsModel(steps_id,shortDescription1,description1,videoURL1,thumbnailURL1);


        } catch (Exception ex) {

            throw ex;
        }


        StepsModel stepsModel = new StepsModel();


        stepsModel.setStepsID(steps_id);
        stepsModel.setShortDescription(shortDescription1);
        stepsModel.setDescription(description1);
        stepsModel.setVideoURL(videoURL1);
        stepsModel.setThumbnailURL(thumbnailURL1);

        return stepsModel;

    }
}
