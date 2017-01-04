package io.origamicoders.japcounter.Classes;

/**
 * Created by DM036497 on 12/29/2016.
 */

public class Word {

    protected String kanji;
    protected String kana;
    protected String romaji;

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public Word(String kana, String kanji, String romaji) {
        this.kana = kana;
        this.kanji = kanji;
        this.romaji = romaji;
    }

    public Word() {
    }
}
