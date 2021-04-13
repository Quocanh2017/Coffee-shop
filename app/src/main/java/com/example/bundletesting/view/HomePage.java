package com.example.bundletesting.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.SlideAdapter;
import com.example.bundletesting.databinding.ContentMainBinding;
import com.example.bundletesting.model.SliderItem;
import com.example.bundletesting.view.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomePage extends AppCompatActivity {

    private ContentMainBinding binding;
    NavController navController;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private SlideAdapter slideAdapter;
    private List<SliderItem> listPhoto;
    private Timer timer;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ContentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);

        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build();
        

//        new AppBarConfiguration(toolbar).Builder()
//        AppBarConfiguration appBarConfig = new AppBarConfiguration(Set.of(R.id.home_page), drawerLayout, navController);
//        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfig);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfig);
        NavigationUI.setupWithNavController(binding.bottomNav, navController);
        
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.coffeeFragment) {
                    toolbar.setVisibility(View.GONE);
                    binding.contentMainAppBar.setVisibility(View.GONE);
                }else{
                    toolbar.setVisibility(View.VISIBLE);
                    binding.contentMainAppBar.setVisibility(View.VISIBLE);
                }
            }
        });

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.action_profile){
                    Intent intent = new Intent(HomePage.this, ProfileFragment.class);
                    startActivity(intent);
                }
                if(destination.getId() == R.id.action_logout){
                    Intent intent = new Intent(HomePage.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }

}
