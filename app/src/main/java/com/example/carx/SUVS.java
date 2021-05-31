package com.example.carx;

import java.util.ArrayList;

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
}