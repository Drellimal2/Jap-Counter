package io.origamicoders.japcounter.Classes;

import java.util.ArrayList;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Data {

    public static ArrayList<JapCounter> japCounters = new ArrayList<>();
    private static ArrayList<JapCounter> getJapCounters(){
        ArrayList<JapCounter> japCounters = new ArrayList<>();

        Header header1 = new Header("Living Things");
        Word nin = new Word("にん", "人",  "nin");
        ArrayList<String> uses = new ArrayList<>();
        uses.add(0, "People");

        Word tsu = new Word("つ","つ","tsu");
        ArrayList<String> tsu_uses = new ArrayList<>();
        tsu_uses.add("General");
        tsu_uses.add("Things");

        Word kai = new Word("かい", "階", "kai");
        ArrayList<String> kai_uses = new ArrayList<>();
        kai_uses.add("Number of Floors");
        kai_uses.add("Stories");


        JapCounter jap = new JapCounter(nin, uses);
        JapCounter jap2 = new JapCounter(tsu, tsu_uses);
        JapCounter jap3 = new JapCounter(kai, kai_uses);

        for (int i = 0; i<30; i++){
            if ( i % 5 == 0){
                japCounters.add(header1);
            }
            switch(i%3){
                case 0:
                    japCounters.add(jap);
                    break;
                case 1:
                    japCounters.add(jap2);
                    break;
                case 2:
                    japCounters.add(jap3);
            }

        }
        return japCounters;
    }

    public static ArrayList<String> get_Num( int i){
        ArrayList<String> res = new ArrayList<>();
        switch(i){
            case 1:
                res.add("一");
                res.add("いち");
                res.add("ichi");
                return res;
            case 2:
                res.add("二");
                res.add("に");
                res.add("ni");
                return res;
            case 3:
                res.add("三");
                res.add("さん");
                res.add("san");
                return res;
            case 41:
                res.add("四");
                res.add("し/よん");
                res.add("shi/yon");
                return res;
            case 4:
                res.add("四");
                res.add("よん");
                res.add("yon");
                return res;
            case 5:
                res.add("五");
                res.add("ご");
                res.add("go");
                return res;
            case 6:
                res.add("六");
                res.add("ろく");
                res.add("roku");
                return res;
            case 71:
                res.add("七");
                res.add("なな/しち");
                res.add("nana/shichi");
                return res;
            case 7:
                res.add("七");
                res.add("なな");
                res.add("nana");
                return res;
            case 8:
                res.add("八");
                res.add("はち");
                res.add("hachi");
                return res;
            case 91:
                res.add("九");
                res.add("きゅう/く");
                res.add("kyuu/ku");
                return res;
            case 9:
                res.add("九");
                res.add("きゅう");
                res.add("kyuu/ku");
                return res;
            case 10:
                res.add("十");
                res.add("じゅう");
                res.add("juu");
                return res;

            default:
                res.add("");
                res.add("");
                res.add("");
                return res;





        }


    }

    public static ArrayList<JapWord> getNumbers(){
        ArrayList<JapWord> Numbers = new ArrayList<>();
        for( int i = 1; i <=100; i++){
            int start = i /10;
            int end = i % 10;
            String kanji = "";
            String kana = "";
            String romaji = "";
            String english = "" + i;
            if (start >= 1){
                if (start > 1){
                    ArrayList<String> s = get_Num(start);
                    kanji += s.get(0);
                    kana += s.get(1) + " ";
                    romaji += s.get(2) + " ";
                }
                ArrayList<String> s = get_Num(10);
                kanji += s.get(0);
                kana += s.get(1) + " ";
                romaji += s.get(2) + " ";

                s = get_Num(end);
                kanji += s.get(0);
                kana += s.get(1) + " ";
                romaji += s.get(2) + " ";

            } else {

                ArrayList<String> s;
                switch (end){
                    case 4:
                        s = get_Num(41);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    case 7:
                        s = get_Num(71);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    case 9:
                        s = get_Num(91);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    default:
                        s = get_Num(end);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                }
            }

            Numbers.add(new JapWord(kana, kanji, romaji, english));


        }


        return Numbers;

    }

}
