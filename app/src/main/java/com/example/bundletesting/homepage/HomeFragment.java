package com.example.bundletesting.homepage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.example.bundletesting.R;
import com.example.bundletesting.databinding.HomeActivityBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    private HomeActivityBinding binding;
    private BottomNavigationView navigationView;
    private ViewPager viewPager;

    private AppBarConfiguration mAppBarConfiguration;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = HomeActivityBinding.inflate(inflater, container, false);

        viewPager = binding.viewPager;
//        navigationView = binding.bottomNav;

//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item){
//                Log.i("Test", "VAO DAY");
//                switch(item.getItemId()){
//                    case R.id.action_home:
//                        Toast.makeText(getContext(), "Home", Toast.LENGTH_SHORT).show();
//                        viewPager.setCurrentItem(0);
//                        break;
//                    case R.id.action_table:
//                        Toast.makeText(getContext(), "Table", Toast.LENGTH_SHORT).show();
//                        viewPager.setCurrentItem(1);
//                        break;
//                    case R.id.action_cf:
//                        Toast.makeText(getContext(), "Coffee", Toast.LENGTH_SHORT).show();
//                        viewPager.setCurrentItem(2);
//                        break;
//                    case R.id.action_profile:
//                        Toast.makeText(getContext(), "Profile", Toast.LENGTH_SHORT).show();
//                        viewPager.setCurrentItem(3);
//                        break;
//                }
//                return true;
//            }
//        });



//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationViewx = findViewById(R.id.nav_view);
//        Navigation.findNavController
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, drawer);
//
//        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.action_profile, R.id.action_noti, R.id.action_setting, R.id.action_logout).setDrawerLayout(drawer).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationViewx, navController);

//        setUpViewPager();
        return binding.getRoot();
    }

//    public void setUpViewPager(){
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPager.setAdapter(viewPagerAdapter);
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
//
//            }
//
//            @Override
//            public void onPageSelected(int position){
//                switch (position){
//                    case 0:
//                        navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
//                        break;
//                    case 1:
//                        navigationView.getMenu().findItem(R.id.action_table).setChecked(true);
//                        break;
//                    case 2:
//                        navigationView.getMenu().findItem(R.id.action_cf).setChecked(true);
//                        break;
//                    case 3:
//                        navigationView.getMenu().findItem(R.id.action_profile).setChecked(true);
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state){
//
//            }
//        });
//    }
}
