package com.example.carx;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

//Serializable to pass objects between views
//Comparable to sort arraylists using a field e.g. price.

public abstract class Cars implements Serializable, Comparable<Cars> {

    //Enum for carIDs
    enum CarID {
        SUV,
        SUPERCAR,
        JDM
    }

    Float price;
    String description;
    String name;
    int views;
    ArrayList<String> photos;
    boolean factoryNew;
    CarID CarType;


    public Cars(Float price, String description, String name, ArrayList<String> photos, boolean factoryNew) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.photos = photos;
        this.factoryNew = factoryNew;
        this.views = 0;
    }

    public int getViews(int index) {
        return DataProvider.totalCars.get(index).views;
    }

    public void incrementViews(int index) {
        DataProvider.totalCars.get(index).views++;
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

    //Function to get additional information of the child classes.
    public abstract String getAdditional();

}