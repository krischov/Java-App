package com.example.carx;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DataProvider dataProvider;
    ListActivity LA;
    ArrayList<Cars> totalCars, allSUVs, allJDMs, allSupercars;
    EditText searchView;
    SearchCarsAdapter searchAdapter;
    CheckBox suv, jdm, sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        this.dataProvider = new DataProvider();
        ActionBar actionBar = getSupportActionBar();
        LA = this;

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }
        Intent a = getIntent();
        ArrayList<Cars> listCars = (ArrayList<Cars>)a.getSerializableExtra("Cars");
        ListView list = (ListView) findViewById(R.id.carList);

        //custrom array adaptor
        CarListAdaptor listAdaptor = new CarListAdaptor(this, R.layout.custom_list_view, listCars);
        list.setAdapter(listAdaptor);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cars detailCar = (Cars) parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra("Car", listCars.get(position));
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(LA).toBundle());
            }
        });

        totalCars = DataProvider.getTotalCars();
        allJDMs = DataProvider.getAllJdms();
        allSupercars = DataProvider.getAllHyperCars();
        allSUVs = DataProvider.getAllSuvs();
        searchView = findViewById(R.id.search_for_cars);
        suv = findViewById(R.id.suv_cb);
        jdm = findViewById(R.id.jdm_cb);
        sc = findViewById(R.id.sc_cb);

    }

    public void onSearchQuery(View view) {
        String search = searchView.getText().toString();
        ArrayList<Cars> searchedCars = new ArrayList<>();
        LinearLayout searchFilters = findViewById(R.id.search_filters);
        searchFilters.setVisibility(View.VISIBLE);
        searchFilters.setAlpha(0);
        searchFilters.animate()
                .alpha(1f)
                .start();
        for (int i = 0; i < totalCars.size(); i++) {
            Cars car = totalCars.get(i);
            String name = car.name;
            if (name.contains(search)) {
                if (suv.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUV) {
                        searchedCars.add(car);
                    }
                }
                if (jdm.isChecked()) {
                    if (car.getCarType() == Cars.CarID.JDM) {
                        searchedCars.add(car);
                    }
                }
                if (sc.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUPERCAR) {
                        searchedCars.add(car);
                    }
                }
                if (!suv.isChecked() && !jdm.isChecked() && !sc.isChecked()) {
                    searchedCars.add(car);
                }
            }
        }
        if (searchedCars.size() > 0) {
            searchAdapter = new SearchCarsAdapter(this, searchedCars);
// Attach the adapter to a ListView
            ListView listView = (ListView) findViewById(R.id.lv1);
            listView.setAdapter(searchAdapter);
        } else {
            Toast.makeText(ListActivity.this, "No Match found", Toast.LENGTH_LONG).show();
        }
    }

    public void toggleFilters(View view) {
        LinearLayout searchFilters = findViewById(R.id.search_filters);
        if (searchFilters.getVisibility() == View.GONE) {
            searchFilters.setVisibility(View.VISIBLE);
            searchFilters.setAlpha(0);
            searchFilters.animate()
                    .alpha(1f)
                    .start();
        } else {
            searchFilters.animate()
                    .alpha(0f)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            searchFilters.setVisibility(View.GONE);
                        }
                    })
                    .start();
        }
    }

}
