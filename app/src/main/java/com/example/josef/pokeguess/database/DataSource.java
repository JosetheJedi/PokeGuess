package com.example.josef.pokeguess.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josef.pokeguess.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josef on 9/21/2017.
 */

public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context){
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDbHelper.close();
    }

    public Pokemon createItem(Pokemon p){
        ContentValues values = p.toValues();
        mDatabase.insert(PokemonTable.POKEMON_TABLE, null, values);
        return p;
    }

    public Pokemon updateItem(Pokemon p){
        ContentValues values = p.toValues();
        String where = PokemonTable.POKEMON_NAME + " = ?";
        String[] whereArgs = {p.getName()};
        mDatabase.update(PokemonTable.POKEMON_TABLE, values, where, whereArgs);
        return p;
    }

    public long getDataItemsCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, PokemonTable.POKEMON_TABLE);
    }

    public void seedDatabase(List<Pokemon> pokemonList){
        long numPokemon = getDataItemsCount();

        if(numPokemon == 0){
            for (Pokemon p: pokemonList
                    ) {
                try {
                    createItem(p);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Pokemon> getAllItems(){
        List<Pokemon> pokemons = new ArrayList<>();

        Cursor cursor = mDatabase.query(PokemonTable.POKEMON_TABLE, PokemonTable.ALL_COLUMNS,
                null, null, null, null, null);

        while(cursor.moveToNext()){
            Pokemon p = new Pokemon();

            p.setID(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_ID)));
            p.setName(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_NAME)));
            p.setSound(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_SOUND)));
            p.setImage(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_IMAGE)));
            p.setShadow(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_SHADOW)));
            p.setType(cursor.getString(cursor.getColumnIndex(PokemonTable.POKEMON_TYPE)));
            p.setCaught(cursor.getInt(cursor.getColumnIndex(PokemonTable.POKEMON_CAUGHT)));

            pokemons.add(p);
        }

        cursor.close();

        return pokemons;
    }
}
