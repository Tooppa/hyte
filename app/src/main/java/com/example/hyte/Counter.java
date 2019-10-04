package com.example.hyte;

public class Counter {
    private double var;

    public Counter(){
        this.var = 0.00;
    }
    public void add(){
        this.var += 0.50; // counter works by 30 min intervals can be changed here
    }
    public void subtract(){
        if(this.var - 0.50 < 0){
            this.var = 0.00;
        }else {
            this.var -= 0.50;
        }
    }
    public double getVar(){
        if(this.var % 1 == 0.50){
            double hour = (this.var - 0.50) + 0.30; // changes variable to hour/min format
            return hour;
        }else {
            return this.var;
        }
    }
}
