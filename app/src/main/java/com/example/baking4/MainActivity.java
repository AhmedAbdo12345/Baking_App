package com.example.baking4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.baking4.Adapter.BakingAdapter;
import com.example.baking4.Fragment.StepsFragment;
import com.example.baking4.Json.JsonUtils;
import com.example.baking4.Model.BakingModel;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements BakingAdapter.ListItemClickListener{
    private BakingAdapter bAdapter;
    private RecyclerView recyclerView;
    BakingModel bakingModel;
    IngredientModel ingredientModel;
    StepsModel stepsModel;
    //ingredients ingredientsModel;
    String tag2="namek";
    String tag1="ATRR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FechData fechData=new FechData();
        fechData.execute();
        recyclerView = (RecyclerView) findViewById(R.id.RV_Baking);


    }
    private MainActivity getAction() {
        return MainActivity.this;
    }




    @Override
    public void onClick(BakingModel model, int position) {
recyclerView.setVisibility(View.GONE);

        StepsFragment stepsFragment = new StepsFragment();

        Bundle bundle=new Bundle();
        bundle.putInt("id",bakingModel.getBaking_id().get(position));
        stepsFragment.setArguments(bundle);

getSupportFragmentManager().beginTransaction().replace(R.id.MainActivity, stepsFragment).commit();


        //getSupportFragmentManager().beginTransaction().commit();
//        Intent intent = new Intent(this, DetailsActivity.class);
//        startActivity(intent);


//        Intent intent = new Intent(this, DetailsActivity.class);
//        intent.putExtra("id" , bakingModel.getBaking_id().get(position));
//        intent.putExtra("name" ,bakingModel.getName().get(position));
//
//
//        intent.putExtra("Quantity" , ingredientModel.getQuantity().get(position));
//        intent.putExtra("Measure" ,ingredientModel.getMeasure().get(position));
//        intent.putExtra("Ingredient" , ingredientModel.getIngredient().get(position));
//
//        intent.putExtra("StepsID" ,stepsModel.getStepsID().get(position));
//        intent.putExtra("Description" ,stepsModel.getDescription().get(position));
//        intent.putExtra("ShortDescription" , stepsModel.getShortDescription().get(position));
//        intent.putExtra("VideoURL" , stepsModel.getVideoURL().get(position));
//        intent.putExtra("ThumbnailURL" ,stepsModel.getThumbnailURL().get(position));
//        startActivity(intent);

/*----------------------------------------------------*/
//        FechData fechData=new FechData();
//        String d=fechData.getDataFech();
//        fechData.onPostExecute(d);
        SharedPreferences sharedPreferences=getSharedPreferences("SaveFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("id",bakingModel.getBaking_id().get(position));

//        editor.putString("Quantity",ingredientModel.getQuantity().get(position));
//        editor.putString("Measure",ingredientModel.getMeasure().get(position));
//        editor.putString("Ingredient",ingredientModel.getIngredient().get(position));
        editor.apply();
    }


    /*-------------------------------------------------*/
    public class FechData extends AsyncTask<URL, Void, String> {
        String data = "";

        @Override
        protected String doInBackground(URL... urls) {
            try {

                URL url = new URL("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
                //   URL url = new URL(urlJson);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                //  Log.d(tag,data);

            } catch (MalformedURLException e) {

                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }

            return data;
        }
public String getDataFech(){
            return doInBackground();
}
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (data != null && !data.equals("")) {
                try {

                    JsonUtils jsonUtils=new  JsonUtils();
             JSONArray json=  jsonUtils.parseJson(s);
             bakingModel= jsonUtils.parseBakingModelJson(json);
             ingredientModel= jsonUtils.parseIngredientModelJson(json,bakingModel.getBaking_id().get(0));

            stepsModel= jsonUtils.parseStepsModelJson(json,bakingModel.getBaking_id().get(0));
                    //GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,1);
                    GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,1);
                    Log.d(tag2,"#############"+ingredientModel.getIngredient());
                    Log.d(tag2,"#############"+stepsModel.getShortDescription().get(0));
                    Log.d(tag2,"#############"+ingredientModel.getMeasure().get(0));
                    Log.d(tag2,"#############"+bakingModel.getName().get(0));

                    bAdapter = new BakingAdapter( getAction(), bakingModel);
                    recyclerView.setAdapter(bAdapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                }catch (Exception e)
                {

                }
            }
        }
    }
}
