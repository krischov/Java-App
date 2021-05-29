package com.example.carx;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CarListAdaptor extends ArrayAdapter<Cars> {

    private Context mContext;
    private int mResource;

    //Holds views for lists
    private static class ViewHolder {
        TextView name;
        TextView type;
        TextView price;
        ImageView carPic;
    }

    //default constructor
    public CarListAdaptor(Context context, int resource, ArrayList<Cars> CarList) {
        super(context, resource, CarList);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Gets information that we want to display
        String img = getItem(position).getPhotos().get(0);
        String name = getItem(position).getName();
        String carType;
        if(getItem(position).getCarType() == Cars.CarID.SUV) {
            carType = "SUV";
        }
        else if (getItem(position).getCarType() == Cars.CarID.JDM){
            carType = "JDM";
        }
        else{
            carType = "SUPERCAR";
        }

        String price = getItem(position).getPrice().toString();

        //Create a new viewholder to hold views
        ViewHolder holder = new ViewHolder();

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.type = (TextView) convertView.findViewById(R.id.category);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.carPic = (ImageView) convertView.findViewById(R.id.car_image);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(name);
        holder.type.setText(carType);
        holder.price.setText(price);
        holder.carPic.setImageURI(Uri.parse("android.resource://com.example.carx/drawable/"+ img));

        return convertView;
    }
}
