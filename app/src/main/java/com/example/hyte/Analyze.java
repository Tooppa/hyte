
package com.example.hyte;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.*;
import java.util.*;


import static android.content.Context.MODE_PRIVATE;

/**
 * Luokka sisältää unimäärän analyysiin liittyviä metodeja
 * @author Rush B
 * @version 1.0 8.10.2019
 */
public class Analyze {

    private Context mContext;
    private double averageHours;
    private double averageHappiness;
    private double summaTime;
    private double summaHappiness;
    private SharedPreferences shared;
    private Gson gson;
    private String json;
    private Type type;
    private ArrayList<Uni> data;

    /**
     * Alustetaan muuttujat
     * haetaan ArrayList SharedPreferenceistä
     */
    public Analyze() {
        this.summaTime =0;
        this.averageHours=0;
        this.averageHappiness=0;
        shared = mContext.getSharedPreferences("HYTE", MODE_PRIVATE);
        gson = new Gson();
        json = shared.getString("Uni", null);
        type = new TypeToken<ArrayList<Uni>>() {}.getType();
        data = gson.fromJson(json, type);
    }
    /**
     * Laskee keskimääräisen unimäärän
     * @return keskimääräisen unimäärän tunteina
     */
    public double getAverageHours() {
        for (int i = data.size(); i>0;i-- ) {
            this.summaTime = summaTime + data.get(i).getTimeDouble();
        }
        this.averageHours = summaTime/data.size();
        return averageHours;
    }
    /**
     * laskee keskimääräisen unenlaadun
     * @return keskimääräinen unenlaatu (1-5)
     */
    public double getAverageHappiness() {
        for (int i = data.size(); i>0;i-- ) {
            this.summaHappiness = summaHappiness + data.get(i).getHappinesInt();
        }
        this.averageHappiness = summaHappiness/data.size();
        return averageHappiness;
    }
    /**
     * Käyttää keskimääräistä unenlaatua ja määrää ja antaa yksinkertaisen analyysin
     * @return yksinkertainen analyysi
     */
    public String getAnalyze() {
        if (getAverageHappiness() < 3) {
            return "Keskimääräinen unenlaatusi on huonoa.";
        }
        if (getAverageHours() > 10) {
            return "Nukut liikaa";
        }
        if (getAverageHappiness()>= 3 && getAverageHours() <= 7) {
            return "Nukut hyvin";
        }
        if (getAverageHours()<7) {
            return "Nukut liian vähän";
        }
        else {
            return "";
        }

    }

}
