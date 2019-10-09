
package com.example.hyte;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Class contains method that is used to analyze your sleeping habits
 * @author Rush B
 * @version 2.0 8.10.2019
 */
public class Analyze {

    private Context mContext;
    private double averageHours;
    private double averageHappiness;
    private SharedPreferences shared;
    private Gson gson;
    private String json;
    private Type type;
    private ArrayList<Uni> data;

    /**
     * The variables are initialized
     */
    public Analyze(double averageHours, double averageHappiness) {
        this.averageHours=averageHours;
        this.averageHappiness=averageHappiness;
    }

    /**
     * Uses the values of averageHours and averageHappiness variables to analyze sleep
     * @return simple analysis
     */
    public String getAnalyze() {
        if (this.averageHappiness < 3) {
            return "Keskimääräinen unenlaatusi on huonoa.";
        }
        if (this.averageHours > 10) {
            return "Nukut liikaa";
        }
        if (this.averageHappiness >= 3 && this.averageHours >= 7) {
            return "Nukut hyvin";
        }
        if (this.averageHours <7) {
            return "Nukut liian vähän";
        }
        else {
            return "";
        }

    }

}
