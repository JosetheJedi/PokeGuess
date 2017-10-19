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

import com.example.josef.pokeguess.database.DataSource;

import java.util.ArrayList;
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
    List<Pokemon> pokemonDBList;

    // will be used to keep track of the pokemon that were caught.
    List<Pokemon> pkmCaught;

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

         // this will create the database if it has not yet been created.
        openDatabase();

        // make list of pokemon with information from database
        pokemonDBList = mDataSource.getAllItems();

        pkmCaught = new ArrayList<>();

        Collections.shuffle(pokemonDBList);

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

                comparePokemon(poke_selected);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option2.getText().toString();

                comparePokemon(poke_selected);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option3.getText().toString();

                comparePokemon(poke_selected);
            }
        });
    }

    private void openDatabase() {
        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(pokemonList);
    }

    // this method compares the pokemon selected to determine if a new pokemon should be loaded or if the
    // player has lost the game
    private void comparePokemon(String poke_selected) {

        if(poke_selected.equalsIgnoreCase(currentPokemon.getName())){
            pokemonCaught++;
            pkmCaught.add(currentPokemon);
            if(currentPokemon.getCaught() != 1){
                currentPokemon.setCaught(1);
                mDataSource.updateItem(currentPokemon);
            }

            if(counter == 151){
                Intent intent = new Intent(BattleCryQuiz.this, EndGame.class);
                intent.putExtra("POKEMON_CAUGHT", pokemonCaught);
                clearMemResources();
                startActivity(intent);
            }
            else{
                loadPokemon();
            }
        }
        else{
            Intent intent = new Intent(BattleCryQuiz.this, EndGame.class);
            intent.putExtra("POKEMON_CAUGHT", pokemonCaught);
            intent.putExtra("ACTIVITY", "BATTLECRY");
            clearMemResources();
            startActivity(intent);
        }
    }

    // This method will load the new pokemon
    // load the new sound for the current pokemon
    // and select two other pokemon names to list as options.
    protected void loadPokemon(){
        currentPokemon = pokemonDBList.get(counter);
        counter++; // increments to get the next pokemon for the next round.

        // will clear the current pokemon sound.
        clearMemResources();

        // get random pokemon names to put as answers.
        Random rand = new Random();

        int dummy = rand.nextInt(150);
        int dummy2 = rand.nextInt(150);

        dummyP1 = pokemonDBList.get(dummy);
        dummyP2 = pokemonDBList.get(dummy2);

        while(dummyP1 == currentPokemon){
            dummy = rand.nextInt(150);
            dummyP1 = pokemonDBList.get(dummy);
        }
        while(dummyP2 == dummyP1 || dummyP2 == currentPokemon){
            dummy2 = rand.nextInt(150);
            dummyP2 = pokemonDBList.get(dummy);
        }

        // getting random number to determine position
        // of the correct answer.
        Random rand2 = new Random();

        int pos = rand2.nextInt(3) + 1;

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

        int resId = getResources().getIdentifier(currentCry, null, this.getPackageName());

        battleCry = MediaPlayer.create(BattleCryQuiz.this, resId);

    }

    // releases memory resources from the last pokemon before
    // loading the new pokemon.
    private void clearMemResources() {
        try{
            battleCry.release();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
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

    @Override
    protected void onStop() {
        super.onStop();
        media.stop();
        media.release();
        System.gc();
    }
}
