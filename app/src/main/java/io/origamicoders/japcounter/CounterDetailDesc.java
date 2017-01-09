package io.origamicoders.japcounter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.origamicoders.japcounter.Classes.Data;
import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Models.Counter;

/**
 * Created by DM036497 on 1/4/2017.
 */

public class CounterDetailDesc extends Fragment {
    private TextView kanji;
    private TextView kana;
    private TextView uses;
    private TextView romaji;
    public CounterDetailDesc(){
    }
    private DetailsActivity mActivity;
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
        String key = getArguments().getString("ITEM_KEY");


        View rootView = inflater.inflate(R.layout.fragment_details_desc, container, false);

        MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        JapCounter japCounter = Data.getJapCounters().get(pos);
        kanji = (TextView) rootView.findViewById(R.id.counter_details_desc_kanji);
        kana = (TextView) rootView.findViewById(R.id.counter_details_desc_kana);
        uses = (TextView) rootView.findViewById(R.id.counter_details_desc_uses);
        romaji = (TextView) rootView.findViewById(R.id.counter_details_desc_romaji);
        FirebaseDatabase mDatabase = Utils.getDatabase();
        Query query = mDatabase.getReference().child("counters").child(key);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Counter counter = dataSnapshot.getValue(Counter.class);
                kanji.setText(counter.kanji);
                kana.setText(counter.kana);
                romaji.setText(counter.romaji);
                uses.setText(counter.uses);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("DETAILS", "Details General");
            }
        };

        query.addListenerForSingleValueEvent(valueEventListener);
        mActivity = (DetailsActivity) getActivity();

        Toast.makeText(mActivity, "Ok", Toast.LENGTH_LONG).show();
        return rootView;
    }

}
