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
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(this.getContext());

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

//        listAdd = (List<Coffee>) (Serializable) getArguments().getSerializable(GET_TO_TABLE);
//        if(listAdd != null){
//            list = listAdd;
//        }

//        listAdd = getArguments().getParcelableArrayList("add_to_table");

//        list = listAdd;


//        Intent intent = Intent.getIntent();
//        list = (ArrayList<Coffee>) getArguments().getSerializable("add_to_table");
//
//        Bundle bundle = getActivity().getIntent().getExtras();
//        if(bundle != null){
//            listAdd = (List<Coffee>) bundle.get("add_to_coffee");
//            list = listAdd;
//            Toast.makeText(TableAddedFood.this.getContext(),"list " + list.get(0).getName(),Toast.LENGTH_SHORT).show();
//
//        }

//        listAdd = (ArrayList<Coffee>) getArguments().getSerializable("add_to_table");
//        if(listAdd.size() > 0){
//            list = listAdd;
//        }
//        list = listCoffeeWAdd.getSelectedList();

//        listAdd = CoffeeDatabase.getInstance(TableAddedFood.this.getContext()).holdCoffeeDAO().getListHoldCoffeeAdd(table.getNumberTable());
//        if(listAdd != null){
//            list = CoffeeDatabase.getInstance(TableAddedFood.this.getContext()).coffeeDAO().getListCoffeeID(listAdd.get(0).getId());
//        }
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
//        tvPrice.setText(String.valueOf(y) + " VND");

        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);

        btnPayment = view.findViewById(R.id.btn_payment_ok);
        btnPayment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CoffeeDatabase.getInstance(TableAddedFood.this.getContext()).holdCoffeeDAO().deleteAllHoldCoffeeInTable(table.getNumberTable());
                Toast.makeText(TableAddedFood.this.getContext(),table.getNumberTable()+" was payment",Toast.LENGTH_SHORT).show();
            }
        });

        return bottomSheetDialog;
    }
}
