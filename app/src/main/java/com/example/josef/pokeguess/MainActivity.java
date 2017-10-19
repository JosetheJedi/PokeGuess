package com.example.josef.pokeguess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button battleB, shadowB, typeB, pokedexB, leaderboardB;
    MediaPlayer mediaPlayer; // object to load a song and play it

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // tells the activity which xml file to use

        // to make the actionbar at the top transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.
        InitializeMediaPlayer();

        // linking all the buttons from the main menu to java code
        // to be able to manipulate the activity.
        battleB = (Button) findViewById(R.id.battle_cry);
        shadowB = (Button) findViewById(R.id.shadow_button);
        typeB = (Button) findViewById(R.id.type_button);
        pokedexB = (Button) findViewById(R.id.pokedex_button);
        leaderboardB = (Button) findViewById(R.id.leaderboards_button);

        // the action that will occur when the battle_cry button is pressed.
        battleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will link this activity to the battlecryquiz activity
                Intent intent = new Intent(MainActivity.this, BattleCryQuiz.class);

                // the music from the main_menu activity will be paused
                stopMusic();

                // this will switch to the new activity.
                startActivity(intent);
            }
        });

        // the action that will occur when the battle_cry button is pressed.
        shadowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will link this activity to the shadowquiz activity
                Intent intent = new Intent(MainActivity.this, ShadowQuiz.class);

                // the music from the main_menu activity will be paused
                stopMusic();

                // this will switch to the new activity.
                startActivity(intent);
            }
        });

        typeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will link this activity to the type quiz activity
                Intent intent = new Intent(MainActivity.this, TypeQuiz.class);

                // the music from the main_menu activity will be paused
                stopMusic();

                // this will switch to the new activity.
                startActivity(intent);
            }
        });

        pokedexB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( MainActivity.this, Pokedex.class);

                stopMusic();
                startActivity(intent1);
            }
        });
    }

    private void stopMusic() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    private void InitializeMediaPlayer() {
        // sets the song to use for the main menu
        mediaPlayer = MediaPlayer.create(this, R.raw.main_menu_song);

        // making the song to loop once it ends
        mediaPlayer.setLooping(true);
        // will start playing the song when the main menu is created.
        mediaPlayer.start();
    }

    // this code will run when the application goes to another screen
    // or when the app is sent to the background.
    @Override
    protected void onPause() {
        super.onPause();

        try{
            mediaPlayer.pause();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        try{
            stopMusic();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    // this code will run when the application resumes.
    // when returning from another activity.
    @Override
    protected void onResume() {
        super.onResume();
        // will start the song.
        InitializeMediaPlayer();
    }
}