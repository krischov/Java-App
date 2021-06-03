package com.example.carx;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import static com.example.carx.Cars.CarID.SUPERCAR;
import static com.example.carx.Cars.CarID.SUV;
import static java.lang.Boolean.TRUE;

public class DetailsActivity extends AppCompatActivity {
    class ViewHolder {
        TextView carViews, Name, viewed_Category, Price, Desc, FactoryNew, secondProperty;
        ViewPager viewpager;

        public ViewHolder() {
            carViews = (TextView) findViewById(R.id.car_views);
            Name = (TextView) findViewById(R.id.NAME);
            viewed_Category = (TextView) findViewById(R.id.CATEGORY);
            Price = (TextView) findViewById(R.id.PRICE);
            Desc = (TextView) findViewById(R.id.DESCRIPTION);
            FactoryNew = (TextView) findViewById(R.id.ad1);
            secondProperty = (TextView) findViewById(R.id.ad2);
            viewpager = (ViewPager) findViewById(R.id.pager);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Receives information from top picks/list activity
        Intent a = getIntent();
        Cars carToShow = (Cars) a.getSerializableExtra("Car");
        setContentView(R.layout.details_activity);
        vh = new ViewHolder();
        ActionBar actionBar = getSupportActionBar();

        String carName = carToShow.name;
        ArrayList<Cars> totalCars = DataProvider.totalCars;

        //loop to increment views everytime a car is opened in details activity
        for (int i = 0; i < totalCars.size(); i++) {
            String totalCarName = totalCars.get(i).name;
            if (totalCarName.equals(carName)) {
                carToShow.incrementViews(i);

                int totalViews = DataProvider.totalCars.get(i).views;
                vh.carViews.setText(totalViews + (totalViews > 1 ? " Views" : " View"));
                break;
            }
        }

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        String carType;
        if (carToShow.getCarType() == SUV) {
            carType = "SUV";
        } else if (carToShow.getCarType() == Cars.CarID.JDM) {
            carType = "JDM";
        } else {
            carType = "SUPERCAR";
        }

        //Update view name
        vh.Name.setText(carToShow.name);

        //Update view car type
        vh.viewed_Category.setText(carType);

        //Update view price
        vh.Price.setText("NZD$" + carToShow.price.toString());

        //Update view description

        vh.Desc.setText(carToShow.description);

        //Update if car is factory new
        if (carToShow.getFactoryNew() == TRUE) {
            vh.FactoryNew.setText("Factory New: YES");
        } else {
            vh.FactoryNew.setText("Factory New: NO");
        }

        //Show the ground clearance/max speed/customised (Dependent on the car type (SUV/JDM/SUPERCAR)
        String adInfo = carToShow.getAdditional();
        if (carToShow.getCarType() == SUV) {
            vh.secondProperty.setText("Ground Clearance: " + adInfo + " mm");
        } else if (carToShow.getCarType() == SUPERCAR) {
            vh.secondProperty.setText("Maximum Speed: " + adInfo + " km/h");
        } else {
            vh.secondProperty.setText("Customised: " + adInfo);
        }

        //Custom View Pager adapter for showing the 3 images
        ImageViewAdapter ImageAdapter = new ImageViewAdapter(this, carToShow.photos);
        vh.viewpager.setAdapter(ImageAdapter);


    }
}
