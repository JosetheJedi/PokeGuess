package com.example.josef.pokeguess;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Josef on 10/25/2017.
 */

public class PokemonItemAdapter extends ArrayAdapter {

    List<Pokemon> mPokemonItems;
    LayoutInflater mInflater;

    public PokemonItemAdapter(Context context, List<Pokemon> objects) {
        super(context, R.layout.activity_pokedex_layouttext, objects);

        mPokemonItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.activity_pokedex_layouttext, parent, false);
        }

        TextView pkmID = (TextView) convertView.findViewById(R.id.pokeNumT);
        TextView pkmName = (TextView) convertView.findViewById(R.id.pokeNamT);
        ImageView pkmImg = (ImageView) convertView.findViewById(R.id.pokeImg);

        Pokemon pokemon = mPokemonItems.get(position);

        pkmID.setText(pokemon.getID());
        pkmName.setText(pokemon.getName());

        // get and render current pokemon image
        String currentImage = "drawable/" + pokemon.getImage();

        int resId = getContext().getResources().getIdentifier(currentImage, null, getContext().getPackageName());

        pkmImg.setImageResource(resId);

        return convertView;
    }
}
