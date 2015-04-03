package com.example.myapp;

/**
 * Created by songhang on 15/4/3.
 */
public class Country {
    public String mCountryName = "";
    public String mCountryLanguage = "";
    public String mCountryIso = "";
    public String mDialPrefix = "";

    @Override
    public String toString() {
        return "Country{" +
                "mCountryName='" + mCountryName + '\'' +
                ", mCountryLanguage='" + mCountryLanguage + '\'' +
                ", mCountryIso='" + mCountryIso + '\'' +
                ", mDialPrefix='" + mDialPrefix + '\'' +
                '}';
    }
}
