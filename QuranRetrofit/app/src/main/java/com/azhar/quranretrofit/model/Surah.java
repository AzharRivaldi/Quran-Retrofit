package com.azhar.quranretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Surah {
    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;

    @SerializedName("englishName")
    private String englishName;

    @SerializedName("englishNameTranslation")
    private String translateName;

    @SerializedName("revelationType")
    private String type;

    @SerializedName("ayahs")
    private List<Ayat> ayatList;

    public Surah(String name, String number, String englishName, String translateName, String type, List<Ayat> ayatList) {
        this.name = name;
        this.number = number;
        this.englishName = englishName;
        this.translateName = translateName;
        this.type = type;
        this.ayatList = ayatList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String translateName) {
        this.translateName = translateName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ayat> getAyatList() {
        return ayatList;
    }

    public void setAyatList(List<Ayat> ayatList) {
        this.ayatList = ayatList;
    }
}
