package com.example.bundletesting.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeAdapter;
import com.example.bundletesting.model.Coffee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class CoffeeFragment extends Fragment {

    private RecyclerView recyclerViewCoffee;
    private CoffeeAdapter coffeeAdapter;
    private FloatingActionButton btnFloating;

    Toolbar toolbar;

    private static final int MY_REQUES_CODE = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);

        recyclerViewCoffee = (RecyclerView) view.findViewById(R.id.rcv_coffee);
        btnFloating = view.findViewById(R.id.btn_floating_coffee);

        coffeeAdapter = new CoffeeAdapter(new CoffeeAdapter.IClickItemCoffee(){
            @Override
            public void addCoffee(Coffee coffee) {
                Toast.makeText(getApplicationContext(), coffee.toString(), Toast.LENGTH_SHORT);
                addCoffeeToTable(coffee);
            }
        });

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffee.setLayoutManager(linearLinearLayoutManager);

        coffeeAdapter.setData(getListCoffee());
        recyclerViewCoffee.setAdapter(coffeeAdapter);

        recyclerViewCoffee.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0){
                    btnFloating.hide();
                }
                else{
                    btnFloating.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        return view;
    }


    private void addCoffeeToTable(Coffee coffee){
        Intent intent = new Intent(this.getContext(), ListCoffeeWAdd.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Coffee", coffee);
        intent.putExtras(bundle);

        startActivityForResult(intent, MY_REQUES_CODE);
    }

    private List<Coffee> getListCoffee(){
        List<Coffee> list = new ArrayList<>();

        list.add(new Coffee(R.drawable.bac_xiu, "Bạc xỉu", "Bạc xỉu ngon", "35000 VND"));
        list.add(new Coffee(R.drawable.cafedenda, "Đen đá", "Đen đá gần ngon", "25000 VND"));
        list.add(new Coffee(R.drawable.capuchino, "Capuchino", "Capuchino hơi ngon", "30000 VND"));
        list.add(new Coffee(R.drawable.cf, "Cà phê truyền thống", "cà phê thượng hạng", "25000 VND"));
        list.add(new Coffee(R.drawable.bac_xiu, "Bạc xỉu", "Bạc xỉu ngon", "35000 VND"));
        list.add(new Coffee(R.drawable.cafedenda, "Đen đá", "Đen đá gần ngon", "25000 VND"));
        list.add(new Coffee(R.drawable.capuchino, "Capuchino", "Capuchino hơi ngon", "30000 VND"));
        list.add(new Coffee(R.drawable.cf, "Cà phê truyền thống", "cà phê thượng hạng", "25000 VND"));

        return list;
    }

}
