package com.example.bundletesting.homepage.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;

import java.util.ArrayList;
import java.util.List;

public class CoffeeFragment extends Fragment {

    private RecyclerView recyclerViewCoffee;
    private CoffeeAdapter coffeeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);

        recyclerViewCoffee = (RecyclerView) view.findViewById(R.id.rcv_coffee);
        coffeeAdapter = new CoffeeAdapter(this.getContext());

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffee.setLayoutManager(linearLinearLayoutManager);

        coffeeAdapter.setData(getListCoffee());
        recyclerViewCoffee.setAdapter(coffeeAdapter);

        return view;
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
