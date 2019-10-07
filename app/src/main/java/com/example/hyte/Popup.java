package com.example.hyte;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Popup extends Activity {
    private static final String EXTRA ="";
    private int i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        SharedPreferences shared = getSharedPreferences("HYTE", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("Uni", null);
        Type type = new TypeToken<ArrayList<Uni>>(){}.getType();
        ArrayList<Uni> data = gson.fromJson(json, type);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(height*.4)); //The size of the popup window relative to display size

        Bundle b = getIntent().getExtras();
        i = b.getInt(MainActivity.EXTRA,0); //telling the activity which ListView element was clicked on

        Button delete = findViewById(R.id.buttonDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",i);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        ((TextView)findViewById(R.id.textViewDate)).setText(data.get(i).getSimpleDate());
        ((TextView)findViewById(R.id.textViewTime)).setText("Nukuttu "+data.get(i).getTime()+" tuntia"); //setting the time
        ((TextView)findViewById(R.id.textViewHappiness)).setText("Unenlaatu "+data.get(i).getHappines()); //and happiness

        if (data.get(i).getTimeDouble() > 7.0 && data.get(i).getHappinesInt() >= 3) {
            ((ImageView)findViewById(R.id.imageViewThumbUpDown)).setImageResource(R.drawable.thumb_up);
        } else {
            ((ImageView)findViewById(R.id.imageViewThumbUpDown)).setImageResource(R.drawable.thumb_down);
        }

    }

}
