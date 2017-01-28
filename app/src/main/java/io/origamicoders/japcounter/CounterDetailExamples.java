package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.JapWord;

/**
 * Created by DM036497 on 1/4/2017.
 */

public class CounterDetailExamples extends Fragment {

    public CounterDetailExamples(){
    }

    public static CounterDetailExamples newInstance(int sectionNumber, int pos) {
        CounterDetailExamples fragment = new CounterDetailExamples();
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

        rootView = inflater.inflate(R.layout.fragment_recycler_ads, container, false);

        /*MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        final DetailsActivity detail = (DetailsActivity) getActivity();
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.gen_recycler_view);
        /*mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < 0) {
                    // Scrolling up
                    detail.showToolbar();
                } else {
                    // Scrolling down
                    detail.hideToolbar();
                }
            }
        });*/

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        MyAdapter mAdapter = new MyAdapter(new ArrayList<JapWord>());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<JapWord> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
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
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_details_examples, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            JapWord japWord = mDataset.get(position);
            View v = holder.mView;
            TextView kana = (TextView) v.findViewById(R.id.counter_details_kana);
            TextView romaji = (TextView) v.findViewById(R.id.counter_details_romaji);
            TextView eng = (TextView) v.findViewById(R.id.counter_details_english);

            kana.setText(japWord.getKana());
            romaji.setText(japWord.getRomaji());
            eng.setText(japWord.english);


        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
