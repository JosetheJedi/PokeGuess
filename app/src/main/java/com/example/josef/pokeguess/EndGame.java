package com.example.josef.pokeguess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    TextView score;
    Button main, playAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        // to make the actionbar at the top transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.

        Intent intent = getIntent();

        int pokemoncaught = intent.getIntExtra("POKEMON_CAUGHT", 0);
        final String sendingActivity = intent.getStringExtra("ACTIVITY");

        score = (TextView) findViewById(R.id.resultText);
        main = (Button) findViewById(R.id.mainB);
        playAgain = (Button) findViewById(R.id.playAgainB);

        score.setText(pokemoncaught + "/151");


        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGame.this, MainActivity.class);
                startActivity(intent);
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sendingActivity.equalsIgnoreCase("battlecry")){
                    Intent intent = new Intent(EndGame.this, BattleCryQuiz.class);
                    startActivity(intent);
                }
                else if(sendingActivity.equalsIgnoreCase("shadow")){
                    Intent intent = new Intent(EndGame.this, ShadowQuiz.class);
                    startActivity(intent);
                }
                else if(sendingActivity.equalsIgnoreCase("type")){
                    Intent intent = new Intent(EndGame.this, TypeQuiz.class);
                    startActivity(intent);
                }
            }
        });

    }
}
