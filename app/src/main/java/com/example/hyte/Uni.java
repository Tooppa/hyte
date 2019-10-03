package com.example.hyte;


import java.io.Serializable;

public class Uni implements Serializable {

    private double time;
    private int happines;

    public Uni(double time, int happines) { // simple counter collects time and happines
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
