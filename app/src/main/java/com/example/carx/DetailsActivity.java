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

import static com.example.carx.Cars.CarID.SUPERCAR;
import static com.example.carx.Cars.CarID.SUV;
import static java.lang.Boolean.TRUE;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent a = getIntent();
        Cars carToShow = (Cars)a.getSerializableExtra("Car");
        setContentView(R.layout.details_activity);
        ActionBar actionBar = getSupportActionBar();
        carToShow.incrementViews();
        Log.d("checking views", "" + carToShow.getViews());
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        String carType;
        if(carToShow.getCarType() == SUV) {
            carType = "SUV";
        }
        else if (carToShow.getCarType() == Cars.CarID.JDM){
            carType = "JDM";
        }
        else{
            carType = "SUPERCAR";
        }

        TextView Name = (TextView) findViewById(R.id.NAME);
        Name.setText(carToShow.name);

        TextView viewed_Category = (TextView) findViewById(R.id.CATEGORY);
        viewed_Category.setText(carType);

        TextView Price = (TextView) findViewById(R.id.PRICE);
        Price.setText("NZD$"+ carToShow.price.toString());

        TextView Desc = (TextView) findViewById(R.id.DESCRIPTION);
        Desc.setText(carToShow.description);

        TextView FactoryNew = (TextView) findViewById(R.id.ad1);
        if(carToShow.getFactoryNew() == TRUE) {
            FactoryNew.setText("Factory New: YES");
        }
        else {
            FactoryNew.setText("Factory New: NO");
        }

        TextView secondProperty = (TextView) findViewById(R.id.ad2);
        String adInfo = carToShow.getAdditional();
        if(carToShow.getCarType() == SUV){
            secondProperty.setText("Ground Clearance: " + adInfo + " mm");
        }
        else if(carToShow.getCarType() == SUPERCAR){
            secondProperty.setText("Maximum Speed: " + adInfo + " km/h");
        }
        else{
            secondProperty.setText("Customised: " + adInfo);
        }



        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
        ImageViewAdapter ImageAdapter = new ImageViewAdapter(this, carToShow.photos);
        viewpager.setAdapter(ImageAdapter);


    }
}
