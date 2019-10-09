package com.example.hyte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Class where all variables that have to do with sleep are saved into
 * @version 1.0 8.10.2019
 * @author Rush B
 */
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

    /**
     * Creates the sleep object
     * @param time time spent sleeping
     * @param happines the quality of sleep (1-5)
     * @param minutes minutes slept
     * @param hours hours slept
     */
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

    /**
     * returns the quality of sleep given by the user
     * @return quality of sleep (1-5)
     */
    public String getHappines() {
        return String.valueOf(this.happines);
    }

    /**
     * returns the time slept given by the user
     * @return hours slept in hours
     */
    public String getTime() {
        return String.valueOf(this.time);
    }

    /**
     * Returns hours slept as a decimal number (double)
     * @return Hours slept (double)
     */
    public double getTimeDouble() {
        return this.time;
    }
    /**
     * Returns hours slept as a decimal number (float) (bar graph uses float rather than double)
     * @return hours slept (float)
     */
    public float getTimeFloat(){
        return (float) this.time;
    }

    /**
     * Quality of sleep in int mode (1-5)
     * @return Quality of sleep in int (1-5)
     */
    public int getHappinesInt() {
        return this.happines;
    }

    /**
     * Gives the date in dd/MM/yyyy
     * @return Date in dd/MM/yyyy
     */
    public String getSimpleDate() {
        return this.dateFormat;
    }

    /**
     * Gives the day of month when user input is made
     * @return day of month
     */
    public int getDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        int day = c.get(Calendar.DATE);
        return day;
    }

    /**
     * Gives the month when user input is made
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Gives the year when the user input is made
     * @return Year
     */
    public String getYear() {
        return year;
    }

    /**
     * Gives the week day when user input is made
     * @author stackoverflow.com user JDGuide
     * @return week day
     */
    public String getWeekDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        String weekDay = new SimpleDateFormat("EE").format(date);
        return weekDay;
    }

    /**
     * gives the week day as a number
     * @author stackoverflow.com user Bozho
     * @return week day as a number
     */
    public int getWeekDayInt() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    /**
     * Gives the information that is saved to ListView
     * @return information to be saved in ListView
     */
    public String toString(){
        String lista = this.hours + " tuntia " + this.minutes + " minuuttia " + " tyytyväisyys " + this.happines + " " + this.dateFormat;
        return lista;
    }
}