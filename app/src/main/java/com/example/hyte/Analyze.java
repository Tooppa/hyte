package com.example.hyte;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static android.content.Context.MODE_PRIVATE;

public class Analyze {
    private Context mContext;
    private double averageHours;
    private double averageHappiness;
    private double summa;
    private SharedPreferences shared;
    private Gson gson;
    private String json;
    private Type type;
    private ArrayList<Uni> data;

    public Analyze() {
        this.summa =0;
        this.averageHours=0;
        this.averageHappiness=0;
        shared = mContext.getSharedPreferences("HYTE", MODE_PRIVATE);
        gson = new Gson();
        json = shared.getString("Uni", null);
        type = new TypeToken<ArrayList<Uni>>() {}.getType();
        data = gson.fromJson(json, type);
    }
    public double getAverageHours() {

        for (int i = data.size(); i>0;i-- ) {
            this.summa = summa + data.get(i).getTimeDouble();
        }
        this.averageHours = summa/data.size();
        return averageHours;
    }

}
