package com.example.josef.pokeguess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        PokemonItemAdapter adapter = new PokemonItemAdapter(this, pokemons);

        pokeList.setAdapter(adapter);


        pokeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon p = pokemons.get(i);
                String selectedFromList = (String) p.getName();
//                Toast.makeText(Pokedex.this, "You selected: " + selectedFromList, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Pokedex.this, PokemonInfo.class);
                intent.putExtra("Pokemon", p);
                startActivity(intent);

            }
        });
    }
}
