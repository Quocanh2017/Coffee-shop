package com.example.bundletesting.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bundletesting.R;
import com.example.bundletesting.databinding.HomeActivityBinding;
import com.example.bundletesting.controller.SlideAdapter;
import com.example.bundletesting.model.SliderItem;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private HomeActivityBinding binding;
    private LinearLayout viewPager;

    private ViewPager mViewPager;
    private CircleIndicator circleIndicator;
    private SlideAdapter slideAdapter;
    private List<SliderItem> listPhoto;
    private Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = HomeActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewPager = binding.viewPageHome;

        mViewPager = root.findViewById(R.id.view_pager);
        circleIndicator = root.findViewById(R.id.circle_indicator);

        listPhoto = getListPhoto();
        slideAdapter = new SlideAdapter(this.getContext(), listPhoto);
        mViewPager.setAdapter(slideAdapter);

        circleIndicator.setViewPager(mViewPager);
        slideAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        autoSlideImage();



        return root;
    }

    public List<SliderItem> getListPhoto(){
        List<SliderItem> list = new ArrayList<>();
        list.add(new SliderItem(R.drawable.p1));
        list.add(new SliderItem(R.drawable.p2));
        list.add(new SliderItem(R.drawable.p3));
        list.add(new SliderItem(R.drawable.p4));

        return list;
    }

    private void autoSlideImage(){
        if(listPhoto == null || listPhoto.isEmpty() || viewPager == null){
            return;
        }
        //init timer
        if(timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = mViewPager.getCurrentItem();
                        int totalItem = listPhoto.size() - 1;
                        if(currentItem < totalItem){
                            currentItem++;
                            mViewPager.setCurrentItem(currentItem);
                        }
                        else{
                            mViewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 2000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
