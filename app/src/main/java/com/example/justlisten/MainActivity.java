package com.example.justlisten;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer media_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(View v) {
        if (media_player == null) {
            media_player = MediaPlayer.create(this, R.raw.song);
            media_player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        media_player.start();
    }

    public void onPause(View v) {
        if (media_player != null) {
            media_player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (media_player != null) {
            media_player.release();
            media_player = null;
            Toast.makeText(this, "Media player release", Toast.LENGTH_LONG).show();
        }
    }

    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}