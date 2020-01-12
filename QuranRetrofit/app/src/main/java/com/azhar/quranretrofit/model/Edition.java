package com.azhar.quranretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Edition {
    @SerializedName("identifier")
    private String identifier;

    @SerializedName("language")
    private String lang;

    @SerializedName("name")
    private String name;

    @SerializedName("englishName")
    private String englishName;

    @SerializedName("format")
    private String format;

    @SerializedName("type")
    private String type;

    public Edition(){
        super();
    }

    public Edition(String identifier, String lang, String name, String englishName, String format, String type) {
        this.identifier = identifier;
        this.lang = lang;
        this.name = name;
        this.englishName = englishName;
        this.format = format;
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
