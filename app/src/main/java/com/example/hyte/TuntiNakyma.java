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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.YEAR;

public class TuntiNakyma extends AppCompatActivity {
    public static final String TAG = "logging TuntiNakyma";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Analyze analyze = new Analyze
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_tunti_nakyma);
        TextView numero = findViewById(R.id.numero);
        SharedPreferences shared = getSharedPreferences("HYTE", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("Uni", null);
        Type type = new TypeToken<ArrayList<Uni>>(){}.getType();
        ArrayList<Uni> data = gson.fromJson(json, type);
        numero.setText(Analyze);
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