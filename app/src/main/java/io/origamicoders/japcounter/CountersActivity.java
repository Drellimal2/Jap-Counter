package io.origamicoders.japcounter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.ViewHolders.CounterViewHolder;

public class CountersActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<JapCounter> japCounters = new ArrayList<>();
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.home_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        japCounters = getData();

        mDatabase = Utils.getDatabase().getReference();
        final Context a = this;
        final Query counterQuery = mDatabase.child("counters");
        FirebaseRecyclerAdapter mAdapter = new FirebaseRecyclerAdapter<Counter, CounterViewHolder>(Counter.class,
                R.layout.counter_list_item, CounterViewHolder.class, counterQuery){


            @Override
            protected void populateViewHolder(CounterViewHolder viewHolder, Counter model, int position) {
                final DatabaseReference postRef = getRef(position);

                // Set click listener for the whole post view
                final String postKey = postRef.getKey();
                viewHolder.bindToCounter(model, position, postKey);
                long id = getItemId(position);

                setAnimation(viewHolder.mView, position);


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

        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_filter_main:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this, "Filter", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {

                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private ArrayList<JapCounter> getData(){
        return Data.getJapCounters();
    }



}
