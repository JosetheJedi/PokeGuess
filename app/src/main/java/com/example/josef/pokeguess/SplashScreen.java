package com.example.josef.pokeguess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); // tells the activity which xml file to use
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle("");

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        final ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.animation);

        img.post(new Runnable() {
            @Override
            public void run() {
                // Get the background, which has been compiled to an AnimationDrawable object.
                AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

                // Start the animation (looped playback by default).
                frameAnimation.start();
            }
        });

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.loading_song);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you


        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5500);  //Delay of 5.5 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(SplashScreen.this,
                            MainActivity.class);

                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();

    }
}
