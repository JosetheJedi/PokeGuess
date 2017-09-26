package com.example.josef.pokeguess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ShadowQuiz extends AppCompatActivity {

    ImageView pok;
    private TextView score;
    private Button shadow_answer1;
    private Button shadow_answer2;
    private Button shadow_answer3;
    private Button shadow_answer4;
    private String correctName;
    private String text_answer1;
    private String text_answer2;
    private String text_answer3;
    private String text_answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_quiz);

        // to make the actionbar at the top transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.

        Random random = new Random();
        int random_num = random.nextInt(151);

        pok = (ImageView) findViewById(R.id.imageView3);
        pok.setImageResource(R.drawable.pok1);

        shadow_answer1 = (Button)findViewById(R.id.shadow_answer1);
        shadow_answer2 = (Button)findViewById(R.id.shadow_answer2);
        shadow_answer3 = (Button)findViewById(R.id.shadow_answer3);
        shadow_answer4 = (Button)findViewById(R.id.shadow_answer4);

        shadow_answer1.setText();
        shadow_answer2.setText();
        shadow_answer3.setText();
        shadow_answer4.setText();

    }
}
