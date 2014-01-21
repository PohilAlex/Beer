package com.example.beer.model;

/**
 * Created by Oleg on 21.01.14.
 */
public class BottleFactory {


    public static Bottle createObolonBottle() {
        Bottle bottle = new Bottle();
        bottle.name = "Obolon";
        bottle.price = 3;
        bottle.volume = 0.5;
        return bottle;
    }

    public static Bottle createBudBottle() {
        Bottle bottle = new Bottle();
        bottle.name = "Bud";
        bottle.price = 5;
        bottle.volume = 0.5;
        return bottle;
    }
}
