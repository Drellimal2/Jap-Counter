package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.Data;
import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.JapWord;

/**
 * Created by DM036497 on 1/4/2017.
 */

public class CounterDetailToTen extends Fragment {

    public CounterDetailToTen(){
    }

    public static CounterDetailToTen newInstance(int sectionNumber, int pos) {
        CounterDetailToTen fragment = new CounterDetailToTen();
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
        JapCounter japCounter = Data.getJapCounters().get(pos);

        rootView = inflater.inflate(R.layout.fragment_recycler_ads, container, false);

        MobileAds.initialize(rootView.getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(japCounter.onetoten);
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
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_details_toten, parent, false);
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
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
