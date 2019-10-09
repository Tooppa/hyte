package com.example.hyte;

import static java.lang.String.valueOf;

/**
 * Simple counter, in which minutes can be added up in
 * @version 2.0 8.10
 * @author Rush B
 */
public class Counter {
    private int value;

    /**
     * Creates the counter and resets it
     */
    public Counter(){
        this.value = 0;
    }

    /**
     * Adds 15 minutes to the counter
     */
    public void add(){
        this.value +=15;
    }

    /**
     * Adds an hour (60 minutes) to the counter
     */
    public void addHour(){
        this.value +=60;
    }

    /**
     * Subtracts an hour (60 minutes) from the counter
     */
    public void subtractHour(){
        if (this.value - 60 < 0) {
            this.value = 0;
        } else {
            this.value -=60;
        }
    }

    /**
     * Subtracts 15 from the counter
     */
    public void subtract(){
        if (this.value - 15 < 0) {
            this.value = 0;
        } else {
            this.value -= 15;
        }
    }

    /**
     * converts the minutes to hours
     * @return hours as a decimal number
     */
    public double getTime() {
        return this.value/60;
    }

    /**
     * divides the minutes by 60 and gives the remainder
     * @return remainder from the division
     */
    public String getMinutes() {
        if (this.value%60 == 0) {
            return "00";
        }else {
            return valueOf(this.value % 60);
        }
    }

    /**
     * Hours as a whole number
     * @return hours as a whole number
     */
    public String getHours() {
        double hoursDouble = this.value/60;
        return valueOf(Math.round(hoursDouble));
    }

    /**
     * Gives hours and minutes separately
     * @return hours and minutes separately
     */
    public String getHourAndMinute(){
        return getHours()+":"+getMinutes();
    }
}
