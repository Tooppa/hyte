package com.example.hyte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Luokka, jolla tallennetaan uneen liittyvät tiedot
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
     * Luo uniolion
     * @param time Nukuttu aika
     * @param happines unenlaatu (1-5)
     * @param minutes kokonaisesti tunnista ylijäävät minuutit
     * @param hours nukuttu aika kokonaisina tunteina
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
     * Antaa käyttäjän asettaman unenlaadun
     * @return Unenlaatu (1-5)
     */
    public String getHappines() {
        return String.valueOf(this.happines);
    }

    /**
     * Antaa käyttäjän asettaman unen määrän
     * @return unen määrä tunteina
     */
    public String getTime() {
        return String.valueOf(this.time);
    }

    /**
     * Antaa nukutut tunnit desimaalilukuna (double)
     * @return nukutut tunnit (double)
     */
    public double getTimeDouble() {
        return this.time;
    }
    /**
     * Antaa nukutut tunnit desimaalilukuna (float) (pylväsdiagrammi tarvitsee luvun floattina)
     * @return nukutut tunnit (float)
     */
    public float getTimeFloat(){
        return (float) this.time;
    }

    /**
     * antaa unenlaadun int muodossa
     * @return unenlaatu int muodossa (1-5)
     */
    public int getHappinesInt() {
        return this.happines;
    }

    /**
     * tulostaa päivämäärän muodossa dd/MM/yyyy, jolloin käyttäjä kirjasi tuloksen
     * @return päivämäärä muodossa dd/MM/yyyy
     */
    public String getSimpleDate() {
        return this.dateFormat;
    }

    /**
     * antaa kuukauden päivän jolloin käyttäjä kirjasi tuloksen
     * @return kuukauden päivä
     */
    public String getDay() {
        return day;
    }

    /**
     * antaa kuukauden numerona jolloin käyttäjä kirjasi tuloksen
     * @return kuukausi
     */
    public String getMonth() {
        return month;
    }

    /**
     * Antaa vuoden jolloin käyttäjä kirjasi tuloksen
     * @return vuosi
     */
    public String getYear() {
        return year;
    }

    /**
     * antaa viikonpäivän
     * @author stackoverflow.com user JDGuide
     * @return viikonpäivä
     */
    public String getWeekDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        String weekDay = new SimpleDateFormat("EE").format(date);
        return weekDay;
    }

    /**
     * antaa viikonpäivän numerona
     * @author stackoverflow.com user Bozho
     * @return viikonpäivä numerona
     */
    public int getWeekDayInt() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    /**
     * Muuttaa olion String muotoon
     * @return lista
     */
    public String toString(){
        String lista = this.hours + " tuntia " + this.minutes + " minuuttia " + " tyytyväisyys " + this.happines + " " + this.dateFormat;
        return lista;
    }
}