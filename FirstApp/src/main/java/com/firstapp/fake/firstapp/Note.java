package com.firstapp.fake.firstapp;

import android.graphics.Color;

/**
 * Created by Fake on 07.11.2016.
 */

public class Note {
    private int number;
    private int color;

    public Note() {
    }

    public Note(int number, int color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
