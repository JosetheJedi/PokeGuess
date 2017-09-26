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
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.josef.pokeguess.database.DataSource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BattleCryQuiz extends AppCompatActivity {

    MediaPlayer media, battleCry;

    // This will open up the database connection
    DataSource mDataSource;

    // will generate a list with all the pokemon information
    List<Pokemon> pokemonList = PokemonDataProvider.pokemonList;

    // all Views
    ImageButton soundB;
    Button option1, option2, option3;

    // will hold all the pokemon info retreived from the database
    List<Pokemon> pokemons;

    // the pokemon that we are going to work with
    Pokemon currentPokemon;
    Pokemon dummyP1, dummyP2;
    int counter = 0;
    int pokemonCaught = 0;

    String poke_selected = "";

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

         /*
        this will create the database if it has not yet been created.
         */

        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(pokemonList);

        // make list of pokemon from database
        pokemons = mDataSource.getAllItems();

        Collections.shuffle(pokemons);

        // connecting buttons from xml
        soundB = (ImageButton) findViewById(R.id.soundButton);
        option1 = (Button) findViewById(R.id.option1B);
        option2 = (Button) findViewById(R.id.option2B);
        option3 = (Button) findViewById(R.id.option3B);

        loadPokemon();


        soundB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                battleCry.start();
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option1.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getName().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(BattleCryQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(BattleCryQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(BattleCryQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    protected void loadPokemon(){
        currentPokemon = pokemons.get(counter);
        counter++;

        if(battleCry != null){
            battleCry.release();
        }

        Random rand = new Random();

        int  dummy = rand.nextInt(151) + 1;
        int dummy2 = rand.nextInt(151) + 1;

        dummyP1 = pokemons.get(dummy);
        dummyP2 = pokemons.get(dummy2);

        while(dummyP1 == currentPokemon){
            dummy = rand.nextInt(151) + 1;
            dummyP1 = pokemons.get(dummy);
        }
        while(dummyP2 == dummyP1 || dummyP2 == currentPokemon){
            dummy2 = rand.nextInt(151) + 1;
            dummyP2 = pokemons.get(dummy);
        }

        // getting random number
        Random rand2 = new Random();

        int  pos = rand2.nextInt(3) + 1;

//        for (Pokemon n :
//                pokemons) {
//            System.out.println(n.getName());
//        }

        if(pos == 1){
            option1.setText(currentPokemon.getName().toString());
            option2.setText(dummyP1.getName().toString());
            option3.setText(dummyP2.getName().toString());
        }
        else if(pos == 2){
            option1.setText(dummyP1.getName().toString());
            option2.setText(currentPokemon.getName().toString());
            option3.setText(dummyP2.getName().toString());
        }
        else if(pos == 3){
            option1.setText(dummyP1.getName().toString());
            option2.setText(dummyP2.getName().toString());
            option3.setText(currentPokemon.getName().toString());
        }


        // get and render current cry
        String currentCry = "raw/" + currentPokemon.getSound();

        System.out.println("*****\n*\n*\n*\n*" + currentPokemon.getName());

        int resId = getResources().getIdentifier(currentCry, null, this.getPackageName());

        battleCry = MediaPlayer.create(BattleCryQuiz.this, resId);

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
