package com.example.bundletesting.view.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.ChangeCoffeeAdapter;
import com.example.bundletesting.controller.ChangeTableAdapter;
import com.example.bundletesting.controller.TableAdapter;
import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.UpdateTable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChangeCoffeeFragment extends Fragment {

    private static final int REQUEST_CODE = 10;
    private EditText editTextName;
    private EditText editTextDes;
    private EditText editTextPrice;
    private Button button;
    private RecyclerView recyclerView;

    private ChangeCoffeeAdapter changeCoffeeAdapter;
    private List<ChangeCoffee> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_coffee, container, false);

        editTextName = view.findViewById(R.id.edit_name_coffee);
        editTextDes = view.findViewById(R.id.edit_des_coffee);
        editTextPrice = view.findViewById(R.id.edit_price_coffee);
        button = view.findViewById(R.id.button_add_coffee);
        recyclerView = view.findViewById(R.id.rcv_change_coffee);

        changeCoffeeAdapter = new ChangeCoffeeAdapter(new ChangeCoffeeAdapter.IClickItemCoffee(){

            @Override
            public void updateCoffee(ChangeCoffee changeCoffee) {
                clickUpdateCoffee(changeCoffee);
            }

            @Override
            public void deleteCoffee(ChangeCoffee changeCoffee) {
                clickDeleteCoffee(changeCoffee);
            }
        });
        list = new ArrayList<>();
        changeCoffeeAdapter.setData(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(changeCoffeeAdapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addCoffee();
            }
        });

        loadData();

        return view;
    }

    private void clickUpdateCoffee(ChangeCoffee changeCoffee){
        Intent intent = new Intent(this.getContext(), UpdateTable.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("change_coffee",changeCoffee);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void clickDeleteCoffee(final ChangeCoffee changeCoffee) {
        new AlertDialog.Builder(this.getContext())
                .setTitle("Confirm delete coffee")
                .setMessage("Are you sure")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Delete table
                        CoffeeDatabase.getInstance(ChangeCoffeeFragment.this.getContext()).changeCoffeeDAO().deleteCoffee(changeCoffee);
                        Toast.makeText(ChangeCoffeeFragment.this.getContext(),"Delete coffee successfully", Toast.LENGTH_SHORT).show();

                        loadData();
                    }
                })
                .setNegativeButton("Canel", null)
                .show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            loadData();
        }
    }

    private void addCoffee() {
        String sCoffeeName = editTextName.getText().toString().trim();
        String sCoffeeDes = editTextDes.getText().toString().trim();
        String sCoffeePrice = editTextPrice.getText().toString().trim();
        if(TextUtils.isEmpty(sCoffeeName) || TextUtils.isEmpty(sCoffeeDes) || TextUtils.isEmpty(sCoffeePrice)){
            return;
        }
        ChangeCoffee changeCoffee = new ChangeCoffee(R.drawable.tabod, sCoffeeName, sCoffeeDes, sCoffeePrice);

        if(isCoffeeExist(changeCoffee)){
            Toast.makeText(this.getContext(),"Add coffee not successfully", Toast.LENGTH_SHORT).show();
            return;
        }

        CoffeeDatabase.getInstance(this.getContext()).changeCoffeeDAO().insertChangeCoffee(changeCoffee);
        Toast.makeText(this.getContext(),"Add coffee successfully", Toast.LENGTH_SHORT).show();

        editTextName.setText("");
        editTextDes.setText("");
        editTextPrice.setText("");

        loadData();

    }

    public boolean isCoffeeExist(ChangeCoffee ChangeCoffee){
        List<ChangeCoffee> listCoffee = CoffeeDatabase.getInstance(this.getContext()).changeCoffeeDAO().checkCoffee(ChangeCoffee.getName());
        return listCoffee != null && !listCoffee.isEmpty();
    }

    private void loadData(){
        //get list table change from room db
        list = CoffeeDatabase.getInstance(this.getContext()).changeCoffeeDAO().getListChangeCoffee();
        changeCoffeeAdapter.setData(list);
    }

}
