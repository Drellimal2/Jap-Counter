package io.origamicoders.japcounter.ViewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.origamicoders.japcounter.DetailsActivity;
import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.Models.Example;
import io.origamicoders.japcounter.R;

/**
 * Created by DM036497 on 1/8/2017.
 */

public class UsageViewHolder extends RecyclerView.ViewHolder {

    // each data item is just a string in this case
    public View mView;
    public TextView kanji;
    public TextView kana;
    public TextView romaji;
    public TextView english;


    public void clearAnimation()
    {
        mView.clearAnimation();
    }

    public UsageViewHolder(View v) {
        super(v);
        mView = v;

        kanji = (TextView) mView.findViewById(R.id.counter_details_kanji);
        kana = (TextView) mView.findViewById(R.id.counter_details_kana);
        romaji = (TextView) mView.findViewById(R.id.counter_details_romaji);
        english = (TextView) mView.findViewById(R.id.counter_details_english);

    }

    public void bindToUse(final Example usage, final int position, final String key){
        kanji.setText(usage.kanji);
        kana.setText(usage.kana);
        romaji.setText(usage.romaji);
        english.setText(usage.english);
        
    }

}
