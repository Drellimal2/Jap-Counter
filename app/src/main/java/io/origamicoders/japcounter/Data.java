package io.origamicoders.japcounter;

import android.util.Log;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.JapWord;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Data {

    private static ArrayList<JapCounter> japCounters = new ArrayList<>();
    private static ArrayList<JapWord> nums = new ArrayList<>();

    static ArrayList<JapCounter> getJapCounters(){
        System.out.println(Data.japCounters.size());

        if (Data.japCounters.size() != 0){
            return Data.japCounters;
        }

        ArrayList<JapCounter> japCounters = new ArrayList<>();

        Data.japCounters = japCounters;
        return japCounters;
    }

    private static ArrayList<String> get_Num(int i){
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
                res.add("kyuu");
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
        if (Data.nums.size() != 0 ){
            Log.e("Nums","Nums woo");
            return Data.nums;
        }
        ArrayList<JapWord> Numbers = new ArrayList<>();
        for( int i = 1; i <100; i++){
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
        Numbers.add(new JapWord("ひゃく","百","hyaku", "100"));
        Data.nums = Numbers;
        return Numbers;

    }

}
