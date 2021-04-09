package com.example.bundletesting.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bundletesting.databinding.HomeActivityBinding;
import com.example.bundletesting.controller.SlideAdapter;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {
    private HomeActivityBinding binding;
    private RelativeLayout viewPager;
    SliderView sliderView;
    private SlideAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = HomeActivityBinding.inflate(inflater, container, false);
        viewPager = binding.viewPageHome;

        return binding.getRoot();
    }

}
