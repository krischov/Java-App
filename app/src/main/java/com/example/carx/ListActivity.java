package com.example.carx;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<Cars> listCars;
    DataProvider dataProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        this.dataProvider = new DataProvider();
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }

        ListView list = (ListView) findViewById(R.id.carList);
        listCars = DataProvider.getTotalCars();

        //custrom array adaptor
        CarListAdaptor listAdaptor = new CarListAdaptor(this, R.layout.custom_list_view, listCars);
        list.setAdapter(listAdaptor);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cars detailCar = (Cars) parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra("Car", listCars.get(position));
                startActivity(intent);
            }
        });
    }
}
