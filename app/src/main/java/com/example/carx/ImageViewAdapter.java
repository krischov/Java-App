package com.example.carx;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

//code inspired from tutorial https://www.youtube.com/watch?v=nL0k2usU7I8&ab_channel=PRABEESHRK by PRABEESH R K
//ImageViewAdapter used to populate the viewpager with 3 images of cars
public class ImageViewAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater Inflate;
    private ArrayList<String> picStrings;

    public ImageViewAdapter(Context mContext, ArrayList<String> picStrings) {
        this.mContext = mContext;
        this.picStrings = picStrings;
    }


    //Method templates autogenerated by Android Studio

    @Override
    public int getCount() {
        return picStrings.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //Inflate view
        Inflate = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = Inflate.inflate(R.layout.viewpager, container, false);

        //Find imageview
        ImageView imgView = (ImageView) view.findViewById(R.id.CARPICS);

        //Get the image Resource using the string in picStrings
        int imgResource = mContext.getResources().getIdentifier( picStrings.get(position), "drawable", mContext.getPackageName());
        imgView.setImageResource(imgResource);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
