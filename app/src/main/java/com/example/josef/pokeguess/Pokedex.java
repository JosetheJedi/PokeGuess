package com.example.josef.pokeguess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.josef.pokeguess.database.DataSource;

import java.util.ArrayList;
import java.util.List;

public class Pokedex extends AppCompatActivity {

    // This will open up the database connection
    DataSource mDataSource;

    // will generate a list with all the pokemon information
    List<Pokemon> pokemonList = PokemonDataProvider.pokemonList;

    // will hold all the pokemon info retreived from the database
    List<Pokemon> pokemons;
    ArrayList<String> pokArray;

    // Views
    ListView pokeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setTitle(""); // getting rid of the text on the actionbar.

         /*
        this will create the database if it has not yet been created.
         */

        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(pokemonList);

        pokeList = (ListView) findViewById(R.id.pokemonList);

        // make list of pokemon from database
        pokemons = mDataSource.getAllItems();

        pokArray = new ArrayList<>();

        for (Pokemon p :
                pokemons) {
            pokArray.add(p.getName());
            pokArray.add(p.getType());
            pokArray.add(p.getImage());
            System.out.println(p.getName());
            System.out.println(p.getType());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokArray);

        pokeList.setAdapter(adapter);
    }
}
