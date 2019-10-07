package com.example.hyte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Uni {

    private double time;
    private int happines;
    private String minutes;
    private String hours;
    private Date date;
    private String day;
    private String month;
    private String year;
    private String dateFormat;


    public Uni(double time, int happines, String minutes, String hours) {
        this.time = time;
        this.happines = happines;
        this.date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDay = new SimpleDateFormat("dd");
        this.day = simpleDay.format(date);
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MM");
        this.month = simpleMonth.format(date);
        SimpleDateFormat simpleYear = new SimpleDateFormat("yyyy");
        this.year = simpleYear.format(date);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyy");
        this.dateFormat = simpleDate.format(date);
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
    public String getSimpleDate() { //tulostaa päivän muodossa dd/MM/yyyy
        return this.dateFormat;
    }
    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }

    public String toString(){
        String lista = this.hours + " tuntia " + this.minutes + " minuuttia " + " tyytyväisyys " + this.happines + " " + this.dateFormat;
        return lista;
    }
}