package com.example.josef.pokeguess.database;

/**
 * Created by Josef on 9/21/2017.
 */

public class PokemonTable {

    public static final String POKEMON_TABLE = "Pokemon";
    public static final String POKEMON_ID = "pokeID";
    public static final String POKEMON_NAME = "pokemonName";
    public static final String POKEMON_TYPE = "pokemonType";
    public static final String POKEMON_SOUND = "pokemonSound";
    public static final String POKEMON_IMAGE = "pokemonImage";
    public static final String POKEMON_SHADOW = "pokemonShadow";


    public static final String SQL_CREATE =
            "CREATE TABLE " + POKEMON_TABLE + "(" +
                    POKEMON_ID + " TEXT PRIMARY KEY, " +
                    POKEMON_NAME + " TEXT," +
                    POKEMON_TYPE + " TEXT," +
                    POKEMON_SOUND + " TEXT," +
                    POKEMON_IMAGE + " TEXT," +
                    POKEMON_SHADOW + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + POKEMON_TABLE;
}
