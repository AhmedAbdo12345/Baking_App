package com.example.baking4.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baking4.DetailsActivity;
import com.example.baking4.Fragment.StepsFragment;
import com.example.baking4.Fragment.VedioFragment;
import com.example.baking4.MainActivity;
import com.example.baking4.Model.IngredientModel;
import com.example.baking4.Model.StepsModel;
import com.example.baking4.R;
import com.example.baking4.Vedio_Show;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class StepsAdapter extends   RecyclerView.Adapter<com.example.baking4.Adapter.StepsAdapter.NumberViewHolder>  {



  //  DetailsActivity detailsActivity;
        //BakingModel bakingModel;
        IngredientModel ingredientModel;
        StepsModel stepsModel;
        Context context;


    final private com.example.baking4.Adapter.StepsAdapter.ListItemClickListener mOnClickListener ;
        private static int viewHolderCount;
        public interface ListItemClickListener {

            void onClick(StepsModel model, int position);
        }
        public StepsAdapter( com.example.baking4.Adapter.StepsAdapter.ListItemClickListener listener) {

            mOnClickListener = listener;
            viewHolderCount = 0;
        }

        public  StepsAdapter(DetailsActivity detailsActivity, com.example.baking4.Adapter.StepsAdapter.ListItemClickListener mOnClickListener, StepsModel stepsModel)
        {
            this.mOnClickListener = mOnClickListener;
            this.stepsModel=stepsModel;
        }

        private static final String TAG = com.example.baking4.Adapter.StepsAdapter.class.getSimpleName();


        public StepsAdapter(com.example.baking4.Adapter.StepsAdapter.ListItemClickListener mOnClickListener, StepsModel stepsModel , Context context) {
            this.mOnClickListener = mOnClickListener;
            this.stepsModel=stepsModel;
            this.context=context;
        }
    public StepsAdapter(StepsAdapter.ListItemClickListener mOnClickListener, StepsModel stepsModel) {
        this.mOnClickListener = mOnClickListener;
        this.stepsModel = stepsModel;
    }
        @Override
        public com.example.baking4.Adapter.StepsAdapter.NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Context context = viewGroup.getContext();
            int layoutIdForListItem = R.layout.steps;
            LayoutInflater inflater = LayoutInflater.from(context);
            boolean shouldAttachToParentImmediately = false;
            View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
            com.example.baking4.Adapter.StepsAdapter.NumberViewHolder viewHolder = new com.example.baking4.Adapter.StepsAdapter.NumberViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final com.example.baking4.Adapter.StepsAdapter.NumberViewHolder holder, final int position) {
       //  FragmentManager fragmentManager=new  getSupportFragmentManager();

            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//               Intent intent = new Intent(holder.button.getContext(), Vedio_Show.class);
//             intent.putExtra("vedio" , stepsModel.getVideoURL().get(position));
//             intent.putExtra("image" , stepsModel.getThumbnailURL().get(position));
//                    holder.button.getContext().startActivity(intent);
             //   holder.button.setVisibility(View.GONE);
                StepsFragment stepsFragment=new StepsFragment();
                    VedioFragment vedioFragment=new VedioFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("vedio" , stepsModel.getVideoURL().get(position));
                    bundle.putString("image" , stepsModel.getThumbnailURL().get(position));
                    vedioFragment.setArguments(bundle);
                    ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.MainActivity, vedioFragment).commit();

                    if (v.findViewById(R.id.DetailsActivityTablet) !=null){
                        StepsFragment stepsFragment2 = new StepsFragment();
                        FragmentManager fragmentManager2 = ((AppCompatActivity)context).getSupportFragmentManager();
                        fragmentManager2.beginTransaction()
                                .add(R.id.MainActivity, stepsFragment2)
                                .commit();

                        VedioFragment vedioFragment2=new VedioFragment();
                        Bundle bundle1=new Bundle();
                        bundle1.putString("vedio" , stepsModel.getVideoURL().get(position));
                        bundle1.putString("image" , stepsModel.getThumbnailURL().get(position));
                        vedioFragment2.setArguments(bundle1);
                        FragmentManager fragmentManager1 = ((AppCompatActivity)context).getSupportFragmentManager();
                        fragmentManager1.beginTransaction()
                                .add(R.id.MainActivity,vedioFragment2)
                                .commit();
                    }

                }
            });

           holder.textView1.setText(stepsModel.getStepsID().get(position));
           holder.textView2.setText(stepsModel.getDescription().get(position));

            holder.textView3.setText(stepsModel.getShortDescription().get(position));
       //   holder.textView4.setText(stepsModel.getVideoURL().get(position));
            holder.textView5.setText(stepsModel.getThumbnailURL().get(position));
//            DetailsActivity detailsActivity=(DetailsActivity) context ;
//            detailsActivity.initializePlayer(Uri.parse(stepsModel.getVideoURL().get(position)));
        }


        @Override
        public int getItemCount() {
            if (stepsModel !=null)
                return stepsModel.getStepsID().size();

            else
                return 5;
        }

        class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            Button button;
          //  SimpleExoPlayerView simpleExoPlayerView;
//            SimpleExoPlayer mExoPlayer;
//             SimpleExoPlayerView mPlayerView;
        TextView textView1,textView2,textView3,textView4,textView5;

            public NumberViewHolder(View itemView) {
                super(itemView);
             button=itemView.findViewById(R.id.vedio_Button);
                textView1=itemView.findViewById(R.id.Steps_id);
                textView2=itemView.findViewById(R.id.Steps_Description);
                textView3=itemView.findViewById(R.id.Steps_shortDescription);
             //   textView4=itemView.findViewById(R.id.Steps_vedio);
                textView5=itemView.findViewById(R.id.Steps_ThumbnailURL);
               // mPlayerView=itemView.findViewById(R.id.playerView);
/*----------------------------------------*/
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int clickedPosition = getAdapterPosition();
                mOnClickListener.onClick(stepsModel , getAdapterPosition());
            }
        }


    }
