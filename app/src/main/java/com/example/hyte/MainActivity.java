package com.example.hyte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RadioButton r1, r2, r3, r4, r5;
    RadioGroup rGroup;
    int radValue;
    Counter counter;
    TextView tunnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.rad1);
        r2 = findViewById(R.id.rad2);
        r3 = findViewById(R.id.rad3);
        r4 = findViewById(R.id.rad4);
        r5 = findViewById(R.id.rad5);
        rGroup = findViewById(R.id.radGroup);
        counter = new Counter();
        tunnit = findViewById(R.id.tunnit);


        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                counter.add();
                tunnit.setText(String.valueOf(counter.getVar()));
            }
        });
        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.subtract();
                tunnit.setText(String.valueOf(counter.getVar()));
            }
        });

        Button tallenna = findViewById(R.id.tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() { // sets onclick listener to 3 buttons
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TuntiNakyma.class); //creates new intent

                if(r1.getId() == rGroup.getCheckedRadioButtonId()) {
                    radValue = 1;
                }
                else if(r2.getId() == rGroup.getCheckedRadioButtonId()) {
                    radValue = 2;
                }
                else if(r3.getId() == rGroup.getCheckedRadioButtonId()) {
                    radValue = 3;
                }
                else if(r4.getId() == rGroup.getCheckedRadioButtonId()) {
                    radValue = 4;
                }
                else if(r5.getId() == rGroup.getCheckedRadioButtonId()) {
                    radValue = 5;
                }
                Uni kayttaja = new Uni(counter.getVar(), radValue);
                intent.putExtra("uniData", kayttaja); //makes a copy of kayttaja to the new intent trough serializable function
                startActivity(intent);
            }
        });


    }
}
