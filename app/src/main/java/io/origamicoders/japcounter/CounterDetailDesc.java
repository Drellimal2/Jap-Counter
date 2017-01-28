package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.Models.Note;

/**
 * Created by Dane on 1/4/2017.
 */

public class CounterDetailDesc extends Fragment {
    private TextView kanji;
    private TextView kana;
    private TextView uses, uses_list;
    private TextView romaji;
    private CheckBox like;
    private TextView notes;
    private CardView notesCard;
    public CounterDetailDesc(){
    }

    public static CounterDetailDesc newInstance(String key, int pos) {
        CounterDetailDesc fragment = new CounterDetailDesc();
        Bundle args = new Bundle();
        args.putInt("POS", pos);
        args.putString("ITEM_KEY", key);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int pos = getArguments().getInt("POS");
        final String key = getArguments().getString("ITEM_KEY");


        View rootView = inflater.inflate(R.layout.fragment_details_desc, container, false);

//        MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
//        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


        kanji = (TextView) rootView.findViewById(R.id.counter_details_desc_kanji);
        kana = (TextView) rootView.findViewById(R.id.counter_details_desc_kana);
        uses = (TextView) rootView.findViewById(R.id.counter_details_desc_uses);
        uses_list = (TextView) rootView.findViewById(R.id.counter_details_desc_uses_list);
        romaji = (TextView) rootView.findViewById(R.id.counter_details_desc_romaji);
        notes = (TextView) rootView.findViewById(R.id.counter_details_desc_notes_list);
        like = (CheckBox) rootView.findViewById(R.id.counter_details_desc_like);
        notesCard = (CardView) rootView.findViewById(R.id.card_notes);
        final DatabaseReference mDatabase = Utils.getDatabase().getReference();

        Query query = mDatabase.child("counters").child(key);
        final FirebaseUser user = Utils.getCurrentUser();
        ValueEventListener likelistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null) {
                    like.setChecked(Boolean.parseBoolean(dataSnapshot.getValue().toString()));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Counter counter = dataSnapshot.getValue(Counter.class);
                kanji.setText(counter.kanji);
                kana.setText(counter.kana);
                romaji.setText(counter.romaji);
                uses.setText(counter.uses);
                if (null != counter.uses_list) {
                    uses_list.setText(counter.uses_list);
                } else {
                    uses_list.setText(counter.uses);
                }

                like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        mDatabase.child("user_favorites").child(user.getUid()).child(key).setValue(b);
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("DETAILS", "Details General");
            }


        };
        ValueEventListener notesEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = 0;
                String res = "";
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    Note a = ds.getValue(Note.class);
                    res += "- " + a.note + "\n";
                    count += 1;
                }
                if (count == 0){
                    notesCard.setVisibility(View.GONE);

                } else{
                    notesCard.setVisibility(View.VISIBLE);
                    notes.setText(res);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("DETAILS", "Details General");
            }


        };
        Query likequery = mDatabase.child("user_favorites").child(user.getUid()).child(key);
        Query notes = mDatabase.child("notes").child(key);
        notes.addValueEventListener(notesEventListener);
        likequery.addListenerForSingleValueEvent(likelistener);
        query.addListenerForSingleValueEvent(valueEventListener);
        DetailsActivity mActivity = (DetailsActivity) getActivity();



        return rootView;
    }

}
