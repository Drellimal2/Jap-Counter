package io.origamicoders.japcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

import io.origamicoders.japcounter.Models.Counter;
import io.origamicoders.japcounter.Models.Quiz.Question;
import io.origamicoders.japcounter.Models.Quiz.Quiz;

public class QuizActivity extends AppCompatActivity{


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int num_questions;
    private int num_correct = 0;

    private ViewPager mViewPager;
    public Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent callingIntent = getIntent();
        num_questions = 10;
        if(callingIntent.hasExtra("NUM")){
            num_questions = callingIntent.getIntExtra("NUM", 10);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), num_questions);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        DatabaseReference mDatabase = Utils.getDatabase().getReference();
        Query q = mDatabase.child("counters");
        ValueEventListener v = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(Utils.counters.size() == 0) {
                    for (DataSnapshot d : dataSnapshot.getChildren()) {
                        Utils.counters.add(d.getValue(Counter.class));
                    }
                    Utils.done = true;
                    quiz = makeQuiz();
                    Log.e("TEST", "QUIZ ADDED");

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        q.addValueEventListener(v);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "" + Utils.counters.size(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if(mViewPager.getCurrentItem() < num_questions - 1) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                }
            }
        });*/

    }

    public void nextPage(){
        if(mViewPager.getCurrentItem() < num_questions - 1) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
    }
    public void addCorrect(){
        num_correct += 1;
    }
    private Quiz makeQuiz(){
        Quiz q = new Quiz();
        Random random = new Random();
        int a1,a2,a3,a4,ques,type;
        Counter A1,A2,A3,A4,Ques;
        ArrayList<String> a;
        int l = Utils.counters.size();
        for (int x = 0; x < num_questions; x ++){
            type = random.nextInt(4);
            ques = random.nextInt(l);
            Ques = Utils.counters.get(ques);
            do {
                a1 = random.nextInt(l);
                A1 = Utils.counters.get(a1);
                a2 = random.nextInt(l);
                A2 = Utils.counters.get(a2);
                a3 = random.nextInt(l);
                A3 = Utils.counters.get(a3);
                a4 = random.nextInt(l);
                A4 = Utils.counters.get(a4);
            }while(a1 == ques || a2 == ques || a3 == ques || a4==ques);
            a = new ArrayList<>();
            switch(type){
                case 1:
                    a.add(A1.kana);
                    a.add(A2.kana);
                    a.add(A3.kana);
                    a.add(A4.kana);
                    q.addQuestion(new Question(Ques.uses, Ques.kana, a));
                    break;
                case 2:
                    a.add(A1.kanji);
                    a.add(A2.kanji);
                    a.add(A3.kanji);
                    a.add(A4.kanji);
                    q.addQuestion(new Question(Ques.uses, Ques.kanji, a));
                    break;
                case 3:
                    a.add(A1.uses);
                    a.add(A2.uses);
                    a.add(A3.uses);
                    a.add(A4.uses);
                    q.addQuestion(new Question(Ques.kanji, Ques.uses, a));
                    break;
                default:
                    a.add(A1.kana);
                    a.add(A2.kana);
                    a.add(A3.kana);
                    a.add(A4.kana);
                    q.addQuestion(new Question(Ques.kanji, Ques.kana, a));
                    break;
                    
                    
            }



        }
        return q;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private int count = -1;
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public SectionsPagerAdapter(FragmentManager fm, int count) {
            super(fm);
            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {

            return QuizQuestion.newInstance(position);
        }

        @Override
        public int getCount() {
            if (count == -1) {
                return 3;
            } else{
                return this.count;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
