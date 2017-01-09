package io.origamicoders.japcounter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.origamicoders.japcounter.Classes.Data;
import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Models.Counter;

public class DetailsActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private ViewPager mViewPager;
    private Counter counter;
    private FirebaseDatabase mDatabase;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        int item_pos = i.getIntExtra("ITEM_POS", 0);
        key = i.getStringExtra("ITEM_KEY");

        mDatabase = Utils.getDatabase();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), item_pos);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        getCounter();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        JapCounter a = Data.getJapCounters().get(item_pos);
//        getSupportActionBar().setTitle(a.name.getKanji() + " - " + a.usesToString());


    }

    public Counter getCounter(){
        if (counter == null) {
            Query query = mDatabase.getReference().child("counters").child(key);
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    counter = dataSnapshot.getValue(Counter.class);
                    retcounter(counter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("DETAILS", "Details General");
                }
            };

            query.addListenerForSingleValueEvent(valueEventListener);
        }
        return this.counter;


    }

    public Counter retcounter(Counter coun){
        this.counter =  coun;
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        getSupportActionBar().setTitle(coun.kanji + " - " + coun.uses);

        return this.counter;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, int pos) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putInt("POS", pos);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int a = getArguments().getInt(ARG_SECTION_NUMBER);
            int pos = getArguments().getInt("POS");
            View rootView;
            switch(a-1){
                case 0:
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
                    break;
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_details_toten, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_details_examples, container, false);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_details_desc, container, false);
                    break;

            }

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        int pos;
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public SectionsPagerAdapter(FragmentManager fm, int pos) {
            super(fm);
            this.pos = pos;
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    return CounterDetailDesc.newInstance(key, this.pos);
                case 1:
                    return CounterDetailToTen.newInstance(key, this.pos);
                case 2:
                    return CounterDetailExamples.newInstance(2, this.pos);
            }
            return PlaceholderFragment.newInstance(position + 1, this.pos);

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Description";
                case 1:
                    return "1 to 10";
                case 2:
                    return "Examples";
            }
            return null;
        }
    }
}
