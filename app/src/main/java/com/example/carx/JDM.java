package com.example.carx;

import java.util.ArrayList;

import static java.lang.Math.round;

class Jdm extends Cars{
    boolean isModified;

    public Jdm(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew, boolean isModified){
        super(price, description, name, photos, factoryNew);
        this.isModified = isModified;
        setCarType(CarID.JDM);
    }

    public String getAdditional() {
        if(isModified){
            return "YES";
        }
        else return "NO";
    }


    public void setIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @Override
    public int compareTo(Cars o) {
        return Integer.compare(round(price), round(o.price));
    }
}
