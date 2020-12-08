package com.example.baking4.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baking4.Adapter.StepsAdapter;
import com.example.baking4.Json.JsonUtils;
import com.example.baking4.Model.BakingModel;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;
import com.example.baking4.R;
import com.google.android.exoplayer2.ExoPlayer;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StepsFragment extends Fragment implements StepsAdapter.ListItemClickListener, ExoPlayer.EventListener {
    BakingModel bakingModel;
    IngredientModel ingredientModel;
    StepsModel stepsModel;
    private StepsAdapter SAdapter;
    private RecyclerView recyclerView;

    String tag2="nameS";
    int id1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_recycleview, container, false);

        StepsFragment.FechData_Steps fechData=new StepsFragment.FechData_Steps();
        fechData.execute();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.RV_Steps);
        Bundle bundle=new Bundle();
        if(getArguments() !=null) {

            // id1=Integer.parseInt(intent.getStringExtra("id"));
            id1=getArguments().getInt("id");
        }

        return rootView;
    }



    private StepsFragment getAction() {
        return StepsFragment.this;
    }

    @Override
    public void onClick(StepsModel model, int position) {

    }


    /*--------------*/
    public class FechData_Steps extends AsyncTask<URL, Void, String> {
        String data = "";
        String Tag2="xx2";
        String Tag3="xx3";
        FechData_Steps(){}

        @Override
        protected String doInBackground(URL... urls) {

            try {

                URL url = new URL("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }


            } catch (MalformedURLException e) {

                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }
            Log.d(Tag3,data);
            return data;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (data != null && !data.equals("")) {
                try {
                    JsonUtils jsonUtils=new  JsonUtils();
                    JSONArray json=  jsonUtils.parseJson(s);
                    bakingModel= jsonUtils.parseBakingModelJson(json);
                    ingredientModel= jsonUtils.parseIngredientModelJson(json,id1);
                    stepsModel= jsonUtils.parseStepsModelJson(json,id1);
                    Log.d(tag2,"%%%%%%%%"+id1);
                    GridLayoutManager layoutManager=new GridLayoutManager(getContext(),1);
                    Log.d(tag2,"#############"+ingredientModel.getIngredient());
                    Log.d(tag2,"###@@@@@@"+ingredientModel.getIngredient().get(0));
                    Log.d(tag2,"#############"+stepsModel.getDescription());
                    Log.d(tag2,"#############"+stepsModel.getDescription().get(0));

                    SharedPreferences sharedPreferences=getContext().getSharedPreferences("saveIngredints", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("QuantityWidget",ingredientModel.getQuantity().toString());
                    editor.putString("MeasureWidget",ingredientModel.getMeasure().toString());
                    editor.putString("IngredientWidget",ingredientModel.getIngredient().toString());
                    editor.apply();
                   // GridleRemoteViewFactory gridleRemoteViewFactory=new GridleRemoteViewFactory(getContext(),ingredientModel);
               //  Widget_Ingredient widgetIngredient=new Widget_Ingredient(ingredientModel);
//                    Log.d(tag2,"#############"+ingredientModel.getMeasure().get(0));
//                    Log.d(tag2,"#############"+bakingModel.getName().get(0));

                    SAdapter = new StepsAdapter( getAction(), stepsModel,getContext());
                    recyclerView.setAdapter(SAdapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                }catch (Exception e)
                {

                }
            }
        }
    }
}
