package io.origamicoders.japcounter.ViewHolders;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.origamicoders.japcounter.Classes.Header;
import io.origamicoders.japcounter.DetailsActivity;
import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.R;
import io.origamicoders.japcounter.Utils;

/**
 * Created by DM036497 on 1/8/2017.
 */

public class CounterViewHolder extends RecyclerView.ViewHolder {

    // each data item is just a string in this case
    public View mView;
    public TextView title;
    public TextView kana;
    public TextView romaji;
    public TextView uses;
    public ImageView hot;
    public ImageView fav;

    public void clearAnimation()
    {
        mView.clearAnimation();
    }

    public CounterViewHolder(View v) {
        super(v);
        mView = v;

        final Intent intent = new Intent(v.getContext(), DetailsActivity.class);
        title = (TextView) mView.findViewById(R.id.counter_list_item_title);
        kana = (TextView) mView.findViewById(R.id.counter_list_item_kana);
        romaji = (TextView) mView.findViewById(R.id.counter_list_item_romaji);
        uses = (TextView) mView.findViewById(R.id.counter_list_item_info_text);

        hot = (ImageView) mView.findViewById(R.id.counter_list_item_icon_flame);
        fav = (ImageView) mView.findViewById(R.id.counter_list_item_icon_like);

    }

    public void bindToCounter(final Counter counter, final int position, final String key){
        title.setText(counter.kanji);
        kana.setText(counter.kana);
        romaji.setText(counter.romaji);
        uses.setText(counter.uses);
        if(counter.popular){
            hot.setVisibility(View.VISIBLE);
        }
        final Intent a = new Intent(mView.getContext(), DetailsActivity.class);
        a.putExtra("ITEM_POS", position);
        a.putExtra("ITEM_KEY", key);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.getContext().startActivity(a);
                Toast.makeText(mView.getContext(), key, Toast.LENGTH_LONG).show();
            }

        });
    }

}

