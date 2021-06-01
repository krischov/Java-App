package com.example.carx;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListActivity extends AppCompatActivity {

    ListActivity LA;
    ArrayList<Cars> totalCars, allSUVs, allJDMs, allSupercars, listCars;
    EditText searchView;
    CheckBox suv, jdm, sc;
    ListView list;
    LinearLayout noResults;
    int RadioFlag = 0;



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

        //Receive information from previous activity (Array List of cars)
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

        //custom array adaptor
        CarListAdaptor listAdaptor = new CarListAdaptor(this, R.layout.custom_list_view, listCars);
        list.setAdapter(listAdaptor);

        //If a list element is clicked, the details activity is opened and the data is passed through.
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

    //Function that toggles if the sort options menu is onscreen or not
    //Controlled by the SORT BUTTON
    public void toggleSortOptions(View view){
        LinearLayout sortFilters = findViewById(R.id.SORTING);
        Button push = findViewById(R.id.SORTBUTTON);

        //drawables for an up and down arrow
        int UPARROW = (R.drawable.ic_baseline_arrow_drop_up_24);
        int DOWNARROW = R.drawable.ic_baseline_arrow_drop_down_24;

        //If the button is clicked and the view is down
        //Open the menu
        if(sortFilters.getVisibility() == View.GONE){
            sortFilters.setVisibility(View.VISIBLE);
            push.setCompoundDrawablesWithIntrinsicBounds(DOWNARROW, 0, 0, 0);
        }
        else{
            //close the menu
            sortFilters.setVisibility(View.GONE);
            push.setCompoundDrawablesWithIntrinsicBounds(UPARROW, 0 , 0 ,0);
        }
    }

    //Code was inspired from: https://developer.android.com/guide/topics/ui/controls/radiobutton
    public void onRadioButtonClicked(View view){
        boolean isClicked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            //If none is clicked, set the flag to 0
            case R.id.NONE:
                if(isClicked){
                    RadioFlag = 0;
                    break;
                }
            //If HIGH to LOW clicked, set the flag to 1
            case R.id.H_L:
                if(isClicked){
                    RadioFlag = 1;
                    break;
                }
            //IF LOW to HIGH clicked, set the flag to 0.
            case R.id.L_H:
                if(isClicked){
                    RadioFlag = 2;
                    break;
                }
        }
    }

    //Function that sorts list either low to high or high to low prices
    public void sortList(View view){

        //Closes the menu when the button is clicked
        toggleSortOptions(view);
        ArrayList<Cars> sortedList = listCars;


        if(RadioFlag == 0){
            //Do nothing
        }

        else if(RadioFlag == 1){
            //SORT PRICE HIGH TO LOW
            Collections.sort(sortedList, new Comparator<Cars>() {
                //This method will sort the array list in terms of object price HIGH TO LOW
                @Override
                public int compare(Cars o1, Cars o2) {
                    return o2.getPrice().compareTo(o1.getPrice());
                }
            });

            //Reopen the list activity using the sorted list
            //Pass the data through to list activity
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("Cars", sortedList);
            this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        else{
            //PRICE LOW TO HIGH
            Collections.sort(sortedList, new Comparator<Cars>() {
                @Override
                //This method will sort the array list in terms of object price LOW TO HIGH
                public int compare(Cars o1, Cars o2) {
                    return o1.getPrice().compareTo(o2.getPrice());
                }
            });

            //Reopen the list activity using the sorted list
            //Pass the data through to list activity
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("Cars", sortedList);
            this.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }

    }
}
