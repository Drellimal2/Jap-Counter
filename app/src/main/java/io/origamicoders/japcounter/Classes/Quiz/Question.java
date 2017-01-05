package io.origamicoders.japcounter.Classes.Quiz;

import java.util.ArrayList;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Question {
    protected String ques;
    protected String answer;
    protected ArrayList<String> options;

    public Question() {
    }

    public Question(String ques, String answer, ArrayList<String> options) {
        this.ques = ques;
        this.answer = answer;
        this.options = options;
    }
}
