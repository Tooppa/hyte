package com.example.hyte;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Analyze {
    private Context mContext;
    private double averageHours;
    private double averageHappiness;
    private double summa;

    public Analyze() {
        this.summa =0;
        this.averageHours=0;
        this.averageHappiness=0;
    }
    public double getAverageHours() {
        SharedPreferences shared = mContext.getSharedPreferences("HYTE", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("Uni", null);
        Type type = new TypeToken<ArrayList<Uni>>() {}.getType();
        ArrayList<Uni> data = gson.fromJson(json, type);

        for (int i = data.size(); i>0;i-- ) {
            this.summa = summa + data.get(i).getTimeDouble();
        }
        this.averageHours = summa/data.size();
        return averageHours;
    }

}
