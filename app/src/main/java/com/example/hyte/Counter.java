package com.example.hyte;

import static java.lang.String.valueOf;

/**
 * Luokka sisältää koodia, joka lisää tai vähentää minuutteja riippuen käyttäjä inputista
 * @version 2.0 8.10.2019
 * @author Rush B
 */
public class Counter {
    private int value;

    /**
     * Asettaa laskurin nollaan
     */
    public Counter(){
        this.value = 0;
    }

    /**
     * Lisää laskuriin 15 minuuttia
     */
    public void add(){
        this.value +=15;
    }

    /**
     * Lisää laskuriin 60 minuuttia, eli tunnin
     */
    public void addHour(){
        this.value +=60;
    }

    /**
     * Vähentää laskurista 60 minuuttia, eli tunnin
     */
    public void subtractHour(){
        if (this.value - 60 < 0) {
            this.value = 0;
        } else {
            this.value -=60;
        }
    }

    /**
     * Vähentää laskurista 15 minuuttia
     */
    public void subtract(){
        if (this.value - 15 < 0) {
            this.value = 0;
        } else {
            this.value -= 15;
        }
    }

    /**
     * antaa laskurin tiedon tunteina desimaalilukuna
     * @return tunnit desimaalilukuna
     */
    public double getTime() {
        return this.value/60;
    }

    /**
     * antaa kokonaisen tunnin yli menevät minuutit
     * @return jakojäännös, joka jää kun jaetaan minuutit 60:llä
     */
    public String getMinutes() {
        if (this.value%60 == 0) {
            return "00";
        }else {
            return valueOf(this.value % 60);
        }
    }

    /**
     * Antaa tunnit kokonaislukuna
     * @return tunnit kokonaislukuna
     */
    public String getHours() {
        double hoursDouble = this.value/60;
        return valueOf(Math.round(hoursDouble));
    }

    /**
     * Antaa tunnit ja minuutit erillään
     * @return tunnit ja minuutit erillään
     */
    public String getHourAndMinute(){
        return getHours()+":"+getMinutes();
    }
}
