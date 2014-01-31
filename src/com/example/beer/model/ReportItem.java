package com.example.beer.model;

/**
 * Created by Oleg on 31.01.14.
 */
public class ReportItem {

    public BottleType type;
    public int count;

    public ReportItem(BottleType type, int count) {
        this.type = type;
        this.count = count;
    }
}
