package com.example.bundletesting.view;

import android.app.Dialog;
import android.app.DirectAction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeSelectedAdapter;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.HoldCoffee;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.fragment.TableFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TableAddedFood extends BottomSheetDialogFragment {
    private static final String GET_TO_TABLE = "add_to_table";
    private RecyclerView recyclerViewCoffeeSelected;
    private CoffeeSelectedAdapter coffeeSelectedAdapter;

    private TableAddedFood tableAddedFood;

    private List<HoldCoffee> listAdd;

    private Button btnPayment;

    private List<Coffee> list = new ArrayList<>();
    private Table table;

    private View view;
    private TextView tvTime;
    private TextView tvPrice;

    public TableAddedFood(Table table){
        this.table = table;
    }

    public List<Coffee> getList() {
        return list;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);;
        view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_table, null);
        bottomSheetDialog.setContentView(view);

        tvTime = view.findViewById(R.id.tv_time_oder);
        Date currentTime = Calendar.getInstance().getTime();
        tvTime.setText(String.valueOf(currentTime));

        recyclerViewCoffeeSelected = (RecyclerView) view.findViewById(R.id.crv_order);
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(new CoffeeSelectedAdapter.IClickItemCoffeeSelected() {
            @Override
            public void removeCoffeeSelected(Coffee coffeeSelected) {
                Toast.makeText(TableAddedFood.this.getContext(), "Coffee was remove", Toast.LENGTH_SHORT);
                list.remove(coffeeSelected);
                coffeeSelectedAdapter.setData(list);
                recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);
                setText();
                coffeeSelectedAdapter.notifyDataSetChanged();
            }
        });

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

        listAdd = CoffeeDatabase.getInstance(TableAddedFood.this.getContext()).holdCoffeeDAO().getListHoldCoffeeAdd(table.getNumberTable());
        if(listAdd != null){
            for(int i = 0; i<listAdd.size(); i++){
                int x = listAdd.get(i).getResourceID();
                String y = listAdd.get(i).getNameCf();
                String z = listAdd.get(i).getPriceCf();

                list.add(new Coffee(x,y,z));
            }
        }
        coffeeSelectedAdapter.setData(list);

        tvPrice = view.findViewById(R.id.tv_total_price);

        setText();
        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);

        btnPayment = view.findViewById(R.id.btn_payment_ok);
        btnPayment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(list != null){
                    CoffeeDatabase.getInstance(TableAddedFood.this.getContext()).holdCoffeeDAO().deleteAllHoldCoffeeInTable(table.getNumberTable());
                    Toast.makeText(TableAddedFood.this.getContext(),table.getNumberTable()+" was payment",Toast.LENGTH_SHORT).show();
                    dismiss();
                }else{
                    Toast.makeText(TableAddedFood.this.getContext(),table.getNumberTable()+" do not have food to payment",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return bottomSheetDialog;
    }

    public void setText(){
        String[] x;
        double y=0;
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                x = list.get(i).getPrice().split(" ");
                y = y + Double.parseDouble(x[0]);
                Arrays.fill(x, null);
            }
            tvPrice.setText(String.valueOf(y) + " VND");
        }
        else{
            tvPrice.setText("0 VND");
        }
    }

    public boolean checkTrue(){
        if(list != null){
            return true;
        }
        else{
            return false;
        }
    }
}
