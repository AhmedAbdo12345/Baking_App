package com.example.baking4.Widget;

import android.content.Context;
import android.os.Binder;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.baking4.R;

import java.util.ArrayList;
import java.util.List;

public class RemoteListViewService implements RemoteViewsService.RemoteViewsFactory {

   // List<IngredientsItem> ingredientsItems;
    Context mContext;
    ArrayList<String> arrayListQuantity;
    ArrayList<String> arrayListMeasure;
    ArrayList<String> arrayListIngredient;

    public RemoteListViewService(Context mContext) {
        this.mContext = mContext;

    }
    public RemoteListViewService(ArrayList<String> arrayListQuantity,ArrayList<String> arrayListMeasure,ArrayList<String> arrayListIngredient, Context mContext) {
        this.arrayListQuantity = arrayListQuantity;
        this.arrayListMeasure = arrayListMeasure;
        this.arrayListIngredient = arrayListIngredient;
        this.mContext = mContext;

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        final long identityToken = Binder.clearCallingIdentity();
        Binder.restoreCallingIdentity(identityToken);

    }

    @Override
    public void onDestroy() {

        //  ingredientsItems.clear();
    }

    @Override
    public int getCount() {

        // return arrayListQuantity.size();
        return 6;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.item_ingredient);
//        rv.setTextViewText(R.id.tv_Ingredient, arrayListQuantity.get(position));
//            rv.setTextViewText(R.id.tv_Ingredient, arrayListMeasure.get(position));
//            rv.setTextViewText(R.id.tv_Ingredient, arrayListIngredient.get(position));
        rv.setTextViewText(R.id.tv_Ingredient, "error");
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
