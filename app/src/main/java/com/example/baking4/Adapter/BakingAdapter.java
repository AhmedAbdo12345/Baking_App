package com.example.baking4.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.baking4.MainActivity;
import com.example.baking4.Model.BakingModel;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;
import com.example.baking4.R;

public class BakingAdapter extends RecyclerView.Adapter<BakingAdapter.NumberViewHolder> {

    // ingredients ingredientsModel;
    BakingModel bakingModel;
    IngredientModel ingredientModel;
    StepsModel stepsModel;

    String tag2 = "ACD";
    final private ListItemClickListener mOnClickListener;
    private static int viewHolderCount;

    public interface ListItemClickListener {


        void onClick(BakingModel model, int position);
    }

    public BakingAdapter(ListItemClickListener listener) {

        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    public BakingAdapter(MainActivity mainActivity, ListItemClickListener mOnClickListener, BakingModel bakingModel) {
        this.mOnClickListener = mOnClickListener;
        this.bakingModel = bakingModel;
    }

    private static final String TAG = BakingAdapter.class.getSimpleName();

    public BakingAdapter(ListItemClickListener mOnClickListener, BakingModel bakingModel) {
        this.mOnClickListener = mOnClickListener;
        this.bakingModel = bakingModel;
    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.baking_name;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(tag2, "error");

        //Log.d(TAG, "#" + position);
        // Picasso.get().load(bakingModel.getVideoURL().get(position)).into(holder.imageView);

        // Picasso.get().load("http://image.tmdb.org/t/p/w185//"+holde(position)).into(holder.imageView);
        //Picasso.get().load("http://image.tmdb.org/t/p/w185//udDclJoHjfjb8Ekgsd4FDteOkCU.jpg").into(holder.imageView);
        //  Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);
        // holder.textView.setText(bakingModel.getName());
         holder.textView.setText(bakingModel.getName().get(position));



    }


    @Override
    public int getItemCount() {
        if (bakingModel != null)
            return bakingModel.getName().size();

        else
            return 5;
        //   return 3;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //  ImageView imageView;
        TextView textView;

        public NumberViewHolder(View itemView) {
            super(itemView);
            //imageView=(ImageView) itemView.findViewById(R.id.Baking_Picture);
            textView = (TextView) itemView.findViewById(R.id.Baking_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

            mOnClickListener.onClick(bakingModel, getAdapterPosition());


        }

    }

}
