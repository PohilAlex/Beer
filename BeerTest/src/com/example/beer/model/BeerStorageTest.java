package com.example.beer.model;

import android.test.AndroidTestCase;
import junit.framework.Assert;


public class BeerStorageTest extends AndroidTestCase {

    BeerStorage storage;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        storage = BeerStorage.getInstance();
        storage.clear();
    }

    public void testPutBeer() {
        BottleType bottleType = BottleTypeFactory.createObolonBottle();
        storage.putBear(bottleType, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottleType));
        storage.putBear(bottleType, 1);
        Assert.assertEquals(2, storage.getBottleCount(bottleType));
    }

    public void testPutDiffBeer() {
        BottleType bottleType1 = BottleTypeFactory.createObolonBottle();
        BottleType bottleType2 = BottleTypeFactory.createBudBottle();
        storage.putBear(bottleType1, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottleType1));
        storage.putBear(bottleType2, 1);
        Assert.assertEquals(1, storage.getBottleCount(bottleType1));
        Assert.assertEquals(1, storage.getBottleCount(bottleType2));
    }

    public void testTotalCost() {
        BottleType bottleType1 = BottleTypeFactory.createObolonBottle();
        BottleType bottleType2 = BottleTypeFactory.createBudBottle();

        storage.putBear(bottleType1, 3);
        storage.putBear(bottleType2, 4);
        double price = bottleType1.price * 3 + bottleType2.price * 4;
        Assert.assertEquals(price, storage.getTotalCost());
    }

    public void testEmptyTotalCost() {
        Assert.assertEquals(0d, storage.getTotalCost());
    }

    public void testBottleCount() {
        BottleType bottleType1 = BottleTypeFactory.createObolonBottle();
        BottleType bottleType2 = BottleTypeFactory.createBudBottle();
        storage.putBear(bottleType1, 2);
        Assert.assertEquals(storage.getBottleCount(bottleType1), 2);
        Assert.assertNotNull(storage.getBottleCount(bottleType2));
        Assert.assertEquals(storage.getBottleCount(bottleType2), 0);
    }

    public void testClear() {
        BottleType bottleType = BottleTypeFactory.createObolonBottle();
        storage.putBear(bottleType, 3);
        storage.clear();
        Assert.assertEquals(storage.getBottleCount(bottleType), 0);
    }


}
