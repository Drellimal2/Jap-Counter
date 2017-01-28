package io.origamicoders.japcounter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.ViewHolders.CounterViewHolder;

public class CountersFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public CountersFragment() {
    }


    public static CountersFragment newInstance(String param1, String param2) {
        CountersFragment fragment = new CountersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static CountersFragment newInstance() {
        return new CountersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_hundred, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.home_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        DatabaseReference mDatabase = Utils.getDatabase().getReference();
        final Query counterQuery = mDatabase.child("counters").orderByChild("kana");
        FirebaseRecyclerAdapter mAdapter = new FirebaseRecyclerAdapter<Counter, CounterViewHolder>(Counter.class,
                R.layout.counter_list_item, CounterViewHolder.class, counterQuery){


            @Override
            protected void populateViewHolder(CounterViewHolder viewHolder, Counter model, int position) {
                final DatabaseReference postRef = getRef(position);

                final String postKey = postRef.getKey();
                viewHolder.bindToCounter(model, position, postKey);
//                long id = getItemId(position);
                if (model.popular) {
                setAnimation(viewHolder.mView, position);
                }

            }
            private int lastPosition = -1;

            private void setAnimation(View viewToAnimate, int position)
            {

                if (position > lastPosition)
                {
                    Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
                    viewToAnimate.startAnimation(animation);
                    lastPosition = position;
                }
            }

        };
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

}
