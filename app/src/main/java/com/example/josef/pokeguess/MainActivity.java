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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle("");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.main_menu_song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you

        battleB = (Button) findViewById(R.id.battle_cry);
        shadowB = (Button) findViewById(R.id.shadow_button);
        typeB = (Button) findViewById(R.id.type_button);
        pokedexB = (Button) findViewById(R.id.pokedex_button);
        leaderboardB = (Button) findViewById(R.id.leaderboards_button);

        battleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BattleCryQuiz.class);
                startActivity(intent);
            }
        });
    }
}
