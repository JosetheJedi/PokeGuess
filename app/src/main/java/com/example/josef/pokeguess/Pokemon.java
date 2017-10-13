package com.example.josef.pokeguess;

import android.content.ContentValues;

import com.example.josef.pokeguess.database.PokemonTable;

import java.util.Map;

/**
 * Created by Josef on 9/21/2017.
 */

public class Pokemon {
    private String ID;
    private String name;
    private String sound;
    private String image;
    private String shadow;
    private String type;
    private int caught;

    public Pokemon(){

    }

    public Pokemon(String ID, String name, String sound, String image, String shadow, String type, int caught){
        this.ID = ID;
        this.name = name;
        this.sound = sound;
        this.image = image;
        this.shadow = shadow;
        this.type = type;
        this.caught = caught;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShadow() {
        return shadow;
    }

    public void setShadow(String shadow) {
        this.shadow = shadow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCaught() {
        return caught;
    }

    public void setCaught(int caught) {
        this.caught = caught;
    }

    public ContentValues toValues(){
        ContentValues values = new ContentValues(7);

        values.put(PokemonTable.POKEMON_ID, ID);
        values.put(PokemonTable.POKEMON_NAME, name);
        values.put(PokemonTable.POKEMON_SOUND, sound);
        values.put(PokemonTable.POKEMON_IMAGE, image);
        values.put(PokemonTable.POKEMON_SHADOW, shadow);
        values.put(PokemonTable.POKEMON_TYPE, type);
        values.put(PokemonTable.POKEMON_CAUGHT, caught);

        return values;
    }
}
