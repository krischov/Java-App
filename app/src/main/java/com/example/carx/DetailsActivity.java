package com.example.carx;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent a = getIntent();
        Cars carToShow = (Cars)a.getSerializableExtra("Car");
        setContentView(R.layout.details_activity);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }

        String carType;
        if(carToShow.getCarType() == Cars.CarID.SUV) {
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

        TextView Price = (TextView) findViewById(R.id.PRICE);
        Price.setText(carToShow.price.toString());

        TextView Category = (TextView) findViewById(R.id.PRICE);
        Price.setText("NZD$"+ carToShow.price.toString());

        TextView Desc = (TextView) findViewById(R.id.DESCRIPTION);
        Desc.setText(carToShow.description);


    }
}
