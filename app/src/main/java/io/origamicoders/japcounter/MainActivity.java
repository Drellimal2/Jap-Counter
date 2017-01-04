package io.origamicoders.japcounter;

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
import android.widget.Toast;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.Header;
import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.Word;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<JapCounter> japCounters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.home_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        getData();
        CounterAdapter mAdapter = new CounterAdapter(japCounters);
        mRecyclerView.setAdapter(mAdapter);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
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

    private void getData(){
        Header header1 = new Header("Living Things");
        Word nin = new Word("にん", "人",  "nin");
        ArrayList<String> uses = new ArrayList<>();
        uses.add(0, "People");

        Word tsu = new Word("つ","つ","tsu");
        ArrayList<String> tsu_uses = new ArrayList<>();
        tsu_uses.add("General");
        tsu_uses.add("Things");

        Word kai = new Word("かい", "階", "kai");
        ArrayList<String> kai_uses = new ArrayList<>();
        kai_uses.add("Number of Floors");
        kai_uses.add("Stories");


        JapCounter jap = new JapCounter(nin, uses);
        JapCounter jap2 = new JapCounter(tsu, tsu_uses);
        JapCounter jap3 = new JapCounter(kai, kai_uses);

        for (int i = 0; i<30; i++){
            if ( i % 5 == 0){
                japCounters.add(header1);
            }
            switch(i%3){
                case 0:
                    japCounters.add(jap);
                    break;
                case 1:
                    japCounters.add(jap2);
                    break;
                case 2:
                    japCounters.add(jap3);
            }

        }

    }

}
