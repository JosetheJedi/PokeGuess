package com.example.josef.pokeguess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.josef.pokeguess.database.DataSource;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShadowQuiz extends AppCompatActivity {

    MediaPlayer media;

    // This will open up the database connection
    DataSource mDataSource;

    // will generate a list with all the pokemon information
    List<Pokemon> pokemonList = PokemonDataProvider.pokemonList;

    // will hold all the pokemon info retreived from the database
    List<Pokemon> pokemons;

    // the pokemon that we are going to work with
    Pokemon currentPokemon;

    String poke_selected = "";

    //for debugging
    public static final String TAG = "ShadowQuiz";

    ImageView pokImg;
    Button option1, option2, option3;

    int pokemonCaught = 0, counter = 0;

    String dummyP1 = "";
    String dummyP2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_quiz);


        media = MediaPlayer.create(this, R.raw.pokemon_battle);
        media.setLooping(true);
        media.start();

        // to make the actionbar at the top transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.

        /*
        this will create the database if it has not yet been created.
         */
        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(pokemonList);

        // make list of pokemon from database
        pokemons = mDataSource.getAllItems();

        Collections.shuffle(pokemons);

        pokImg = (ImageView) findViewById(R.id.imagePoke);
        option1 = (Button) findViewById(R.id.pname1);
        option2 = (Button) findViewById(R.id.pname2);
        option3 = (Button) findViewById(R.id.pname3);

        // load the pokemon
        loadPokemon();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option1.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getName().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(ShadowQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option2.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getName().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(ShadowQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option3.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getName().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(ShadowQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void loadPokemon(){
        currentPokemon = pokemons.get(counter);
        counter++;

        Random rand = new Random();

        // debugging purpose: displays how many pokemon we have guessed.
        Log.e(TAG, "loadPokemon: " + counter);

        int dummy = rand.nextInt(151);
        int dummy2 = rand.nextInt(151);

        dummyP1 = pokemons.get(dummy).getName();
        dummyP2 = pokemons.get(dummy2).getName();

        while(dummyP1.equalsIgnoreCase(currentPokemon.getName())){
            dummy = rand.nextInt(151);
            dummyP1 = pokemons.get(dummy).getName();
        }
        while(dummyP2.equalsIgnoreCase(dummyP1) || dummyP2.equalsIgnoreCase(currentPokemon.getName())){
            dummy2 = rand.nextInt(151);
            dummyP2 = pokemons.get(dummy2).getName();
        }

        // getting random number
        Random rand2 = new Random();

        int  pos = rand2.nextInt(3) + 1;


        if(pos == 1){
            option1.setText(currentPokemon.getName());
            option2.setText(dummyP1);
            option3.setText(dummyP2);
        }
        else if(pos == 2){
            option1.setText(dummyP1);
            option2.setText(currentPokemon.getName());
            option3.setText(dummyP2);
        }
        else if(pos == 3){
            option1.setText(dummyP1);
            option2.setText(dummyP2);
            option3.setText(currentPokemon.getName());
        }


        // get and render current pokemon image
        String currentImage = "drawable/" + currentPokemon.getShadow();

        System.out.println("*****\n*\n*\n*\n*" + currentImage);

        int resId = getResources().getIdentifier(currentImage, null, this.getPackageName());

        pokImg.setImageResource(resId);

    }

    @Override
    protected void onPause() {
        super.onPause();
        media.pause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        media.start();
        mDataSource.open();
    }

}
