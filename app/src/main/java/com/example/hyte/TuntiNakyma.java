package com.example.hyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.YEAR;

public class TuntiNakyma extends AppCompatActivity {
    public static final String TAG = "logging TuntiNakyma";
    BarChart barChart;
    TextView numero;
    SharedPreferences shared;
    Gson gson;
    String json;
    Type type;
    ArrayList<Uni> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_tunti_nakyma);
        numero = findViewById(R.id.numero);
        barChart = findViewById(R.id.barGraph);
        shared = getSharedPreferences("HYTE", MODE_PRIVATE);
        gson = new Gson();
        json = shared.getString("Uni", null);
        type = new TypeToken<ArrayList<Uni>>(){}.getType();
        data = gson.fromJson(json, type);

        List<BarEntry> entries = new ArrayList<BarEntry>();
        for (Uni data : data) {
            // turn your data into Entry objects
            entries.add(new BarEntry(data.getWeekDayInt(), data.getTimeFloat()));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Label"); // add entries to dataset
        BarData lineData = new BarData(dataSet);
        barChart.setData(lineData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleXEnabled(true);
        barChart.invalidate();


/*
        ArrayList<BarEntry> barEntry = new ArrayList<>();
        barEntry.add(new BarEntry(4f,0));
        barEntry.add(new BarEntry(4f,1));
        barEntry.add(new BarEntry(4f,2));
        barEntry.add(new BarEntry(4f,3));
        barEntry.add(new BarEntry(4f,4));
        barEntry.add(new BarEntry(4f,5));
        barEntry.add(new BarEntry(4f,6));
        BarDataSet barData = new BarDataSet(barEntry, "days");
        ArrayList<String> dates = new ArrayList<>();
        dates.add("Maanatai");
        dates.add("Tiistai");
        dates.add("Keskiviikko");
        dates.add("Torstai");
        dates.add("Perjantai");
        dates.add("Lauantai");
        dates.add("Sunnutai");
        BarData graph = new BarData();
        barChart.setData(graph);

 */
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

}