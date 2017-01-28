package io.origamicoders.japcounter.Models.Quiz;

import java.util.ArrayList;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Quiz {
    protected ArrayList<Question> questions;


    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q){

        this.questions.add(q);

    }





}
