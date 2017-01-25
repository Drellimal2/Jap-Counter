package io.origamicoders.japcounter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class QuizFragment extends Fragment {



    public QuizFragment() {
        // Required empty public constructor
    }


    public static QuizFragment newInstance() {
        QuizFragment fragment = new QuizFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_quiz_main, container, false);
        AppCompatSpinner spinner = (AppCompatSpinner)rootview.findViewById(R.id.new_quiz_count);
// Create an ArrayAdapter using the string array and a default spinner layout
// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
        List<String> a = new ArrayList<>();
        a.add("15");
        a.add("25");
        a.add("50");
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, a);
        spinner.setAdapter(spinneradapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootview;
    }

}
