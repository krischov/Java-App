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

//This adapter code was inspired by the lab document: https://uoa-my.sharepoint.com/personal/ssha631_uoa_auckland_ac_nz/_layouts/15/onedrive.aspx?originalPath=aHR0cHM6Ly91b2EtbXkuc2hhcmVwb2ludC5jb20vOmY6L2cvcGVyc29uYWwvc3NoYTYzMV91b2FfYXVja2xhbmRfYWNfbnovRXVEUlc3OTBiMXRDcWltbVVDOHNKaXdCTnhMWWVKMjRhblllN0pjam9tVDlRZz9ydGltZT11YW1Sb3RZazJVZw&id=%2Fpersonal%2Fssha631%5Fuoa%5Fauckland%5Fac%5Fnz%2FDocuments%2FTeaching%2FCOMPSYS%20302%20Design%20Software%20Practice%2FTutorial%20Slides%2FTutorial%20of%20Book%20Library%20Demo%20App%2Epdf&parent=%2Fpersonal%2Fssha631%5Fuoa%5Fauckland%5Fac%5Fnz%2FDocuments%2FTeaching%2FCOMPSYS%20302%20Design%20Software%20Practice%2FTutorial%20Slides
public class CarListAdaptor extends ArrayAdapter<Cars> {

    private Context mContext;
    private int mResource;

    //Holds views
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

        //Only want to display the first image
        String img = getItem(position).getPhotos().get(0);

        //Name
        String name = getItem(position).getName();

        //If Supercar/JDM/SUV
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

        //Price
        String price = "NZD$" + getItem(position).getPrice().toString();

        //Create a new viewholder to hold views
        ViewHolder holder = new ViewHolder();

        //Check if view is being reused, else inflate the view
        if(convertView == null) {
           //LayoutInflater inflater = LayoutInflater.from(mContext);
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
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
