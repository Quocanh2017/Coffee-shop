package com.example.bundletesting.view;

import android.os.Bundle;
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
import com.example.bundletesting.databinding.ContentMainBinding;


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
    }

}