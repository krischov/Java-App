package com.example.carx;

import java.util.ArrayList;

class Supercar extends Cars{
    int maxSpeed;

    public Supercar(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew, int maxSpeed){
        super(price, description, name, photos, factoryNew);
        this.maxSpeed = maxSpeed;
        setCarType(CarID.SUPERCAR);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setGroundClearance(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}