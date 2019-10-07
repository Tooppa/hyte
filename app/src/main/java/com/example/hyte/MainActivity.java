package com.example.hyte;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RadioButton r1, r2, r3, r4, r5;
    ImageButton plus, minus, plus1, minus1;
    RadioGroup rGroup;
    int radValue;
    Counter counter;
    TextView tunnit;
    ArrayList<Uni> array;
    ListView list;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    public static final String EXTRA = "";
    public static final String TAG = "logging MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //creates button to the navbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.forward_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.forwardB:
                Intent intent = new Intent(getBaseContext(), TuntiNakyma.class); //creates new intent when navbar button is clicked
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        shared = getSharedPreferences("HYTE", MODE_PRIVATE);
        editor = shared.edit();
        r1 = findViewById(R.id.rad1);
        r2 = findViewById(R.id.rad2);
        r3 = findViewById(R.id.rad3);
        r4 = findViewById(R.id.rad4);
        r5 = findViewById(R.id.rad5);
        plus = findViewById(R.id.plus);
        plus1 = findViewById(R.id.plus1h);
        minus = findViewById(R.id.minus);
        minus1 = findViewById(R.id.minus1h);
        rGroup = findViewById(R.id.radGroup);
        counter = new Counter();
        tunnit = findViewById(R.id.tunnit);
        list = findViewById(R.id.listview);
        Gson gson = new Gson();
        String json = shared.getString("Uni", null);
        if(json == null){ // checks that shared hasnt been created if not creates new arraylist
            array = new ArrayList<>();
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array);
            list.setAdapter(adapter);
        }else{ // if it has been created it copies old to new arraylist
            Type type = new TypeToken<ArrayList<Uni>>(){}.getType();
            array = gson.fromJson(json, type);
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array);
            list.setAdapter(adapter);
        }

        // onclick listener for all buttons
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                counter.add();
                tunnit.setText(counter.getHourAndMinute());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.subtract();
                tunnit.setText(counter.getHourAndMinute());
            }
        });
        plus1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                counter.addHour();
                tunnit.setText(counter.getHourAndMinute());
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.subtractHour();
                tunnit.setText(counter.getHourAndMinute());
            }
        });
        Button tallenna = findViewById(R.id.tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() {
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
                Uni uni = new Uni((counter.getVar()/100), radValue, counter.getMinutes(), counter.getHours());
                array.add(uni);
                Gson gson = new Gson();
                String json = gson.toJson(array);
                editor.putString("Uni", json);
                editor.commit();
                list.invalidateViews();
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() { //tapping the ListView opens up a popup window
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextactivity = new Intent(MainActivity.this,Popup.class);
                nextactivity.putExtra(EXTRA, i);
                startActivityForResult(nextactivity,1);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                int result = data.getIntExtra("result",0);
                array.remove(result);
                Gson gson = new Gson();
                String json = gson.toJson(array);
                editor.putString("Uni", json);
                list.invalidateViews();
                editor.commit();
            }
        }

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

