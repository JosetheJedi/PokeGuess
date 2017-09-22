package com.example.josef.pokeguess.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josef.pokeguess.Pokemon;

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

    public long getDataItemsCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, PokemonTable.POKEMON_TABLE);
    }
}
