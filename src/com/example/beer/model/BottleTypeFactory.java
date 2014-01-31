package com.example.beer.model;

/**
 * Created by Oleg on 21.01.14.
 */
public class BottleTypeFactory {


    public static BottleType createObolonBottle() {
        BottleType bottleType = new BottleType();
        bottleType.name = "Obolon";
        bottleType.price = 3;
        bottleType.volume = 0.5;
        return bottleType;
    }

    public static BottleType createBudBottle() {
        BottleType bottleType = new BottleType();
        bottleType.name = "Bud";
        bottleType.price = 5;
        bottleType.volume = 0.5;
        return bottleType;
    }

}
