package com.example.beer.model;

import android.test.AndroidTestCase;
import junit.framework.Assert;


public class BearStorageTest extends AndroidTestCase {

    public void testPutBeer() {
        BearStorage storage = new BearStorage();
        Bottle bottle = BottleFactory.createObolonBottle();
        storage.putBear(bottle, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottle));
        storage.putBear(bottle, 1);
        Assert.assertEquals(2, storage.getBottleCount(bottle));
    }

    public void testPutDiffBeer() {
        BearStorage storage = new BearStorage();
        Bottle bottle1 = BottleFactory.createObolonBottle();
        Bottle bottle2 = BottleFactory.createBudBottle();
        storage.putBear(bottle1, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottle1));
        storage.putBear(bottle2, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottle1));
        Assert.assertEquals(1, storage.getBottleCount(bottle2));
    }

    public void testTotalCost() {
        BearStorage storage = new BearStorage();
        Bottle bottle1 = BottleFactory.createObolonBottle();
        Bottle bottle2 = BottleFactory.createBudBottle();

        storage.putBear(bottle1, 3);
        storage.putBear(bottle2, 4);
        double price = bottle1.price * 3 + bottle2.price * 4;
        Assert.assertEquals(price, storage.getTotalCost());
    }

    public void testEmptyTotalCost() {
        BearStorage storage = new BearStorage();
        Assert.assertEquals(0d, storage.getTotalCost());
    }


}
