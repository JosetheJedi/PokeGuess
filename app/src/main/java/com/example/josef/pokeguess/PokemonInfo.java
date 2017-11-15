package com.example.josef.pokeguess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.josef.pokeguess.database.DataSource;

import java.util.List;

public class PokemonInfo extends AppCompatActivity {

    // This will open up the database connection
    DataSource mDataSource;

    // will generate a list with all the pokemon information
    List<Pokemon> pokemonList = PokemonDataProvider.pokemonList;

    // will hold all the pokemon info retreived from the database
    List<Pokemon> pokemons;

    // views
    ImageButton pokImg;
    TextView nameT, idT, typeT;
    ImageView shadowImg, caughtImg;

    MediaPlayer battleCry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);


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

        instantiateViews();

        Intent intent = getIntent();
        Pokemon p = (Pokemon)intent.getSerializableExtra("Pokemon");
        setInfo(p);

        pokImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                battleCry.start();
            }
        });

    }

    private void instantiateViews(){
        pokImg = (ImageButton)findViewById(R.id.imageButton);
        nameT = (TextView)findViewById(R.id.pokedexName);
        idT = (TextView)findViewById(R.id.idText);
        typeT = (TextView)findViewById(R.id.typeText);
        shadowImg = (ImageView)findViewById(R.id.shadowImg1);
        caughtImg = (ImageView)findViewById(R.id.caughtImg);
    }

    private void setInfo(Pokemon p){

        if(!(battleCry == null)){
            // will clear the current pokemon sound.
            clearMemResources();
        }

        // get and render current pokemon image
        String currentImage = "drawable/" + p.getImage();
        int resId = getResources().getIdentifier(currentImage, null, this.getPackageName());
        pokImg.setImageResource(resId);

        // get and render current cry
        String currentCry = "raw/" + p.getSound();
        int soundID = getResources().getIdentifier(currentCry, null, this.getPackageName());
        battleCry = MediaPlayer.create(PokemonInfo.this, soundID);

        nameT.setText(p.getName());
        idT.setText(p.getID());
        typeT.setText(p.getType());

        String shadowCurr = "drawable/" + p.getShadow();
        int resID2 = getResources().getIdentifier(shadowCurr, null, this.getPackageName());
        shadowImg.setImageResource(resID2);
    }

    // releases memory resources from the last pokemon before
    // loading the new pokemon.
    public void clearMemResources() {
        try{
            battleCry.release();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
