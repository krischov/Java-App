package com.example.carx;

import java.util.ArrayList;

class Jdm extends Cars{
    boolean isModified;

    public Jdm(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew, boolean isModified){
        super(price, description, name, photos, factoryNew);
        this.isModified = isModified;
        setCarType(CarID.JDM);
    }

    public boolean getIsModified() {
        return isModified;
    }

    public void setIsModified(boolean isModified) {
        this.isModified = isModified;
    }
}