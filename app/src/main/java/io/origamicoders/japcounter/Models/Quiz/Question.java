package io.origamicoders.japcounter.Models.Quiz;

import java.util.ArrayList;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Question {
    protected String ques;
    protected String answer;
    protected ArrayList<String> options;

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public Question() {

    }

    public Question(String ques, String answer, ArrayList<String> options) {
        this.ques = ques;
        this.answer = answer;
        this.options = options;
    }
}
