package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.JapWord;
import io.origamicoders.japcounter.Models.Example;
import io.origamicoders.japcounter.ViewHolders.UsageViewHolder;

/**
 * Created by DM036497 on 1/4/2017.
 */

public class CounterDetailToTen extends Fragment {

    public CounterDetailToTen(){
    }

    public static CounterDetailToTen newInstance(String key, int pos) {
        CounterDetailToTen fragment = new CounterDetailToTen();
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
        View rootView;
        JapCounter japCounter = Data.getJapCounters().get(pos);
        final String key = getArguments().getString("ITEM_KEY");
        rootView = inflater.inflate(R.layout.fragment_recycler_ads, container, false);

        /*MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        final DetailsActivity detail = (DetailsActivity) getActivity();
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.gen_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DatabaseReference mDatabase = Utils.getDatabase().getReference();
        // specify an adapter (see also next example)
//        MyAdapter mAdapter = new MyAdapter(japCounter.onetoten);
        final Query counterQuery = mDatabase.child("samples").child(key);

        FirebaseRecyclerAdapter mAdapter = new FirebaseRecyclerAdapter<Example, UsageViewHolder>(Example.class,
                R.layout.fragment_details_samples, UsageViewHolder.class, counterQuery){


            @Override
            protected void populateViewHolder(UsageViewHolder viewHolder, Example model, int position) {

                viewHolder.bindToUse(model, position, key);
            }



        };
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<JapWord> mDataset;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public View mView;
            public ViewHolder(View v) {
                super(v);
                mView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<JapWord> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_details_samples, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            JapWord japWord = mDataset.get(position);
            View v = holder.mView;
//            TextView kanji = (TextView) v.findViewById(R.id.counter_details_toten_kanji);
//            TextView kana = (TextView) v.findViewById(R.id.counter_details_toten_kana);
//            TextView romaji = (TextView) v.findViewById(R.id.counter_details_toten_romaji);
//            TextView eng = (TextView) v.findViewById(R.id.counter_details_toten_english);

//            kanji.setText(japWord.getKanji());
//            kana.setText(japWord.getKana());
//            romaji.setText(japWord.getRomaji());
//            eng.setText(japWord.english);


        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
