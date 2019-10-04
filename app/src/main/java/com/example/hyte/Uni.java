package com.example.hyte;




public class Uni {

    private double time;
    private int happines;
    private static Uni mInstance;


    public Uni(double time, int happines) {
        this.time = time;
        this.happines = happines;
    }

    public int getHappines() {
        return happines;
    }

    public double getTime() {
        return time;
    }

    public String toString(){
        return this.time + " " + this.happines;
    }
}