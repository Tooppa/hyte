package com.example.hyte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RadioButton r1, r2, r3, r4, r5;
    RadioGroup rGroup;
    int radValue;
    Counter counter;
    TextView tunnit;
    TextView minutes;
    public static final String EXTRA = "";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.forward_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.forwardB:
                Intent intent = new Intent(getBaseContext(), TuntiNakyma.class); //creates new intent
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

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
        minutes = findViewById(R.id.minutes);
        final ListView list = findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, GlobalArray.getInstance().getArray());
        list.setAdapter(adapter);



        ImageButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                counter.add();
                tunnit.setText(counter.getHours());
                minutes.setText(counter.getMinutes());
            }
        });
        final ImageButton minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.subtract();
                tunnit.setText(counter.getHours());
                minutes.setText(counter.getMinutes());
            }
        });

        Button tallenna = findViewById(R.id.tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() { // sets onclick listener to 3 buttons
            @Override
            public void onClick(View view) {

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
                Uni uni = new Uni(counter.getVar(), radValue);
                GlobalArray.getInstance().addToArray(uni);
                list.invalidateViews();
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() { //tapping the ListView opens up a popup window
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextactivity = new Intent(MainActivity.this,Popup.class);
                nextactivity.putExtra(EXTRA, i);
                startActivity(nextactivity);

            }
        });


    }
}
