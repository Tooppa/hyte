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

public class TuntiNakyma extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tunti_nakyma);
        TextView numero = findViewById(R.id.numero);
        SharedPreferences shared = getSharedPreferences("HYTE", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("Uni", null);
        Type type = new TypeToken<ArrayList<Uni>>(){}.getType();
        ArrayList<Uni> data = gson.fromJson(json, type);
        numero.setText(data.get(0).getHappines());
    }
}