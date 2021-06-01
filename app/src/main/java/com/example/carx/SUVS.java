package com.example.carx;

import java.util.ArrayList;

import static java.lang.Math.round;

class Suv extends Cars{
    float groundClearance;

    public Suv(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew, float groundClearance){
        super(price, description, name, photos, factoryNew);
        this.groundClearance = groundClearance;
        setCarType(CarID.SUV);
    }

    public String getAdditional() {
        return Float.toString(getGroundClearance());
    }

    public void setGroundClearance(Float groundClearance) {
        this.groundClearance = groundClearance;
    }

    public float getGroundClearance() {
        return groundClearance;
    }


    @Override
    public int compareTo(Cars o) {
        return Integer.compare(round(price), round(o.price));
    }
}
