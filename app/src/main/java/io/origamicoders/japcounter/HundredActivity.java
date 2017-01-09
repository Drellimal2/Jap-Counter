package io.origamicoders.japcounter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.Data;
import io.origamicoders.japcounter.Classes.JapWord;

public class HundredActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<JapWord> japnums = new ArrayList<>();
    public static FragmentManager frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.home_recycler_view);


        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        japnums = Data.getNumbers();
        NumberAdapter mAdapter = new NumberAdapter(japnums);
        mRecyclerView.setAdapter(mAdapter);
        frag = getSupportFragmentManager();
//        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }

    public static FragmentManager getFrag(){
        return frag;
    }
}
