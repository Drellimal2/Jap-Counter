package io.origamicoders.japcounter.Classes;

import java.util.ArrayList;

/**
 * Created by DM036497 on 12/29/2016.
 */

public class JapCounter {

    public Word name;
    public String icon;
    public ArrayList<String> uses;
    public ArrayList<JapWord> onetoten;
    public ArrayList<JapWord> examples;

    public JapCounter(ArrayList<JapWord> examples, String icon, Word name, ArrayList<JapWord> onetoten, ArrayList<String> uses) {
        this.examples = examples;
        this.icon = icon;
        this.name = name;
        this.onetoten = onetoten;
        this.uses = uses;
    }

    public JapCounter(Word name, ArrayList<JapWord> onetoten, ArrayList<String> uses) {
        this.examples = null;
        this.icon = null;
        this.name = name;
        this.onetoten = onetoten;
        this.uses = uses;
    }

}
