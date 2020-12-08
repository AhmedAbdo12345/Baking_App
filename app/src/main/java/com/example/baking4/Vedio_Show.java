package com.example.baking4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.exoplayer2.C;
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
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.squareup.picasso.Picasso;

public class Vedio_Show extends AppCompatActivity {

//    private SimpleExoPlayer mExoPlayer;
//    private SimpleExoPlayerView mPlayerView;
//    String VideoURL1;
//    String imageURL;
//    ImageView imageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_vedio__show);
//        Intent intent = getIntent();
//
//
//        // Initialize the player view.
//        mPlayerView = (SimpleExoPlayerView) findViewById(R.id.playerView);
//
//        mPlayerView.setDefaultArtwork(BitmapFactory.decodeResource
//                (getResources(), R.drawable.exo_icon_play));
//        imageView=findViewById(R.id.image_thumbnailURL);
//
//       // Intent intent=getIntent();
//        if(intent.getExtras()!=null) {
//
//             VideoURL1 = intent.getStringExtra("vedio");
//            imageURL = intent.getStringExtra("image");
//        }
//
//       // initializePlayer(Uri.parse(VideoURL1));
//       try {
//           Picasso.get().load(imageURL).into(imageView);
//       }catch (Exception e){
//
//       }
//           // Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
//
//    }
///*----------------------------------------------------*/
////@Override
////public void onSaveInstanceState(Bundle outState) {
////    super.onSaveInstanceState(outState);
////    updateTrackSelectorParameters();
////    updateStartPosition();
////    outState.putParcelable(KEY_TRACK_SELECTOR_PARAMETERS, trackSelectorParameters);
////    outState.putBoolean(KEY_AUTO_PLAY, startAutoPlay);
////    outState.putInt(KEY_WINDOW, startWindow);
////    outState.putLong(KEY_POSITION, startPosition);
////}
////    private void updateTrackSelectorParameters() {
////        if (trackSelector != null) {
////            trackSelectorParameters = trackSelector.getParameters();
////        }
////    }
////
////    private void updateStartPosition() {
////        if (mExoPlayer != null) {
////            startAutoPlay = mExoPlayer.getPlayWhenReady();
////            startWindow = mExoPlayer.getCurrentWindowIndex();
////            startPosition = Math.max(0, mExoPlayer.getContentPosition());
////        }
////    }
////    private void clearStartPosition() {
////        startAutoPlay = true;
////        startWindow = C.INDEX_UNSET;
////        startPosition = C.TIME_UNSET;
////    }
///*----------------------------------------------------------*/
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (Util.SDK_INT > 23) {
//            initializePlayer(Uri.parse(VideoURL1));
//        }
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        if ((Util.SDK_INT <= 23 || mExoPlayer == null)) {
//            initializePlayer(Uri.parse(VideoURL1));
//        }
//    }
//
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        if (Util.SDK_INT <= 23) {
//            releasePlayer();
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (Util.SDK_INT > 23) {
//            releasePlayer();
//        }
//    }
//    /*-------------------------------------------------------------------*/
//    public   void initializePlayer(Uri mediaUri) {
//        if (mExoPlayer == null) {
//            // Create an instance of the ExoPlayer.
//            TrackSelector trackSelector = new DefaultTrackSelector();
//            LoadControl loadControl = new DefaultLoadControl();
//            mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
//            mPlayerView.setPlayer(mExoPlayer);
//            // Prepare the MediaSource.
//            String userAgent = Util.getUserAgent(this, "Baking4");
//            MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(
//                    this, userAgent), new DefaultExtractorsFactory(), null, null);
//            mExoPlayer.prepare(mediaSource);
//            mExoPlayer.setPlayWhenReady(true);
//        }
//    }
//    /**
//     * Release ExoPlayer.
//     */
//    private void releasePlayer() {
//        mExoPlayer.stop();
//        mExoPlayer.release();
//        mExoPlayer = null;
//    }
//    /**
//     * Release the player when the activity is destroyed.
//     */
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        releasePlayer();
//    }

}
