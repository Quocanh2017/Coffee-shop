package com.example.bundletesting.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeSelectedAdapter;
import com.example.bundletesting.controller.TableSelectedAdapter;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.CoffeeSelected;
import com.example.bundletesting.model.TableSelected;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ListCoffeeWAdd extends AppCompatActivity {

    private Coffee coffee;
    private Button button;

    private RecyclerView recyclerViewCoffeeSelected;
    private CoffeeSelectedAdapter coffeeSelectedAdapter;

    private RecyclerView recyclerViewTableSelected;
    private TableSelectedAdapter tableSelectedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coffee_w_add);

        recyclerViewCoffeeSelected = (RecyclerView) findViewById(R.id.rcv_coffee_selected);
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(this);

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

        List<Coffee> list = (ArrayList<Coffee>) getIntent().getExtras().getSerializable("Coffee");

        coffeeSelectedAdapter.setData(list);
        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);


        button = findViewById(R.id.btn_add_to_table);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickOpenBottomSheetSelectTable();
            }

        });


        Log.d("size", "onCreate: " + list.size());

//        Toast.makeText(getApplicationContext(), coffee.toString(), Toast.LENGTH_SHORT);

    }

    public void clickOpenBottomSheetSelectTable() {
        TableSelectedView tableSelectedView = new TableSelectedView(new TableSelectedAdapter.IClickItemSelectTable() {
            @Override
            public void SelectedTableItem(TableSelected tableSelected) {
                Log.i("click",tableSelected.getNumberTable().toString());
            }
        });
        //cho nay
        tableSelectedView.a = new ArrayList<>();
        tableSelectedView.show(getSupportFragmentManager(), tableSelectedView.getTag());
    }

    public List<CoffeeSelected> getListCoffeeSelected(){
        List<CoffeeSelected> list = new ArrayList<>();

//        coffee = (Coffee) getIntent().getExtras().get("Coffee");
//
//        list.add(new CoffeeSelected(coffee.getResourceId(), coffee.getName(), coffee.getPrice()));

        return list;
    }


}