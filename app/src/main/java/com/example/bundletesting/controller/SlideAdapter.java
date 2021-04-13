package com.example.bundletesting.controller;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.bundletesting.R;
import com.example.bundletesting.model.SliderItem;

import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private List<SliderItem> list;

    public SlideAdapter(Context context, List<SliderItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slide_image_home, container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);

        SliderItem photo = list.get(position);
        if(photo != null){
            Glide.with(context).load(photo.getImageUrl()).into(imgPhoto);
        }

        //add view to viewgroup
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}