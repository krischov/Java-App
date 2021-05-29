package com.example.carx;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cars> contacts, totalCars;
    DataProvider dataProvider;
    ListView listView;
    EditText searchView;
    Button searchButton;
    SearchCarsAdapter searchAdapter;
    CheckBox suv, jdm, sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dataProvider = new DataProvider();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
        }
        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = DataProvider.getTopPicks(5);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // That's all!

        //set search view results display
        totalCars = DataProvider.getTotalCars();
        listView = (ListView) findViewById(R.id.lv1);
        searchView = findViewById(R.id.search_for_cars);
        searchButton = findViewById(R.id.search_button);
        suv = findViewById(R.id.suv_cb);
        jdm = findViewById(R.id.jdm_cb);
        sc = findViewById(R.id.sc_cb);
        searchAdapter = new SearchCarsAdapter(this);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lv1);
        listView.setAdapter(searchAdapter);
        // your listview inside scrollview
        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
    }

    public void toListActivity(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", totalCars);
        this.startActivity(intent);
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
            Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
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