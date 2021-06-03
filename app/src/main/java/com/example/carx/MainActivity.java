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
    class ViewHolder {
        EditText searchView;
        Button searchButton;
        CheckBox suv, jdm, sc;
        RecyclerView rvTopPicks;
        CardView suvCard, scCard, jdmCard;
        public ViewHolder(){
            rvTopPicks = (RecyclerView) findViewById(R.id.rvTopPicks);
            searchButton = findViewById(R.id.search_button);
            suv = findViewById(R.id.suv_cb);
            jdm = findViewById(R.id.jdm_cb);
            sc = findViewById(R.id.sc_cb);
            searchView = findViewById(R.id.search_for_cars);
            suvCard = findViewById(R.id.SUVs);
            scCard = findViewById(R.id.SCs);
            jdmCard = findViewById(R.id.JDMs);
        }
    }
    ArrayList<Cars> cars, totalCars, allSUVs, allJDMs, allSupercars;
    DataProvider dataProvider;
    Boolean jdmVisible, scVisible, suvVisible;
    ViewHolder vh;
    @Override
    protected void onResume(){
        super.onResume();

        // Initialize cars
        cars = dataProvider.getTopPicks(5);
        // Create adapter passing in the sample user data
        TopPicksAdapter adapter = new TopPicksAdapter(this, cars);
        // Attach the adapter to the recyclerview to populate items
        vh.rvTopPicks.setAdapter(adapter);
        // Set layout manager to position the items
        vh.rvTopPicks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dataProvider = new DataProvider();
        vh = new ViewHolder();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
        }

        //This recyclerview was created by following this tutorial: https://guides.codepath.com/android/using-the-recyclerview
        // Lookup the recyclerview in activity layout
        RecyclerView rvTopPicks = (RecyclerView) findViewById(R.id.rvTopPicks);
        // Initialize cars
        cars = dataProvider.getTopPicks(5);
        // Create adapter passing in the sample user data
        TopPicksAdapter adapter = new TopPicksAdapter(this, cars);
        // Attach the adapter to the recyclerview to populate items
        rvTopPicks.setAdapter(adapter);
        // Set layout manager to position the items
        rvTopPicks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        totalCars = dataProvider.getTotalCars();
        allJDMs = DataProvider.getAllJdms();
        allSupercars = DataProvider.getAllHyperCars();
        allSUVs = DataProvider.getAllSuvs();


        //create custom functionality for pressing the enter key on the keyboard
        //reference: https://stackoverflow.com/questions/4451374/use-enter-key-on-softkeyboard-instead-of-clicking-button
        vh.searchView.setOnKeyListener(new View.OnKeyListener()
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



        ScrollView mainScrollView = findViewById(R.id.main_scroll_view);
        jdmVisible = false;
        scVisible = false;
        suvVisible = false;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;

        //animate the three categories to fade in and out when in viewport and outside viewport respectively
        mainScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if(vh.jdmCard.getY() - height + 300 <= mainScrollView.getScrollY() && !jdmVisible){
                    jdmVisible = true;
                    vh.jdmCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                } else if(vh.jdmCard.getY() - height + 300 >= mainScrollView.getScrollY() && jdmVisible){
                    jdmVisible = false;
                    vh.jdmCard.animate()
                            .alpha(0f)
                            .setDuration(1000)
                            .start();
                }
                if(vh.scCard.getY() - height + 300 <= mainScrollView.getScrollY() && !scVisible){
                    scVisible = true;
                    vh.scCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                }else if(vh.scCard.getY() - height + 300 >= mainScrollView.getScrollY() && scVisible){
                    scVisible = false;
                    vh.scCard.animate()
                            .alpha(0f)
                            .setDuration(1000)
                            .start();
                }
                if(vh.suvCard.getY() - height + 300 <= mainScrollView.getScrollY() && !suvVisible){
                    suvVisible = true;
                    vh.suvCard.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start();
                }else if(vh.suvCard.getY() - height + 300 >= mainScrollView.getScrollY() && suvVisible){
                    suvVisible = false;
                    vh.suvCard.animate()
                            .alpha(0f)
                            .setDuration(1000)
                            .start();
                }

            }
        });

    }
    //goes to the list activity and sends all SUVs as data
    public void toSUVListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allSUVs);
        intent.putExtra("SString", "SUV");
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    //goes to the list activity and sends all JDMs as data
    public void toJDMListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allJDMs);
        intent.putExtra("SString", "JDM");
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    //goes to the list activity and sends all SCs as data
    public void toSupercarListActivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", allSupercars);
        intent.putExtra("SString", "SUPERCARS");
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    //goes to the list activity after clicking the search button in the searchbar and sends the relevant cars as data
    public void onSearchQuery(View view) {
        String search = vh.searchView.getText().toString();
        ArrayList<Cars> searchedCars = new ArrayList<>();
        for (int i = 0; i < totalCars.size(); i++) {
            Cars car = totalCars.get(i);
            String name = car.name.toLowerCase();
            if (name.contains(search.toLowerCase())) {
                if (vh.suv.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUV) {
                        searchedCars.add(car);
                    }
                }
                if (vh.jdm.isChecked()) {
                    if (car.getCarType() == Cars.CarID.JDM) {
                        searchedCars.add(car);
                    }
                }
                if (vh.sc.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUPERCAR) {
                        searchedCars.add(car);
                    }
                }
                if (!vh.suv.isChecked() && !vh.jdm.isChecked() && !vh.sc.isChecked()) {
                    searchedCars.add(car);
                }
            }
        }

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", searchedCars);
        intent.putExtra("SString", search);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    //goes to the list activity after pressing enter in the keyboard when searching and sends the relevant cars as data
    protected void onKeyboardEnter(){
        String search = vh.searchView.getText().toString();
        ArrayList<Cars> searchedCars = new ArrayList<>();
        for (int i = 0; i < totalCars.size(); i++) {
            Cars car = totalCars.get(i);
            String name = car.name.toLowerCase();
            if (name.contains(search.toLowerCase())) {
                if (vh.suv.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUV) {
                        searchedCars.add(car);
                    }
                }
                if (vh.jdm.isChecked()) {
                    if (car.getCarType() == Cars.CarID.JDM) {
                        searchedCars.add(car);
                    }
                }
                if (vh.sc.isChecked()) {
                    if (car.getCarType() == Cars.CarID.SUPERCAR) {
                        searchedCars.add(car);
                    }
                }
                if (!vh.suv.isChecked() && !vh.jdm.isChecked() && !vh.sc.isChecked()) {
                    searchedCars.add(car);
                }
            }
        }
        //go to list activity and send matching cars as data
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("Cars", searchedCars);
        intent.putExtra("SString", search);
        this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //this toggles the search filters window (SUV, SC, JDM) when clicking the hamburger button in the searchbar
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