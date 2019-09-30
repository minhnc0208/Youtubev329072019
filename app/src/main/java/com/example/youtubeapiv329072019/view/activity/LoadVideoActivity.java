package com.example.youtubeapiv329072019.view.activity;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;

import com.example.youtubeapiv329072019.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class LoadVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    YouTubePlayerView youTubePlayerView;
    String API_KEY = "AIzaSyD5s2DldO1vzldC6t14G75cnBjSf6Q4M5A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadvideo);

        youTubePlayerView = findViewById(R.id.youtubePlayerview);

        youTubePlayerView.initialize(API_KEY,this);
//        https://www.googleapis.com/youtube/v3/search?part=snippet&q=android&maxResults=50&type=video&key=AIzaSyDw1xWgw-tzAEnKhPUpCPEpNXTwbs3e6hY
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("d9xm3kXffGo");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(LoadVideoActivity.this,123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null){

            youTubePlayerView.initialize(API_KEY,this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

//https://developers.google.com/youtube/android/player/downloads/