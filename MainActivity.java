package com.android.app;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button getStarted;
    VideoView videoView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        getStarted = (Button) findViewById(R.id.getStarted);
        videoView2 = (VideoView) findViewById(R.id.videoView2);

        String path ="android.resource://com.android.app/"+R.raw.aste;
        Uri u = Uri.parse(path);
        videoView2.setVideoURI(u);
        videoView2.start();

        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.setLooping(true);
            }
        });

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Wait...",Toast.LENGTH_SHORT).show();
                Intent a = new Intent(MainActivity.this,secondpage.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    @Override
    protected void onResume(){
        videoView2.resume();
        super.onResume();
    }

    @Override
    protected void onPause(){
        videoView2.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        videoView2.stopPlayback();
        super.onDestroy();
    }

}