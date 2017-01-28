package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import io.origamicoders.japcounter.Classes.JapCounter;
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
//        JapCounter japCounter = Data.getJapCounters().get(pos);
        final String key = getArguments().getString("ITEM_KEY");
        rootView = inflater.inflate(R.layout.fragment_recycler_ads, container, false);


        final DetailsActivity detail = (DetailsActivity) getActivity();
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.gen_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DatabaseReference mDatabase = Utils.getDatabase().getReference();

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


    }
