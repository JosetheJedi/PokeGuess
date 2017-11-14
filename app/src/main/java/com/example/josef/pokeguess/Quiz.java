package com.example.josef.pokeguess;

import com.example.josef.pokeguess.database.DataSource;

import java.util.List;

/**
 * Created by Josef on 11/10/2017.
 */

public interface Quiz {

    void removeActionBar();
    void openDatabase();
    void loadPokemon();
    void instantiateViews();
    void comparePokemon(String poke_selected);
}
