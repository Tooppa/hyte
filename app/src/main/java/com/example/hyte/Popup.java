package com.example.hyte;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Popup extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(height*.4));

        Bundle b = getIntent().getExtras();
        int i = b.getInt(MainActivity.EXTRA,0);

        ((TextView)findViewById(R.id.textViewTime)).setText(GlobalArray.getInstance().getArray().get(i).getTime());
        ((TextView)findViewById(R.id.textViewHappyness)).setText(GlobalArray.getInstance().getArray().get(i).getHappines());

    }
}
