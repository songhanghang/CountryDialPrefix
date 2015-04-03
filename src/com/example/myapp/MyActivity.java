package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //获取所有国家的语言
        Locale[] all = Locale.getAvailableLocales();
        for (Locale locale : all) {
            Log.e("语言","国家名字：" + locale.getDisplayCountry() + "语言：" + locale.getLanguage());
        }
        Log.e(this.getClass().getSimpleName(), "++++++++++++++++++++++++++++++++++++++++++++++++++++++/n");


        //获取默认语言环境下的国家信息
        ArrayList<Country> countries = CountryManger.getCountryArrayList(this);
        for (Country country : countries) {
            Log.e("国家", country.toString());
        }

        Log.e(this.getClass().getSimpleName(), "------------------------------------------------------/n");
        //获取指定的国家信息
        ArrayList<Country> countriesByLanguage = CountryManger.getCountryArrayList(this, Locale.ENGLISH);
        for (Country country : countriesByLanguage) {
            Log.e("国家", country.toString());
        }

    }
}
