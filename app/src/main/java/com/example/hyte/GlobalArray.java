package com.example.hyte;

import java.util.ArrayList;

public class GlobalArray {


    private static GlobalArray mInstance;
    private ArrayList<Uni> list = null;

    public static GlobalArray getInstance() {
        if (mInstance == null)
            mInstance = new GlobalArray();

        return mInstance;
    }

    private GlobalArray() {
        list = new ArrayList<Uni>();
    }

    public ArrayList<Uni> getArray() {
        return this.list;
    }

    public void addToArray(Uni value) {
        list.add(value);
    }
}