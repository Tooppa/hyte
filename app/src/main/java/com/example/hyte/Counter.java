package com.example.hyte;

public class Counter {
    private int var;
    private int minT;

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
    public String getHours(){
        if(this.minT == 100){
            return String.valueOf(this.var / 100);
        }else {
            return String.valueOf((this.var - minT) / 100);
        }

    }
    public String getMinutes(){

        if(this.minT == 25){
            return ":15";
        }else if(this.minT == 50) {
            return ":30";
        }else if(this.minT == 75){
            return ":45";
        }else{
            return ":00";
        }

    }
}
