package com.example.carx;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class TopPicksAdapter extends
        RecyclerView.Adapter<TopPicksAdapter.ViewHolder> {

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public TopPicksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View topPicksView = inflater.inflate(R.layout.item_top_picks, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(topPicksView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TopPicksAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Cars car = topPicks.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        ImageView imageView = holder.imageCarView;
        LinearLayout topPick = holder.topPick;
        topPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(c, DetailsActivity.class);
                intent.putExtra("Car", car);
                c.startActivity(intent,  ActivityOptions.makeSceneTransitionAnimation((Activity)c).toBundle());
            }
        });
        textView.setText(car.getName());
        imageView.setImageURI(Uri.parse("android.resource://com.example.carx/drawable/"+ car.photos.get(0)));
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return topPicks.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public ImageView imageCarView;
        public LinearLayout topPick;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            imageCarView = itemView.findViewById(R.id.car_image);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            topPick = itemView.findViewById(R.id.top_pick);
        }
    }
    // Store a member variable for the contacts
    private List<Cars> topPicks;
    private Context c;
    // Pass in the contact array into the constructor
    public TopPicksAdapter(Context context, List<Cars> cars ) {
        topPicks = cars;
        c = context;
    }
}