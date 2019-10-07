package com.example.hyte;

public class Counter {
    private int var;
    private int min;
    private String minutes;
    private String hours;

    public Counter(){
        this.var = 0;
    }
    public void add(){
        this.var += 25;

        if(this.min == 100){
            this.min = 0;
            this.min += 25;
        }else{
            this.min += 25;
        }
    }
    public void addHour(){
        this.var += 100;
    }
    public void subtractHour(){
        if(this.var - 100 < 0){
            this.var = 0;
        }else {
            this.var -= 100;
        }
    }
    public void subtract(){
        if(this.var - 25 < 0){
            this.var = 0;
        }else {
            this.var -= 25;
        }
        if(this.min == 0) {
            this.min = 0;
        }else{
            this.min -= 25;
        }
    }
    public double getVar(){
            return this.var;

    }
    public String getMinutes(){
        if(this.min == 25){
            this.minutes = "15";
        }else if(this.min == 50) {
            this.minutes = "30";
        }else if(this.min == 75){
            this.minutes = "45";
        }else{
            this.minutes = "00";
        }
        return this.minutes;
    }
    public String getHours(){
        if(this.min == 100){
            this.hours = String.valueOf(this.var / 100);
        }else {
            this.hours = String.valueOf((this.var - min) / 100);
        }
        return this.hours;
    }
    public String getHourAndMinute(){ //Spagetti that creates counter how i want it
        if(this.min == 100){
            this.hours = String.valueOf(this.var / 100);
        }else {
            this.hours = String.valueOf((this.var - min) / 100);
        }
        if(this.min == 25){
            this.minutes = ":15";
        }else if(this.min == 50) {
            this.minutes = ":30";
        }else if(this.min == 75){
            this.minutes = ":45";
        }else{
            this.minutes = ":00";
        }
        return this.hours + this.minutes;

    }
}
