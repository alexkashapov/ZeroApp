package com.firstapp.fake.firstapp;

import android.graphics.Color;

/**
 * Created by Fake on 07.11.2016.
 */

public class Note {
    private String title="";
    private int color = R.color.red;

    public Note() {
    }

    public Note(String title, int color) {
        this.title = title;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
