package com.example.hyte;




public class Uni {

    private double time;
    private int happines;
    private String minutes;
    private String hours;


    public Uni(double time, int happines, String minutes, String hours) {
        this.time = time;
        this.happines = happines;
        this.minutes = minutes;
        this.hours = hours;
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
        String lista = this.hours + " tuntia " + this.minutes + " minuuttia " + " tyytyväisyys " + this.happines;
        return lista;
    }
}