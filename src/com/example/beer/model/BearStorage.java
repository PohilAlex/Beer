package com.example.beer.model;

import android.R;

import java.util.HashMap;
import java.util.Map;


public class BearStorage {
    private Map<Bottle, Integer> storage = new HashMap<Bottle, Integer>();

    public void putBear(Bottle bottle, int count) {
        for (Bottle b : storage.keySet()) {
            if (b.equals(bottle)) {
                storage.put(b, storage.get(b) + count);
                return;
            }
        }
        storage.put(bottle, count);
    }

    public int getBottleCount(Bottle bottle) {
        return storage.get(bottle);
    }

    public double getTotalCost() {
        double price = 0;
        for (Bottle type : storage.keySet()) {
            price += storage.get(type) * type.price;
        }
        return price;
    }
}
