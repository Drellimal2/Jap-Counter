package io.origamicoders.japcounter.Classes;

/**
 * Created by DM036497 on 12/29/2016.
 */

public class JapWord extends Word {

    public String english;

    public JapWord(String kana, String kanji, String romaji, String english) {
        this.english = english;
        this.kana = kana;
        this.kanji = kanji;
        this.romaji = romaji;
    }
}
