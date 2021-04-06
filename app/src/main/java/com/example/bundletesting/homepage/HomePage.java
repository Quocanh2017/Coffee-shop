package com.example.bundletesting.homepage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.bundletesting.R;
import com.example.bundletesting.databinding.ContentMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

public class HomePage extends AppCompatActivity {
    private ContentMainBinding binding;
    NavController navController;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
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


    }


}
