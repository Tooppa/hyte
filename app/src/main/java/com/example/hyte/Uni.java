package com.example.hyte;




public class Uni {

    private double time;
    private int happines;
    private static Uni mInstance;


    public Uni(double time, int happines) {
        this.time = time;
        this.happines = happines;
    }

    public String getHappines() {
        return String.valueOf(this.happines);
    }

    public String getTime() {
        return String.valueOf(this.time);
    }
    public double getTimeDouble() {
        return this.time;
    }
    public int getHappinesInt() {
        return this.happines;
    }

    public String toString(){
        return this.time + " " + this.happines;
    }
}