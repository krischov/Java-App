package com.example.carx;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListActivity LA;
    ArrayList<Cars> totalCars, allSUVs, allJDMs, allSupercars, listCars;
    EditText searchView;
    CheckBox suv, jdm, sc;
    ListView list;
    LinearLayout noResults;
    protected void onSearchViewChange(){
        String search = searchView.getText().toString();
        ArrayList<Cars> searchedCars = new ArrayList<>();
        for (int i = 0; i < totalCars.size(); i++) {
            Cars car = totalCars.get(i);
            String name = car.name.toLowerCase();
            if (name.contains(search.toLowerCase())) {
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

        CarListAdaptor listAdaptor = new CarListAdaptor(ListActivity.this, R.layout.custom_list_view, searchedCars);
        list.setAdapter(listAdaptor);
        listCars = searchedCars;
        if(listCars.size() == 0) {
            if(noResults.getVisibility() == View.GONE){
                noResults.setVisibility(View.VISIBLE);
                noResults.setAlpha(0);
                noResults.animate()
                        .alpha(1f)
                        .start();
            }
        } else {
            noResults.setAlpha(1);
            noResults.animate()
                    .alpha(0)
                    .start();
            noResults.setVisibility(View.GONE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ActionBar actionBar = getSupportActionBar();
        LA = this;

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        Intent a = getIntent();
        listCars = (ArrayList<Cars>)a.getSerializableExtra("Cars");
        noResults = findViewById(R.id.no_results_layout);
        if(listCars.size() == 0) {
            if(noResults.getVisibility() == View.GONE){
                noResults.setVisibility(View.VISIBLE);
                noResults.setAlpha(0);
                noResults.animate()
                        .alpha(1f)
                        .start();
            }
        } else {
            noResults.setAlpha(1);
            noResults.animate()
                    .alpha(0)
                    .start();
            noResults.setVisibility(View.GONE);
        }
        list = (ListView) findViewById(R.id.carList);

        //custrom array adaptor
        CarListAdaptor listAdaptor = new CarListAdaptor(this, R.layout.custom_list_view, listCars);
        list.setAdapter(listAdaptor);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        searchView.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            onKeyboardEnter();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        suv = findViewById(R.id.suv_cb);
        jdm = findViewById(R.id.jdm_cb);
        sc = findViewById(R.id.sc_cb);
        suv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onSearchViewChange();
            }
        });
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchViewChange();
            }
        });
        jdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchViewChange();
            }
        });
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence search, int start, int before, int count) {
                onSearchViewChange();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void onSearchQuery(View view) {
        onSearchViewChange();
    }
    private void onKeyboardEnter(){
        onSearchViewChange();
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
