package com.example.hyte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Uni {

    private double time;
    private int happines;
    private Date date;
    private String day;
    private String month;
    private String year;


    public Uni(double time, int happines) {
        this.time = time;
        this.happines = happines;
        this.date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDay = new SimpleDateFormat("dd");
        this.day = simpleDay.format(date);
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MM");
        this.month = simpleMonth.format(date);
        SimpleDateFormat simpleYear = new SimpleDateFormat("yyyy");
        this.year = simpleYear.format(date);
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
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyy");
        return simpleDate.format(date);
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
        return this.time + " " + this.happines;
    }

}