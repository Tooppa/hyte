package com.example.hyte;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
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

        getWindow().setLayout((int)(width*.6),(int)(height*.4)); //The size of the popup window relative to display size

        Bundle b = getIntent().getExtras();
        int i = b.getInt(MainActivity.EXTRA,0); //telling the activity which ListView element was clicked on

        ((TextView)findViewById(R.id.textViewTime)).setText("nukuttu "+GlobalArray.getInstance().getArray().get(i).getTime()+" tuntia"); //setting the time
        ((TextView)findViewById(R.id.textViewHappiness)).setText("Unenlaatu "+GlobalArray.getInstance().getArray().get(i).getHappines()); //and happiness

        if (GlobalArray.getInstance().getArray().get(i).getTimeDouble() > 7.0 && GlobalArray.getInstance().getArray().get(i).getHappinesInt() >= 3) {
            ((ImageView)findViewById(R.id.imageViewThumbUpDown)).setImageResource(R.drawable.thumbsup);
        } else {
            ((ImageView)findViewById(R.id.imageViewThumbUpDown)).setImageResource(R.drawable.thumbsdown);
        }
    }
}
