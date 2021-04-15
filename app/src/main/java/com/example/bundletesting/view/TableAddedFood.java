package com.example.bundletesting.view;

import android.app.Dialog;
import android.app.DirectAction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeSelectedAdapter;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.view.fragment.TableFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TableAddedFood extends BottomSheetDialogFragment {
    private RecyclerView recyclerViewCoffeeSelected;
    private CoffeeSelectedAdapter coffeeSelectedAdapter;

    private TableAddedFood tableAddedFood;

    private List<Coffee> listAdd;

    private List<Coffee> list;

    private View view;
    private TextView tvTime;
    private TextView tvPrice;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);;
        view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_table, null);
        bottomSheetDialog.setContentView(view);

//        tvTime = view.findViewById(R.id.tv_time_oder);
//        Date currentTime = Calendar.getInstance().getTime();
//        tvTime.setText(String.valueOf(currentTime));

        recyclerViewCoffeeSelected = (RecyclerView) view.findViewById(R.id.crv_order);
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(this.getContext());

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

//        Intent intent = Intent.getIntent();
//        list = (ArrayList<Coffee>) getArguments().getSerializable("add_to_table");

//        listAdd = (ArrayList<Coffee>) getArguments().getSerializable("add_to_table");
//        if(listAdd.size() > 0){
//            list = listAdd;
//        }
//        list = listCoffeeWAdd.getSelectedList();
        coffeeSelectedAdapter.setData(list);

//        tvPrice = view.findViewById(R.id.tv_total_price);
//        String[] x;
//        double y=0;
//        if(list.size() > 0){
//            for(int i = 0; i < list.size(); i++){
//                x = list.get(i).getPrice().split(" ");
//                y = y + Double.parseDouble(x[0]);
//                Arrays.fill(x, null);
//            }
//        }
//        else{
//            tvPrice.setText("0 VND");
//        }
//        tvPrice.setText(String.valueOf(y) + " VND");

        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);

        return bottomSheetDialog;
    }
}
