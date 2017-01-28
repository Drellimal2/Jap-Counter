package io.origamicoders.japcounter.ViewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
    public CheckBox fav;

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
        fav = (CheckBox) mView.findViewById(R.id.counter_list_item_icon_like);

    }

    public void bindToCounter(final Counter counter, final int position, final String key){
        kana.setText(counter.kana);
        romaji.setText(counter.romaji);
        uses.setText(counter.uses);
        if(counter.popular){
            hot.setVisibility(View.VISIBLE);
        }
        if (counter.kanji != null){
            title.setText(counter.kanji);
        } /*else{
            title.setVisibility(View.GONE);
        }*/
        final Intent a = new Intent(mView.getContext(), DetailsActivity.class);
        final DatabaseReference mDatabase = Utils.getDatabase().getReference();
        final FirebaseUser user = Utils.getCurrentUser();
        ValueEventListener likelistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    fav.setChecked(Boolean.parseBoolean(dataSnapshot.getValue().toString()));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        Query likequery = mDatabase.child("user_favorites").child(user.getUid()).child(key);
        likequery.addListenerForSingleValueEvent(likelistener);



        fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mDatabase.child("user_favorites").child(user.getUid()).child(key).setValue(b);
            }
        });

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

