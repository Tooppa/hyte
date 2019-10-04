package com.example.hyte;

public class Counter {
    private int var;
    private int minT;
    private String minutes;
    private String hours;

    public Counter(){
        this.var = 0;
    }
    public void add(){
        this.var += 25;

        if(this.minT == 100){
            this.minT = 0;
            this.minT += 25;
        }else{
            this.minT += 25;
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
        if(this.minT == 0) {
            this.minT = 0;
        }else{
            this.minT -= 25;
        }
    }
    public double getVar(){
            return this.var;

    }
    public String getTime(){ //Spagetti that creates counter how i want it
        if(this.minT == 100){
            this.hours = String.valueOf(this.var / 100);
        }else {
            this.hours = String.valueOf((this.var - minT) / 100);
        }
        if(this.minT == 25){
            this.minutes = ":15";
        }else if(this.minT == 50) {
            this.minutes = ":30";
        }else if(this.minT == 75){
            this.minutes = ":45";
        }else{
            this.minutes = ":00";
        }
        return this.hours + this.minutes;

    }
}
