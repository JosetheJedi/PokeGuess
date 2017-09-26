package com.example.josef.pokeguess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Josef on 9/21/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "pokemon.db";
    public static final int DB_VERSION = 1;

    // got rid of arguments and only kept context.
    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    // first time app opens and runs the open method, it will call this and pass a reference
    // to the table file.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PokemonTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PokemonTable.SQL_DELETE);
        onCreate(db);
    }
}
