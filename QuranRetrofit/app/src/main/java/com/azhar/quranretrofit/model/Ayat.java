package com.azhar.quranretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Ayat {

    @SerializedName("number")
    private int numberAyat;

    @SerializedName("text")
    private String text;

    @SerializedName("numberInSurah")
    private String numberInSurah;

    @SerializedName("juz")
    private int juz;

    public Ayat(int numberAyat, String text, String numberInSurah, int juz) {
        this.numberAyat = numberAyat;
        this.text = text;
        this.numberInSurah = numberInSurah;
        this.juz = juz;
    }

    public int getNumberAyat() {
        return numberAyat;
    }

    public void setNumberAyat(int numberAyat) {
        this.numberAyat = numberAyat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNumberInSurah() {
        return numberInSurah;
    }

    public void setNumberInSurah(String numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }
}
