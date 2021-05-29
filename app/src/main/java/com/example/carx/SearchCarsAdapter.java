package com.example.carx;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchCarsAdapter extends ArrayAdapter<Cars> {
    private Context c;
    public SearchCarsAdapter(Context context, ArrayList<Cars> cars) {
        super(context, 0, cars);
        this.c = context;
    }
    public SearchCarsAdapter(Context context) {
        super(context, 0);
        this.c = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Cars car = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_item, parent, false);
        }
        // Lookup view for data population
        TextView carName = (TextView) convertView.findViewById(R.id.car_name_search);
        ImageView carImage = convertView.findViewById(R.id.car_image_search);
        Button viewCar = convertView.findViewById(R.id.view_car_search);
        // Populate the data into the template view using the data object
        carName.setText(car.name);
        carImage.setImageURI(Uri.parse("android.resource://com.example.carx/drawable/"+ car.photos.get(0)));
        // Return the completed view to render on screen
        viewCar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                Intent intent = new Intent(c, DetailsActivity.class);
                c.startActivity(intent);
            }
        });
        return convertView;
    }
}
