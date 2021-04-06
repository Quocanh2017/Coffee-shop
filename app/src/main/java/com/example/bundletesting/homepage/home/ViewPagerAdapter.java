//package com.example.bundletesting.homepage.home;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//
//import com.example.bundletesting.homepage.coffee.CoffeeFragment;
//import com.example.bundletesting.homepage.home.HomeFragment;
//import com.example.bundletesting.homepage.profile.ProfileFragment;
//import com.example.bundletesting.homepage.table.TableFragment;
//
//public class ViewPagerAdapter extends FragmentStatePagerAdapter {
//
//    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new HomeFragment();
//            case 1:
//                return new TableFragment();
//            case 2:
//                return new CoffeeFragment();
//            case 3:
//                return new ProfileFragment();
//            default:
//                return new HomeFragment();
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return 4;
//    }
//}
