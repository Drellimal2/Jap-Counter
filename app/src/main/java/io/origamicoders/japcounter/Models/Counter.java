package io.origamicoders.japcounter.Models;
import com.google.firebase.database.IgnoreExtraProperties;


/**
 * Created by Dane on 1/8/2017.
 */
@IgnoreExtraProperties
public class Counter {
    public String kanji;
    public String kana;
    public String romaji;
    public String uses;
    public String uses_list;
    public Boolean popular;

    public Counter(){

    }

    public Counter(String kanji, String kana, String romaji, String uses, String uses_list, Boolean hot) {
        this.kanji = kanji;
        this.kana = kana;
        this.romaji = romaji;
        this.uses = uses;
        this.popular = hot;
        this.uses_list = uses_list;
    }

    public Counter(String kanji, String kana, String romaji, String uses, Boolean hot) {
        this.kanji = kanji;
        this.kana = kana;
        this.romaji = romaji;
        this.uses = uses;
        this.popular = hot;
        this.uses_list = "";
    }
}
