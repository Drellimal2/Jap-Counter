package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import io.origamicoders.japcounter.Classes.Data;
import io.origamicoders.japcounter.Classes.JapCounter;

/**
 * Created by DM036497 on 1/4/2017.
 */

public class CounterDetailDesc extends Fragment {

    public CounterDetailDesc(){
    }

    public static CounterDetailDesc newInstance(int sectionNumber, int pos) {
        CounterDetailDesc fragment = new CounterDetailDesc();
        Bundle args = new Bundle();
        args.putInt("POS", pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int pos = getArguments().getInt("POS");
        View rootView;

        rootView = inflater.inflate(R.layout.fragment_details_desc, container, false);

        MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        JapCounter japCounter = Data.getJapCounters().get(pos);
        TextView kanji = (TextView) rootView.findViewById(R.id.counter_details_desc_kanji);
        TextView kana = (TextView) rootView.findViewById(R.id.counter_details_desc_kana);
        TextView uses = (TextView) rootView.findViewById(R.id.counter_details_desc_uses);
        TextView romaji = (TextView) rootView.findViewById(R.id.counter_details_desc_romaji);

        kanji.setText(japCounter.name.getKanji());
        kana.setText(japCounter.name.getKana());
        romaji.setText(japCounter.name.getRomaji());
        uses.setText(japCounter.usesToList());
        return rootView;
    }

}
