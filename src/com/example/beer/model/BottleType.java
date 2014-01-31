package com.example.beer.model;


public class BottleType {
    public double volume;
    public double price;
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BottleType)) return false;

        BottleType that = (BottleType) o;

        if (Double.compare(that.volume, volume) != 0) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
