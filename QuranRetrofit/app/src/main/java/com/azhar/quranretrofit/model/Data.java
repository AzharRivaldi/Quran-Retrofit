package com.azhar.quranretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("surahs")
    private List<Surah> surahs;
    private List<Ayat> ayats;
    private Edition edition;

    public Data(List<Surah> surahs, Edition edition) {
        this.surahs = surahs;
        this.edition = edition;
    }

    public Data(List<Surah> surahs, List<Ayat> ayats, Edition edition) {
        this.surahs = surahs;
        this.ayats = ayats;
        this.edition = edition;
    }

    public List<Surah> getSurahs() {
        return surahs;
    }

    public void setSurahs(List<Surah> surahs) {
        this.surahs = surahs;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public List<Ayat> getAyats() {
        return ayats;
    }

    public void setAyats(List<Ayat> ayats) {
        this.ayats = ayats;
    }
}
