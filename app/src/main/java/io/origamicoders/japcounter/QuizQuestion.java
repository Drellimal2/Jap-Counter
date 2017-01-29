package io.origamicoders.japcounter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import io.origamicoders.japcounter.Models.Quiz.Question;


public class QuizQuestion extends Fragment {


    private int question_num;

    public QuizQuestion() {
        // Required empty public constructor
    }


    public static QuizQuestion newInstance(int param1) {
        QuizQuestion fragment = new QuizQuestion();
        Bundle args = new Bundle();
        args.putInt("QNUM", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question_num = getArguments().getInt("QNUM");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_quiz_question, container, false);
        final QuizActivity quizActivity = (QuizActivity)getActivity();
        Question question = quizActivity.quiz.getQuestion(question_num);
        TextView ques = (TextView) rootView.findViewById(R.id.quiz_question_ques);
        AppCompatButton opt1 = (AppCompatButton) rootView.findViewById(R.id.quiz_question_opt1);
        AppCompatButton opt2 = (AppCompatButton) rootView.findViewById(R.id.quiz_question_opt2);
        AppCompatButton opt3 = (AppCompatButton) rootView.findViewById(R.id.quiz_question_opt3);
        AppCompatButton opt4 = (AppCompatButton) rootView.findViewById(R.id.quiz_question_opt4);
        AppCompatButton opt5 = (AppCompatButton) rootView.findViewById(R.id.quiz_question_opt5);
        final Toolbar nexttoolbar = (Toolbar) rootView.findViewById(R.id.next_toolbar);
        final AppCompatButton next = (AppCompatButton) rootView.findViewById(R.id.quiz_question_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizActivity.nextPage();
            }
        });
//        final Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.next_toolbar);
        Random random = new Random();
        ques.setText(question.getQues() + "?");
        final int pos = random.nextInt(5);
        final ArrayList<AppCompatButton> buts = new ArrayList<>();
        buts.add(opt1);
        buts.add(opt2);
        buts.add(opt3);
        buts.add(opt4);
        buts.add(opt5);
        buts.get(pos).setText(question.getAnswer());
        View.OnClickListener wrongClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatButton)v).setTextColor(ContextCompat.getColor(getContext(),R.color.wrong_red));
                buts.get(pos).setTextColor(ContextCompat.getColor(getContext(),R.color.right_green));
                nexttoolbar.setVisibility(View.VISIBLE);
            }
        };
        View.OnClickListener rightClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatButton)v).setTextColor(ContextCompat.getColor(getContext(),R.color.right_green));
                nexttoolbar.setVisibility(View.VISIBLE);
                quizActivity.addCorrect();
            }
        };
        buts.get(pos).setOnClickListener(rightClick);
        int y = 0;
        for(int x = 0; x<5; x++){

            if (x!= pos) {

                buts.get(x).setText(question.getOptions().get(y));
                buts.get(x).setOnClickListener(wrongClick);
                y+= 1;
            }
        }
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



}
