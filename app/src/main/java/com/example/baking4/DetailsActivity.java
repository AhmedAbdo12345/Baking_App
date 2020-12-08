package com.example.baking4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.baking4.Adapter.StepsAdapter;
import com.example.baking4.Fragment.StepsFragment;
import com.example.baking4.Fragment.VedioFragment;
import com.example.baking4.Json.JsonUtils;
import com.example.baking4.Model.BakingModel;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;
import com.example.baking4.Widget.BakingWidget;
import com.google.android.exoplayer2.ExoPlayer;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

//public class DetailsActivity extends AppCompatActivity implements StepsAdapter.ListItemClickListener, ExoPlayer.EventListener{

public class DetailsActivity extends AppCompatActivity {
    BakingModel bakingModel;
    IngredientModel ingredientModel;
    StepsModel stepsModel;
    private StepsAdapter SAdapter;
    private RecyclerView recyclerView;

String tag2="nameS";
    int id1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        StepsFragment stepsFragment = new StepsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                    .add(R.id.Steps_container_fragment, stepsFragment)
                    .commit();
        /*---------------------------------------------------------*/
if (findViewById(R.id.DetailsActivityTablet) !=null){
    StepsFragment stepsFragment2 = new StepsFragment();
    FragmentManager fragmentManager2 = getSupportFragmentManager();
    fragmentManager2.beginTransaction()
            .add(R.id.Steps_container_fragment, stepsFragment2)
            .commit();

            VedioFragment vedioFragment=new VedioFragment();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        fragmentManager1.beginTransaction()
                .add(R.id.vedio_container_fragment,vedioFragment)
                .commit();
}

        updateWidget();


//
//        FechData_Steps fechData=new FechData_Steps();
//        fechData.execute();
//        recyclerView = (RecyclerView) findViewById(R.id.RV_Steps);
//
//
//
//        Intent intent=getIntent();
//        if(intent.getExtras()!=null) {
//
//           // id1=Integer.parseInt(intent.getStringExtra("id"));
//            id1=intent.getExtras().getInt("id");
//            String name1 = intent.getStringExtra("name");
//
//            String Quantity1 = intent.getStringExtra("Quantity");
//            String Measure1 = intent.getStringExtra("Measure");
//            String Ingredient1 = intent.getStringExtra("Ingredient");
//
//
//            String StepsID1 = intent.getStringExtra("StepsID");
//            String Description1 = intent.getStringExtra("Description");
//            String ShortDescription1 = intent.getStringExtra("ShortDescription");
//            String VideoURL1 = intent.getStringExtra("VideoURL");
//            String ThumbnailURL1 = intent.getStringExtra("ThumbnailURL");
////            title.setText(original_title);
////            ReleaseDate.setText(release_date);
////            voteCount.setText(vote_count+"/10");
////            Movieoverview.setText(overview);
//
//
//
//        }
//
//
 }

    void updateWidget() {
        Intent intent = new Intent(this, BakingWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication()
                , BakingWidget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        sendBroadcast(intent);

    }
//
//    private DetailsActivity getAction() {
//        return DetailsActivity.this;
//    }
//
//    @Override
//    public void onClick(StepsModel model, int position) {
//
//    }
//
//
//    /*--------------*/
//    public class FechData_Steps extends AsyncTask<URL, Void, String> {
//        String data = "";
//        String Tag2="xx2";
//        String Tag3="xx3";
//        FechData_Steps(){}
//
//        @Override
//        protected String doInBackground(URL... urls) {
//
//            try {
//
//                URL url = new URL("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String line = "";
//                while (line != null) {
//                    line = bufferedReader.readLine();
//                    data = data + line;
//                }
//
//
//            } catch (MalformedURLException e) {
//
//                return e.getMessage();
//            } catch (IOException e) {
//                return e.getMessage();
//            }
//            Log.d(Tag3,data);
//            return data;
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            if (data != null && !data.equals("")) {
//                try {
//                    JsonUtils jsonUtils=new  JsonUtils();
//                    JSONArray json=  jsonUtils.parseJson(s);
//                    bakingModel= jsonUtils.parseBakingModelJson(json);
//                    ingredientModel= jsonUtils.parseIngredientModelJson(json,id1);
//                    stepsModel= jsonUtils.parseStepsModelJson(json,id1);
//                    Log.d(tag2,"%%%%%%%%"+id1);
//                    GridLayoutManager layoutManager=new GridLayoutManager(DetailsActivity.this,1);
//                    Log.d(tag2,"#############"+ingredientModel.getIngredient());
//                    Log.d(tag2,"###@@@@@@"+ingredientModel.getIngredient().get(0));
//                    Log.d(tag2,"#############"+stepsModel.getDescription());
//                    Log.d(tag2,"#############"+stepsModel.getDescription().get(0));
//
////                    Log.d(tag2,"#############"+ingredientModel.getMeasure().get(0));
////                    Log.d(tag2,"#############"+bakingModel.getName().get(0));
//
//                    SAdapter = new StepsAdapter( getAction(), stepsModel);
//                    recyclerView.setAdapter(SAdapter);
//                    recyclerView.setHasFixedSize(true);
//                    recyclerView.setLayoutManager(layoutManager);
//                }catch (Exception e)
//                {
//
//                }
//            }
//        }
//    }
}
