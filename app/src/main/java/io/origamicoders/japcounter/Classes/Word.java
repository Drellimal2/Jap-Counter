package io.origamicoders.japcounter.Classes;

/**
 * Created by DM036497 on 12/29/2016.
 */

public class Word {

    public String kanji;
    public String kana;
    public String romaji;

    public Word(String kana, String kanji, String romaji) {
        this.kana = kana;
        this.kanji = kanji;
        this.romaji = romaji;
    }

    public Word() {
    }
}
