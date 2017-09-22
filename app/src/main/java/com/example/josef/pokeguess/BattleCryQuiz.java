package com.example.josef.pokeguess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class BattleCryQuiz extends AppCompatActivity {

    MediaPlayer media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_cry_quiz); // tells the activity which xml file to use
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle("");

        media = MediaPlayer.create(this, R.raw.pokemon_battle);
        media.setLooping(true);
        media.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        media.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        media.start();
    }
}
