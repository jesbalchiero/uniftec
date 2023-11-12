package com.uniftec.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        VideoView video = (VideoView) findViewById(R.id.videoView);
        String vidAdrees = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        Uri uri = Uri.parse(vidAdrees);

        MediaController controle = new MediaController(this);
        controle.setAnchorView(video);
        video.setMediaController(controle);
        video.setVideoURI(uri);

        video.requestFocus();
        video.start();
    }
}