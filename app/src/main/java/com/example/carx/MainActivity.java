package com.example.carx;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cars> contacts, totalCars, allSUVs, allJDMs, allSupercars;
    DataProvider dataProvider;
    EditText searchView;
    Button searchButton;
    Boolean jdmVisible, scVisible, suvVisible;
    CheckBox suv, jdm, sc;
    @Override
    protected void onResume(){
        super.onResume();
        RecyclerView rvTopPicks = (RecyclerView) findViewById(R.id.rvTopPicks);
        // Initialize contacts
        contacts = dataProvider.getTopPicks(5);
        // Create adapter passing in the sample user data
        TopPicksAdapter adapter = new TopPicksAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvTopPicks.setAdapter(adapter);
        // Set layout manager to position the items
        rvTopPicks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
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
        RecyclerView rvTopPicks = (RecyclerView) findViewById(R.id.rvTopPicks);

        // Initialize contacts
        contacts = dataProvider.getTopPicks(5);
        // Create adapter passing in the sample user data
        TopPicksAdapter adapter = new TopPicksAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvTopPicks.setAdapter(adapter);
        // Set layout manager to position the items
        rvTopPicks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        totalCars = dataProvider.getTotalCars();
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

        searchButton = findViewById(R.id.search_button);
        suv = findViewById(R.id.suv_cb);
        jdm = findViewById(R.id.jdm_cb);
        sc = findViewById(R.id.sc_cb);

        CardView suvCard = findViewById(R.id.SUVs);
        CardView scCard = findViewById(R.id.SCs);
        CardView jdmCard = findViewById(R.id.JDMs);
        ScrollView mainScrollView = findViewById(R.id.main_scroll_view);
        jdmVisible = false;
        scVisible = false;
        suvVisible = false;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        mainScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if(jdmCard.getY() - height + 300 <= mainScrollView.getScrollY() && !jdmVisible){
                    jdmVisible = true;
                    jdmCard.setAlpha(0);
                    jdmCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                }
                if(scCard.getY() - height + 300 <= mainScrollView.getScrollY() && !scVisible){
                    scVisible = true;
                    scCard.setAlpha(0);
                    scCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                }
                if(suvCard.getY() - height + 300 <= mainScrollView.getScrollY() && !suvVisible){
                    suvVisible = true;
                    suvCard.setAlpha(0);
                    suvCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                }

            }
        });

    }

    public void toSUVListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allSUVs);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void toJDMListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allJDMs);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void toSupercarListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allSupercars);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void onSearchQuery(View view) {
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

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", searchedCars);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }
    protected void onKeyboardEnter(){
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

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", searchedCars);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
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