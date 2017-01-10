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


    public JapCounter() {
        this.examples = null;
        this.icon = null;
        this.name = null;
        this.onetoten = null;
        this.uses = null;
    }

    public String usesToString(){
        String useslist = this.uses.get(0);

        int s = this.uses.size();
        if (s > 1) {
            for (String use : this.uses.subList(1, s)) {
                useslist = useslist.concat(", " + use);
            }
        }
        return useslist;
    }

    public String usesToList(){
        String useslist = "• " + this.uses.get(0);

        int s = this.uses.size();
        if (s > 1) {
            for (String use : this.uses.subList(1, s)) {
                useslist = useslist.concat("\n• " + use);
            }
        }
        return useslist;
    }

    public JapCounter(ArrayList<JapWord> examples, String icon, Word name, ArrayList<JapWord> onetoten, ArrayList<String> uses) {
        this.examples = examples;
        this.icon = icon;
        this.name = name;
        this.onetoten = onetoten;
        this.uses = uses;
    }

    public JapCounter(Word name, ArrayList<JapWord> onetoten, ArrayList<String> uses) {
        this.examples = new ArrayList<>();
        this.icon = null;
        this.name = name;
        this.onetoten = onetoten;
        this.uses = uses;
    }

    public JapCounter(Word name, ArrayList<String> uses) {
        this.examples = new ArrayList<>();
        this.icon = null;
        this.name = name;
        this.onetoten = new ArrayList<>();
        this.uses = uses;
    }

    public void addonetoten(JapWord j){
        this.onetoten.add(j);
    }

    public void addexample(JapWord j){
        this.examples.add(j);
    }

}
