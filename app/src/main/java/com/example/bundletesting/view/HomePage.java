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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.bundletesting.view.fragment.ChangeCoffeeFragment;
import com.example.bundletesting.view.fragment.ChangeTableFragment;
import com.example.bundletesting.view.fragment.HomeFragment;
import com.example.bundletesting.view.fragment.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_HOME = 1;
    private static final int FRAGMENT_CHANGE_COFFEE = 2;
    private static final int FRAGMENT_CHANGE_TABLE = 3;
    private static final int FRAGMENT_PROFILE = 4;

    private int currentFragment = FRAGMENT_HOME;

    private ContentMainBinding binding;
    NavController navController;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ContentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        navigationView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build();


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

        navigationView.setNavigationItemSelectedListener(this);
//        replaceFragment(new HomeFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_profile){
            if(FRAGMENT_PROFILE != currentFragment){
                replaceFragment(new ProfileFragment());
                currentFragment = FRAGMENT_PROFILE;
            }
        }
        else if (id == R.id.action_change_cf){
            if(FRAGMENT_CHANGE_COFFEE != currentFragment){
                replaceFragment(new ChangeCoffeeFragment());
                currentFragment = FRAGMENT_CHANGE_COFFEE;
            }
        }
        else if (id == R.id.action_change_table){
            if(FRAGMENT_CHANGE_TABLE != currentFragment){
                replaceFragment(new ChangeTableFragment());
                currentFragment = FRAGMENT_CHANGE_TABLE;
            }
        }
        else if (id == R.id.action_setting){

        }
        else if (id == R.id.action_logout){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawer_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
