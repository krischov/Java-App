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

public class ImageViewAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater Inflate;
    private ArrayList<String> picStrings;

    public ImageViewAdapter(Context mContext, ArrayList<String> picStrings) {
        this.mContext = mContext;
        this.picStrings = picStrings;
    }

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
        Inflate = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = Inflate.inflate(R.layout.viewpager, container, false);
        ImageView imgView = (ImageView) view.findViewById(R.id.CARPICS);
        imgView.setImageResource(mContext.getResources().getIdentifier( picStrings.get(position), "drawable", mContext.getPackageName()));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
