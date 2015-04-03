package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by songhang on 15/4/3.
 */
public class CountryManger {
    public static final String TAG = "CountryMaster";

    /**
     * 获取默认语言环境下的国家集合
     * @param context
     * @return
     */
    public static ArrayList<Country> getCountryArrayList(Context context) {
        return getCountryArrayList(context, Locale.getDefault());
    }
    /**
     * 得到对应语言环境下的国家的集合
     * @param context
     * @param language  指定语言
     * @return
     */
    public static ArrayList<Country> getCountryArrayList(Context context, Locale language){
        ArrayList<Country> countries = new ArrayList<Country>();
        Resources res = context.getResources();

        // builds country data from json
        InputStream is = res.openRawResource(R.raw.countries);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        JSONArray json = new JSONArray();
        try {
            json = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < json.length(); i++) {
            JSONObject node = json.optJSONObject(i);
            if (node != null) {
                Country country = new Country();
                country.mCountryIso = node.optString("iso");
                country.mDialPrefix = node.optString("tel");
                country.mCountryName = getCountryName(language, node.optString("iso"));
                countries.add(country);
            }
        }
        return countries;
    }

    /**
     * 获取 手机当前使用语言 的国家名字
     * @param language 指定语言
     * @param isoCode  国家iso
     * @return
     */
    private static String getCountryName( Locale language, String isoCode) {
        Locale locale = new Locale("", isoCode);
        return locale.getDisplayCountry(language).trim();
    }
}
