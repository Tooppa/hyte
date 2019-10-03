package com.example.hyte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TuntiNakyma extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tunti_nakyma);
        TextView numero = findViewById(R.id.numero);
        Intent i = getIntent();
        Uni kayttaja = (Uni)i.getSerializableExtra("uniData"); // gets the copy of kayttaja from mainactivity
        numero.setText("happines " + Integer.toString(kayttaja.getHappines()) + " Time " +  Double.toString(kayttaja.getTime()));
    }
}