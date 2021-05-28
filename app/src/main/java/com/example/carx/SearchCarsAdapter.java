package com.example.carx;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchCarsAdapter extends ArrayAdapter<Cars> {
    public SearchCarsAdapter(Context context, ArrayList<Cars> cars) {
        super(context, 0, cars);
    }
    public SearchCarsAdapter(Context context) {
        super(context, 0);
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
        // Populate the data into the template view using the data object
        carName.setText(car.name);
        carImage.setImageURI(Uri.parse("android.resource://com.example.carx/drawable/"+ car.photos.get(0)));
        // Return the completed view to render on screen
        return convertView;
    }
}
