package com.example.hyte;

import static java.lang.String.valueOf;

public class Counter {
    private int value;

    public Counter(){
        this.value = 0;
    }
    public void add(){
        this.value +=15;
    }
    public void addHour(){
        this.value +=60;
    }
    public void subtractHour(){
        if (this.value - 60 < 0) {
            this.value = 0;
        } else {
            this.value -=60;
        }
    }
    public void subtract(){
        if (this.value - 15 < 0) {
            this.value = 0;
        } else {
            this.value -= 15;
        }
    }
    public double getTime() {
        return this.value/60;
    }
    public String getMinutes() {
        if (this.value%60 == 0) {
            return "00";
        }else {
            return valueOf(this.value % 60);
        }
    }

    public String getHours() {
        double hoursDouble = this.value/60;
        return valueOf(Math.round(hoursDouble));
    }

    public String getHourAndMinute(){
        return getHours()+":"+getMinutes();
    }
    public String getValue() {
        return valueOf(this.value);
    }

}
