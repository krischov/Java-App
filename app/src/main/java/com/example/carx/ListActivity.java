package com.example.carx;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ActionBar actionBar = getSupportActionBar();
        ListView list = (ListView) findViewById(R.id.carList);

        if (actionBar != null) {
            actionBar.setCustomView(R.layout.actionbar_layout);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }

    }
    public void toDetailsActivity(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        this.startActivity(intent);
    }


    //custrom array adaptor
    //ArrayAdapter listAdaptor = new ArrayAdapter(this, android.R.layout)

}
