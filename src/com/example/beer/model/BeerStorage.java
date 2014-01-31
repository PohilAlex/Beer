package com.example.beer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class BeerStorage {
    private Map<BottleType, Integer> storage = new LinkedHashMap<BottleType, Integer>();
    private static BeerStorage instance;

    private BeerStorage() {
    }

    public static BeerStorage getInstance() {
        if (instance == null) {
            instance = new BeerStorage();
        }
        return instance;
    }

    public void putBear(BottleType bottleType, int count) {
        for (BottleType b : storage.keySet()) {
            if (b.equals(bottleType)) {
                storage.put(b, storage.get(b) + count);
                return;
            }
        }
        storage.put(bottleType, count);
    }

    public int getBottleCount(BottleType bottleType) {
        return storage.get(bottleType) == null ? 0 : storage.get(bottleType);
    }

    public double getTotalCost() {
        double price = 0;
        for (BottleType type : storage.keySet()) {
            price += storage.get(type) * type.price;
        }
        return price;
    }

    public void clear() {
        storage.clear();
    }

    public ArrayList<ReportItem> getReportList() {
        ArrayList<ReportItem> report = new ArrayList<ReportItem>();
        for (BottleType type : storage.keySet()) {
            ReportItem item = new ReportItem(type, storage.get(type));
            report.add(item);
        }
        return report;
    }

}
