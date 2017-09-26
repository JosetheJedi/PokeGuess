package com.example.josef.pokeguess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.josef.pokeguess.database.DataSource;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TypeQuiz extends AppCompatActivity {

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

    public static final String TAG = "TypeQuiz";

    // Views
    ImageView pokImg;
    Button option1, option2, option3;

    String types[] = {"Normal", "Fighting", "Fire", "Water", "Flying", "Grass", "Poison",
                        "Electric", "Ground", "Psychic", "Rock", "Ice", "Bug", "Dragon",
                            "Ghost", "Steel"};
    String dummyP1 = "";
    String dummyP2 = "";

    int pokemonCaught = 0, counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_quiz);


        // to make the actionbar at the top transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.

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

        pokImg = (ImageView) findViewById(R.id.imagePoke);
        option1 = (Button) findViewById(R.id.type1);
        option2 = (Button) findViewById(R.id.type2);
        option3 = (Button) findViewById(R.id.type3);

        // load the pokemon
        loadPokemon();


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option1.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getType().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(TypeQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option2.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getType().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(TypeQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poke_selected = option3.getText().toString();

                if(poke_selected.equalsIgnoreCase(currentPokemon.getType().toString())){
                    pokemonCaught++;
                    loadPokemon();
                }
                else{
                    Toast.makeText(TypeQuiz.this, "Sorry that is incorrect! :(", Toast.LENGTH_SHORT).show();
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

        int dummy = rand.nextInt(15);
        int dummy2 = rand.nextInt(15);

        dummyP1 = types[dummy];
        dummyP2 = types[dummy2];

        while(dummyP1.equalsIgnoreCase(currentPokemon.getType())){
            dummy = rand.nextInt(15);
            dummyP1 = types[dummy];
        }
        while(dummyP2.equalsIgnoreCase(dummyP1) || dummyP2.equalsIgnoreCase(currentPokemon.getType())){
            dummy2 = rand.nextInt(15);
            dummyP2 = types[dummy2];
        }

        // getting random number
        Random rand2 = new Random();

        int  pos = rand2.nextInt(3) + 1;


        if(pos == 1){
            option1.setText(currentPokemon.getType());
            option2.setText(dummyP1);
            option3.setText(dummyP2);
        }
        else if(pos == 2){
            option1.setText(dummyP1);
            option2.setText(currentPokemon.getType());
            option3.setText(dummyP2);
        }
        else if(pos == 3){
            option1.setText(dummyP1);
            option2.setText(dummyP2);
            option3.setText(currentPokemon.getType());
        }


        // get and render current pokemon image
        String currentImage = "drawable/" + currentPokemon.getImage();

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