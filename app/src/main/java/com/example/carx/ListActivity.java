package com.example.carx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("CARX");
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void toDetailsActivity(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        this.startActivity(intent);
    }

}
