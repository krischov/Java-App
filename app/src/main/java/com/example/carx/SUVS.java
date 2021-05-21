package com.example.carx;

import java.util.ArrayList;

class Suv extends Cars{
    Float groundClearance;

    public Suv(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew, Float groundClearance){
        super(price, description, name, photos, factoryNew);
        this.groundClearance = groundClearance;
        setCarType(CarID.SUV);
    }

    public Float getGroundClearance() {
        return groundClearance;
    }

    public void setGroundClearance(Float groundClearance) {
        this.groundClearance = groundClearance;
    }
}