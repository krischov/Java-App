package com.example.carx;

import java.util.ArrayList;

public abstract class Cars {

    enum CarID{
        SUV,
        SUPERCAR,
        JDM
    }

    Float price;
    String description;
    String name;
    ArrayList<String> photos;
    boolean factoryNew;
    CarID CarType;


    public Cars(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew)
    {
        this.price = price;
        this.description = description;
        this.name = name;
        this.photos = photos;
        this.factoryNew = factoryNew;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }

    public boolean getFactoryNew() {
        return factoryNew;
    }

    public void setFactoryNew(boolean factoryNew) {
        this.factoryNew = factoryNew;
    }

    public CarID getCarType() {
        return CarType;
    }

    public void setCarType(CarID carType) {
        this.CarType = carType;
    }
}

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