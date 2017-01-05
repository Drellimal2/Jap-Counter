package io.origamicoders.japcounter.Classes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.origamicoders.japcounter.R;


public class NumberDetails extends AppCompatDialogFragment {

    private ArrayList<JapWord> nums;
    private int pos;

    public NumberDetails() {
        // Required empty public constructor
    }




    public static NumberDetails newInstance(ArrayList<JapWord> param1, int param2) {
        NumberDetails fragment = new NumberDetails();
        Bundle args = new Bundle();
        args.putInt("POS", param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static NumberDetails newInstance(int param2) {
        NumberDetails fragment = new NumberDetails();
        Bundle args = new Bundle();
        args.putInt("POS", param2);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pos = getArguments().getInt("POS");
        }
        nums = Data.getNumbers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_number_details, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.number_detail_title);
        TextView kanji = (TextView) rootView.findViewById(R.id.number_detail_kanji);
        TextView kana = (TextView) rootView.findViewById(R.id.number_detail_kana);
        TextView romaji = (TextView) rootView.findViewById(R.id.number_detail_romaji);
        TextView num = (TextView) rootView.findViewById(R.id.number_detail_num);

        JapWord word = nums.get(pos);
        title.setText(word.getKanji());
        kanji.setText(word.getKanji());
        kana.setText(word.getKana());
        num.setText(word.english);
        romaji.setText(word.getRomaji());

        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.fragment_number_details, null, false);
        TextView title = (TextView) rootView.findViewById(R.id.number_detail_title);
        TextView kanji = (TextView) rootView.findViewById(R.id.number_detail_kanji);
        TextView kana = (TextView) rootView.findViewById(R.id.number_detail_kana);
        TextView romaji = (TextView) rootView.findViewById(R.id.number_detail_romaji);
        TextView num = (TextView) rootView.findViewById(R.id.number_detail_num);

        JapWord word = nums.get(pos);
        title.setText(word.getKanji());
        kanji.setText(word.getKanji());
        kana.setText(word.getKana());
        num.setText(word.english);
        romaji.setText(word.getRomaji());
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(rootView);
        return builder.create();
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
    }
}
