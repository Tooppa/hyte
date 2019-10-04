package com.example.hyte;


import android.provider.Settings;


public class Uni {

    private double time;
    private int happines;
    private static Uni mInstance;


    public static Uni getInstance(){
        if(mInstance == null) {
            mInstance = new Uni();
        }
        return mInstance;
    }
    private Uni() {
        this.time = 0;
        this.happines = 0;
    }
    public void setTimeHappines(double time, int happines) {
        this.time = time;
        this.happines = happines;
    }

    public int getHappines() {
        return happines;
    }

    public double getTime() {
        return time;
    }
}